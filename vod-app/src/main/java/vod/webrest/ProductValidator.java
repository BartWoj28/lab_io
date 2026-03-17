package vod.webrest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Producer;
import vod.model.Product;
import vod.service.ProductService;
import vod.webrest.dto.ProductDTO;

@Component
@RequiredArgsConstructor
public class ProductValidator implements Validator {

    private final ProductService productService;

    @Override
    public boolean supports(Class<?> clazz) {return clazz.isAssignableFrom(ProductDTO.class);}

    @Override
    public void validate(Object target, Errors errors){
ProductDTO product = (ProductDTO)target;
        Producer producer = productService.getProducerById(product.getProducerId());
        if(producer == null){
            errors.rejectValue("producerId", "product.producer.missing");
        }

    }


}
