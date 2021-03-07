package id.bmri.induction.be.day2.beinductionday2.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Animalresponse {

    private String name;
    private String color;
    private Integer totalPrice;
}
