package com.Database.Practicedemo.Service;

import com.Database.Practicedemo.Controller.MyClassException;
import com.Database.Practicedemo.DAO.ProductRepo;
import com.Database.Practicedemo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class ProductServiceImpl implements ProductService{

//    List<Product> product = new ArrayList<Product>(Arrays.asList(new Product(101, "Iphone", 70000),
//            new Product(102, "Iphone Plus", 80000)));
    @Autowired
    ProductRepo repo;

    @Override
    public List<Product> productlist() {

        return repo.findAll();
    }

    @Override
    public Product getProductByID(int id){
        //return product.stream().filter(product -> product.getId() == id).findFirst().orElse(new Product(0, "Not Found",0));

        Product prod = repo.findById(id).orElseThrow(()->new MyClassException("Unable to fetch the records"));

        return prod;

    }

    @Override
    public Product storeProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public void deleteProduct(int id) {
            repo.deleteById(id);


    }
}
