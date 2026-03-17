package vod.webrest.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Producer;
import vod.model.Product;
import vod.model.Store;
import vod.service.ProductService;
import vod.service.StoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;
    private final StoreService storeService;

    @GetMapping("/products")
    String getProducts(
            Model model,
            @RequestParam(value="storeId", required = false) Integer storeId,
            @RequestParam(value = "producerId", required = false) Integer producerId
    ) {
       log.info("about to display products in store {}", storeId);
       if(storeId != null){
           Store store = storeService.getStoreById(storeId);
           List<Product> products = storeService.getProductsInStore(store);
           model.addAttribute("products", products);
           model.addAttribute("title", "Products in store : " + store.getName());
       }

       if(producerId != null){
        Producer producer = productService.getProducerById(producerId);
        List<Product> products = productService.getProductsByProducer(producer);
        model.addAttribute("products", products);
        model.addAttribute("title", "Products by producer : " + producer.getName());
       }
       else{
           List<Product> products = productService.getAllProducts();
           model.addAttribute("products", products);
           model.addAttribute("title", "All products");
       }
       return "productsView";
    }
}
