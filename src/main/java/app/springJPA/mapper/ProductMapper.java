package app.springJPA.mapper;

import app.springJPA.dto.ProductRequest;
import app.springJPA.dto.ProductResponse;
import app.springJPA.model.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse maptoProductResponse(Product product);
    Product mapRequestToProduct(ProductRequest request);
    @AfterMapping
    default void setId(@MappingTarget Product product){
        if(product.getId()==null){
            product.setId(0L);
        }
    }
}
