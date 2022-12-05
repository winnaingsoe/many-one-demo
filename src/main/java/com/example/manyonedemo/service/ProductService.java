package com.example.manyonedemo.service;

import com.example.manyonedemo.dao.CategoryDao;
import com.example.manyonedemo.dao.ProductDao;
import com.example.manyonedemo.ds.Category;
import com.example.manyonedemo.ds.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private ProductDao productDao;
    private CategoryDao categoryDao;

    @Transactional
    public void createDb() {
        Category category1 = new Category();
        category1.setName("Fruit");

        Category category2 = new Category();
        category2.setName("Meat");

        Product product1 = new Product("Apple", 2, 1000);
        Product product2 = new Product("Orange", 2, 20000);

        Product product3 = new Product("Fish", 2, 10000);
        Product product4 = new Product("Chicken", 4, 15000);

        category1.addProduct(product1);
        category1.addProduct(product2);
        category2.addProduct(product3);
        category2.addProduct(product4);

        categoryDao.save(category1);
        categoryDao.save(category2);
    }
}
