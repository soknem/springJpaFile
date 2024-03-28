package app.springJPA.service;

import app.springJPA.dto.ProductRequest;
import app.springJPA.dto.ProductResponse;
import app.springJPA.mapper.ProductMapper;
import app.springJPA.model.Product;
import app.springJPA.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceProductImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream().map(productMapper::maptoProductResponse).toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        return  productMapper.maptoProductResponse(
                productRepository.save(productMapper.mapRequestToProduct(productRequest)));
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product=productRepository.findById(id).orElse(null);
        if(product==null){
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
        product=productMapper.mapRequestToProduct(productRequest);
        product.setId(id);
        return productMapper.maptoProductResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        var deletedProduct=productRepository.findById(id).stream().findFirst().orElseThrow();
        productRepository.deleteById(id);
    }
}
