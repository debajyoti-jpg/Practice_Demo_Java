package com.Database.Practicedemo.Controller;

import com.Database.Practicedemo.Model.Product;
import com.Database.Practicedemo.Service.ProductService;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    

    @GetMapping("/records")
    public List<Product> records() {
        return productService.productlist();
    }

    @GetMapping("/records/{id}")
    public Product records(@PathVariable int id) {
        return productService.getProductByID(id);
    }

    @PostMapping("/record")
    public Product storeRecord(@RequestBody Product product) {
        return productService.storeProduct(product);
    }

    @DeleteMapping("/record/delete/{id}")
    public void deleteRecord(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/record/saveUpdate")
    public Product saveUpdate(@RequestBody Product product) {

        if(product==null || product.getId()==0){
            throw new PropertyNotFoundException("Product id is null");
        }
        Optional<Product> prod = Optional.ofNullable(productService.getProductByID(product.getId()));

        if(prod.isEmpty()){
            throw new PropertyNotFoundException("Product id is null");

        }

        Product exProd = prod.get();
        exProd.setId(product.getId());
        exProd.setProdName(product.getProdName());
        exProd.setPrice(product.getPrice());

        return productService.storeProduct(product);
    }

    @PatchMapping("/record/patchUpdate")
    public Product patchUpdate(@RequestBody Product product) {

        if(product==null || product.getId()==0){
            throw new PropertyNotFoundException("Product id is null");
        }
        Optional<Product> prod = Optional.ofNullable(productService.getProductByID(product.getId()));

        if(prod.isEmpty()){
            throw new PropertyNotFoundException("Product id is null");

        }

        Product exProd = prod.get();
        exProd.setId(product.getId());
        exProd.setProdName(product.getProdName());
        exProd.setPrice(product.getPrice());

        return productService.storeProduct(product);
    }

}
