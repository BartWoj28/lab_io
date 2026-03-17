package vod.service;

import vod.model.Producer;
import vod.model.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAllProducts();

    List<Product> getProductsByProducer(Producer d);

    Product getProductById(int id);

    Product addProduct(Product m);


    List<Producer> getAllProducers();

    Producer getProducerById(int id);

    Producer addProducer(Producer d);
}
