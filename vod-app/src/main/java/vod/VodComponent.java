package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import vod.model.Store;
import vod.repository.StoreDao;
import vod.service.StoreService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final StoreService storeService;

    public VodComponent(StoreService storeService) {this.storeService = storeService;}

    @PostConstruct
    void init() {
        log.info("post construct");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
log.info("on context refreshed");
List<Store> stores = storeService.getAllStores();
log.info("{} stores found", stores.size());
stores.forEach(store->log.info("{}",store));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {log.info("on context refreshed (from annotated method)");}
}
