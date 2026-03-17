package vod.repository;

import vod.model.Store;
import vod.model.Product;

import java.util.List;

public interface StoreDao {

    List<Store> findAll();

    Store findById(int id);

    List<Store> findByProduct(Product m);

    Store save(Store store);
}
