package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class ProductServiceBean implements ProductService {

    private static final Logger log = Logger.getLogger(ProductService.class.getName());

    //@Autowired
    private ProducerDao producerDao;
    private StoreDao storeDao;
    private ProductDao productDao;

    public ProductServiceBean(ProducerDao producerDao, StoreDao storeDao, ProductDao productDao) {
        this.producerDao = producerDao;
        this.storeDao = storeDao;
        this.productDao = productDao;
    }

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

    @Override
    public Product addProduct(Product m) {
        log.info("about to add product " + m);
        return productDao.add(m);
    }

    @Override
    public Producer addProducer(Producer d) {
        log.info("about to add producer " + d);
        return producerDao.add(d);
    }

    @Autowired
    public void setProducerDao(ProducerDao producerDao) {
        this.producerDao = producerDao;
    }
}
