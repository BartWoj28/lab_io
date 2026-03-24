package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Product;
import vod.model.Store;
import vod.repository.StoreDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataStoreDao implements StoreDao {

    private final StoreRepository storeRepository;

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(int id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Store> findByProduct(Product p){
        return storeRepository.findAllByProduct(p);
    }

    @Override
    public Store save(Store s) {
        return storeRepository.save(s);
    }
}
