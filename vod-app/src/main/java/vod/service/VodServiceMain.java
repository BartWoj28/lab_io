package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.repository.StoreDao;
import vod.repository.ProductDao;
import vod.repository.mem.MemStoreDao;
import vod.repository.mem.MemProductDao;
import vod.model.Store;
import vod.service.impl.StoreServiceBean;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        /*System.out.println("Let's find stores!");
        StoreDao storeDao = new MemStoreDao();
        ProductDao productDao = new MemProductDao();
        StoreService service = new StoreServiceBean(storeDao, productDao);
        List<Store> stores = service.getAllStores();
        System.out.println(stores.size() + " stores found:");
        stores.forEach(System.out::println);*/

        System.out.println("Let's find stores!");
        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        StoreService service = context.getBean(StoreService.class);
        StoreService service2 = context.getBean(StoreService.class);


        List<Store> stores = service.getAllStores();
        System.out.println(stores.size() + " stores found:");
        stores.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string :"+foo);
    }
}
