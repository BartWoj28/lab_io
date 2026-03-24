package vod.webrest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@Slf4j
@ControllerAdvice(basePackages = "vod.webrest")
@RequiredArgsConstructor
public class VodActive {
    private final StoreValidator storeValidator;
    private final ProductValidator productValidator;

    @InitBinder("store")
    void InitBinder(WebDataBinder binder){
        binder.addValidators(storeValidator);
    }

    @InitBinder("productDTO")
    void initBinder(WebDataBinder binder){
        binder.addValidators(productValidator);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        log.error("illegal argument provided",e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception e){
        log.error(" generic exception",e);
        return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(e.getMessage());
    }
}
