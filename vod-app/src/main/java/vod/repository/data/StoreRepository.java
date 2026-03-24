package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Product;
import vod.model.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {

    List<Store> findAllByNameContaining(String name);

    @Query("select s from Store s inner join s.products product where product=:product")
    List<Store> findAllByProduct(@Param("product") Product product);
}
