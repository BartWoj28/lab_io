package vod.webrest.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Product;
import vod.model.Store;
import vod.service.ProductService;
import vod.service.StoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StoreController {
    private final StoreService storeService;
    private final ProductService productService;

    @GetMapping("/stores")
    String getStores(
            Model model,
            @RequestParam (value="productId" , required = false) Integer productId)
    {
        log.info("about to display stores list with product {}", productId);
        if(productId != null){
            Product product = productService.getProductById(productId);
            List<Store> stores = storeService.getStoresByProduct(product);
            model.addAttribute("stores", stores);
            model.addAttribute("title", "Stores with product " + product.getName()+"'");
        } else{
            List<Store> stores = storeService.getAllStores();
            model.addAttribute("stores", stores);
            model.addAttribute("title", "All stores'");
        }


        return "storesView";
    }

}
