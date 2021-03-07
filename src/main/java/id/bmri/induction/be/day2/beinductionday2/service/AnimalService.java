package id.bmri.induction.be.day2.beinductionday2.service;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    public Integer totalPrice(Integer price, Integer quantity) {
        return price * quantity;
    }
}
