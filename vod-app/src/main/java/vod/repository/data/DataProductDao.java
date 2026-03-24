package vod.repository.data;

//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vod.model.Producer;
import vod.model.Product;
import vod.model.Store;
import vod.repository.ProductDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataProductDao implements ProductDao {

private final ProductRepository productRepository;

@Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
    return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByProducer(Producer p){
    return productRepository.findAllByProducer(p);
    }

    @Override
    public List<Product> findByStore(Store s){
    return productRepository.findAllByStoresContaining(s);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Product add(Product p) {
    return productRepository.save(p);
    }
}
