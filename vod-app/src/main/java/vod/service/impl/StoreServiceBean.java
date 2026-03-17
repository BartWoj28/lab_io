package vod.service.impl;

import org.springframework.stereotype.Service;
import vod.model.Store;
import vod.model.Product;
import vod.repository.StoreDao;
import vod.repository.ProductDao;
import vod.service.StoreService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class StoreServiceBean implements StoreService {

    private static final Logger log = Logger.getLogger(StoreService.class.getName());

    private StoreDao storeDao;
    private ProductDao productDao;

    public StoreServiceBean(StoreDao storeDao, ProductDao productDao) {
        log.info("creating store service bean");
        this.storeDao = storeDao;
        this.productDao = productDao;
    }

    @Override
    public Store getStoreById(int id) {
        log.info("searching store by id " + id);
        return storeDao.findById(id);
    }

    @Override
    public List<Product> getProductsInStore(Store c) {
        log.info("searching products in the store " + c.getId());
        return productDao.findByStore(c);
    }

    @Override
    public List<Store> getAllStores() {
        log.info("searching all stores");
        return storeDao.findAll();
    }

    @Override
    public List<Store> getStoresByProduct(Product m) {
        log.info("searching stores by products " + m.getId());
        return storeDao.findByProduct(m);
    }

    @Override
    public Store addStore(Store store) {
        log.info("adding new store " + store);
        return storeDao.save(store);
    }
}
