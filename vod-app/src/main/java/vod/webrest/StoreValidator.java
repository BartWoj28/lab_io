package vod.webrest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Store;
import vod.service.StoreService;

@Component
@RequiredArgsConstructor
public class StoreValidator implements Validator {
    private final StoreService storeService;

    @Override
    public boolean supports(Class<?> clazz) {return clazz.isAssignableFrom(Store.class);}

    @Override
    public void validate(Object target, Errors errors){
        Store validateStore = (Store) target;
        boolean duplicate = storeService.getAllStores().stream()
                .anyMatch(store->store.getName().equalsIgnoreCase(validateStore.getName()));
        if(duplicate){
            errors.rejectValue("name", "store.name.duplicated");
        }
    }

}
