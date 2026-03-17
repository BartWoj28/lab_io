package vod.webrest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Product;
import vod.model.Store;
import vod.service.ProductService;
import vod.service.StoreService;
import vod.webrest.dto.ProductDTO;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ProductRest {

    private final StoreService storeService;
    private final ProductService productService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/products")
    List<Product>  getProducts()
    {
        log.info("about to retrieve products");
        List<Product> products = productService.getAllProducts();
        log.info("{} products found", products.size());
        return products;
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") int id){
        log.info("about to retrieve product");
        Product product = productService.getProductById(id);
        log.info("{} product found", product);
        if(product!=null){
            return ResponseEntity.ok(product);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/stores/{storeid}/products")
    ResponseEntity<List<Product>> getProductsByStore(@PathVariable("storeid") int storeid){
        log.info("about to retrieve products stored in store {}",  storeid);
        Store store = storeService.getStoreById(storeid);
        if(store == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
        else{
            List<Product> products = storeService.getProductsInStore(store);
            log.info("there's {} products in store {}", products.size(), store.getName());
            return ResponseEntity.ok(products);
        }
    }

    @PostMapping("/product")
ResponseEntity<?> addProduct(@Validated @RequestBody ProductDTO productDTO, Errors errors, HttpServletRequest request){
        log.info("about to add new product {}", productDTO);

        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale ))
                    .reduce("errors\n", (accu, oe)->accu+oe+"\n");
            return ResponseEntity.badRequest().body(errorMessage);
        };

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setPhoto(productDTO.getPhoto());
        product.setProducer(productService.getProducerById(productDTO.getProducerId()));

        product =  productService.addProduct(product);
        log.info("new product added: {}",  product);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/"+product.getId())
                                .build()
                                .toUri()
                )
                .body(product);
    }

}
