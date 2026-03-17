package vod.service;

import vod.model.Store;
import vod.model.Product;

import java.util.List;

public interface StoreService {
//api zwraca nam wszystkie kina
    Store getStoreById(int id);

    List<Store> getAllStores();

    List<Store> getStoresByProduct(Product m);

    List<Product> getProductsInStore(Store c);

    Store addStore(Store store);
}
