package vod.repository;

import vod.model.Store;
import vod.model.Producer;
import vod.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    Product findById(int id);

    List<Product> findByProducer(Producer d);

    List<Product> findByStore(Store c);

    Product add(Product m);

}
