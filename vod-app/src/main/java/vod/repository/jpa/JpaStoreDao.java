package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Product;
import vod.model.Store;
import vod.repository.StoreDao;

import java.util.List;

@Repository
public class JpaStoreDao implements StoreDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Store> findAll() {
        return em.createQuery("select s from Store s").getResultList();
    }

    @Override
    public Store findById(int id) {return em.find(Store.class, id);}

    @Override
    public List<Store> findByProduct(Product m){
        return em
                .createQuery("select s from Store s inner join s.products product where product=:product")
                .setParameter("product", m)
                .getResultList();
    }

    @Override
    public Store save(Store store) {
        em.persist(store);
    return store;}
}

