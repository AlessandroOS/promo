package com.alessandro.promo.validations;

import com.alessandro.promo.models.Promo;
import org.springframework.stereotype.Component;

@Component
public class PromoValidator {

    public boolean validate(Promo promo) {
        if (promo.getPreco() == null || promo.getPreco().isNaN()) {
            return false;
        } else if (promo.getDescricao() == null || promo.getDescricao().isBlank()) {
            return false;
        } else return promo.getLink() != null && !promo.getLink().isBlank();
    }
}
