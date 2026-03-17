package vod.webrest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class VodActive {
    private final StoreValidator storeValidator;

    @InitBinder("store")
    void InitBinder(WebDataBinder binder){
        binder.addValidators(storeValidator);
    }
}
