package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Producer;
import vod.model.Product;
import vod.model.Store;
import vod.repository.ProductDao;

import java.util.List;

@Repository
@Primary
public class JpaProductDao implements ProductDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll(){
        return em.createQuery("select p from Product p").getResultList();
    }

    @Override
    public Product findById(int id){
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findByProducer(Producer p){
        return em
                .createQuery("select pd from Product pd where pd.producer=:producer")
                .setParameter("producer", p)
                .getResultList();
    }

    @Override
    public List<Product> findByStore(Store s){
        return em.createQuery(
                "select pd from Product pd inner join pd.stores store where store=:store")
                .setParameter("store", s)
                .getResultList();
    }

    @Override
    public Product add(Product p){
        em.persist(p);
        return p;
    }

}
