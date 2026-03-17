package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Product;
import vod.model.Store;
import vod.repository.StoreDao;

import java.util.List;
//@Component
public class DummyStoreDao implements StoreDao {
    @Override
    public List<Store> findAll() {
        return List.of();
    }

    @Override
    public Store findById(int id) {
        return null;
    }

    @Override
    public List<Store> findByProduct(Product m) {
        return List.of();
    }

    @Override
    public Store save(Store store) {
        return null;
    }
}
