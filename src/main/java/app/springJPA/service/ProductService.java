package app.springJPA.service;

import app.springJPA.dto.ProductRequest;
import app.springJPA.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(Long id, ProductRequest productRequest);
    void deleteProduct(Long id);
}
