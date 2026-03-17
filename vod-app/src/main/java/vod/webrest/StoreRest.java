package vod.webrest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Product;
import vod.model.Store;
import vod.service.ProductService;
import vod.service.StoreService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class StoreRest {
    private final StoreService storeService;
    private final ProductService productService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    //private final StoreValidator storeValidator;

    // @InitBinder
    // void InitBinder(WebDataBinder binder){
    //    binder.addValidators(storeValidator);
    //}

    @GetMapping("/stores")
    List<Store> getStores(
            @RequestParam(value="phrase", required=false) String phrase,
            @RequestHeader(value="custom-header", required = false) String customHeader,
            @CookieValue(value="some-cookie", required = false) String someCookie) {
        log.info("about to retrieve stores list");
        log.info("phrase param: {}", phrase);
        log.info("custom header param: {}", customHeader);
        log.info("some-cookie param: {}", someCookie);
        List<Store> stores = storeService.getAllStores();
        log.info("{} stores found",  stores.size());
        return stores;
    }

    @GetMapping("/stores/{id}")
    ResponseEntity<Store> getStore(@PathVariable("id") int id){
        log.info("about to retrieve store by id {}",id);
        Store store = storeService.getStoreById(id);
        log.info("{} store found",store);
if(store!=null){
return  ResponseEntity.status(200).body(store);
}else return ResponseEntity.notFound().build();
    }

    @GetMapping("/products/{productId}/stores")
    ResponseEntity<List<Store>> getStoresByProductId(@PathVariable("productId") int productId){
        log.info("about to retrieve stores by product id {}",productId);
        Product product = productService.getProductById(productId);
        if(product==null) return ResponseEntity.notFound().build();
        else {
            List<Store> stores = storeService.getStoresByProduct(product);
            log.info("there's {} stores found",stores.size());
            return ResponseEntity.ok(stores);
        }
    }

    @PostMapping("/stores")
    ResponseEntity<?> addStore(@Validated @RequestBody Store store, Errors errors, HttpServletRequest request){
        log.info("about to add store {}",store);

        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale ))
                    .reduce("errors\n", (accu, oe)->accu+oe+"\n");
            return ResponseEntity.badRequest().body(errorMessage);
        };
        store = storeService.addStore(store);
        log.info("{} store added",store);
        return ResponseEntity.status(HttpStatus.CREATED).body(store);
    }
}
