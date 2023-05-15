package com.Backend.Service.Impl;

import com.Backend.Model.Product;
import com.Backend.Repository.ProductRepo;
import com.Backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product saveProduct(Product product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
        Product pdt=productRepo.findById(id).get();
        if(pdt!=null){
            productRepo.delete(pdt);
            return "Delete Successful";
        }

        return "Delete Not Successful";
    }

    @Override
    public Product editProduct(Product product, Integer id) {
        Product pdt=productRepo.findById(id).get();

        pdt.setProductName(product.getProductName());
        pdt.setDescription(product.getDescription());
        pdt.setPrice(product.getPrice());
        pdt.setStatus(product.getStatus());

        productRepo.save(pdt);

        return pdt;
    }
}
