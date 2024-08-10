package com.Database.Practicedemo.Service;

import com.Database.Practicedemo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    abstract List<Product> productlist();

    abstract Product getProductByID(int id);

    abstract Product storeProduct(Product product);

    abstract void deleteProduct(int id);
}
