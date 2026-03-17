package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.StoreDao;
import vod.model.Store;
import vod.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Repository("storeDao")
//@Primary
public class MemStoreDao implements StoreDao {

    @Override
    public List<Store> findAll() {
        return SampleData.stores;
    }

    @Override
    public Store findById(int id) {
        return SampleData.stores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Store> findByProduct(Product m) {
        return SampleData.stores.stream().filter(c -> c.getProducts().contains(m)).collect(Collectors.toList());
    }

    @Override
    public Store save(Store store) {
        int nextId = SampleData.stores.stream()
                .mapToInt(Store::getId)
                .max()
                .orElse(0)
                + 1;

        store.setId(nextId);
        SampleData.stores.add(store);
        return store;
    }
}
