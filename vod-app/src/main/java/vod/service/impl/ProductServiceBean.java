package vod.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import vod.repository.StoreDao;
import vod.repository.ProducerDao;
import vod.repository.ProductDao;
import vod.model.Store;
import vod.model.Producer;
import vod.model.Product;
import vod.service.ProductService;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ProductServiceBean implements ProductService {

    private static final Logger log = Logger.getLogger(ProductService.class.getName());

    //@Autowired
    private final ProducerDao producerDao;
    private final StoreDao storeDao;
    private final ProductDao productDao;
    private final PlatformTransactionManager transactionManager;



    public List<Product> getAllProducts() {
        log.info("searching all products...");
        return productDao.findAll();
    }

    public List<Product> getProductsByProducer(Producer d) {
        log.info("searching products by producers " + d.getId());
        return productDao.findByProducer(d);
    }

    public List<Product> getMoviesInCinema(Store c) {
        log.info("searching products in the store " + c.getId());
        return productDao.findByStore(c);
    }

    public Product getProductById(int id) {
        log.info("searching product by id " + id);
        return productDao.findById(id);
    }

    public List<Store> getAllCinemas() {
        log.info("searching all stores");
        return storeDao.findAll();
    }

    public List<Store> getCinemasByMovie(Product m) {
        log.info("searching stores by products " + m.getId());
        return storeDao.findByProduct(m);
    }

    public Store getCinemaById(int id) {
        log.info("searching store by id " + id);
        return storeDao.findById(id);
    }

    public List<Producer> getAllProducers() {
        log.info("searching all producers");
        return producerDao.findAll();
    }

    public Producer getProducerById(int id) {
        log.info("searching producer by id " + id);
        return producerDao.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Product addProduct(Product p) {
        log.info("about to add product " + p);
        p = productDao.add(p);

        if (p.getName().equals("Apocalypse Now")) {
            throw new RuntimeException("not yet!");
        }

        return p;
    }

    @Override
    public Producer addProducer(Producer d) {
        log.info("about to add producer " + d);
        return producerDao.add(d);
    }

    //@Autowired
   // public void setProducerDao(ProducerDao producerDao) {
     //   this.producerDao = producerDao;
    //}
}
