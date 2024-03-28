package app.springJPA.restconroller;

import app.springJPA.dto.ProductRequest;
import app.springJPA.dto.ProductResponse;
import app.springJPA.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.descriptor.jdbc.ObjectNullResolvingJdbcType;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductRestController {
    private  final ProductService productService;
    private HashMap<String,Object> createResponse(Object data,String messgae,int status){
        HashMap<String,Object> response=new HashMap<>();
        response.put("message",messgae);
        response.put("payload",data);
        response.put("status", status);
        return response;
    }

    @GetMapping("")
    public HashMap<String, Object> getAllProduct(){
        return  createResponse(productService.getAllProduct(),"GET PRODUCT SUCESSFULLY",HttpStatus.OK.value());
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public HashMap<String,Object> createProduct(@Valid @RequestBody  ProductRequest productRequest){
        return  createResponse(productService.createProduct(productRequest),"CREATE PRODUCT SUCESSFULLY",HttpStatus.CREATED.value());

    }
    @PatchMapping("/{id}")
    public HashMap<String, Object> updateProduct(@PathVariable("id") Long id,@Valid @RequestBody ProductRequest productRequest){

        return createResponse(productService.updateProduct(id,productRequest),"UPDATE SUCCESSFULLY",HttpStatus.OK.value());
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Delete(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }
}
