package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Producer;
import vod.model.Product;
import vod.model.Store;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByProducer(Producer p);

    List<Product> findAllByStoresContaining(Store s);
}
