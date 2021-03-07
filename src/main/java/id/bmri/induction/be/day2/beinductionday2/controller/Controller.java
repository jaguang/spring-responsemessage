package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.request.AnimalRequest;
import id.bmri.induction.be.day2.beinductionday2.response.Animalresponse;
import id.bmri.induction.be.day2.beinductionday2.response.ResponseMessage;
import id.bmri.induction.be.day2.beinductionday2.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("example")
@RestController
public class Controller {

    @Autowired
    AnimalService animalService;

    @Autowired
    Animalresponse animalresponse;


    @GetMapping("/{name}")
    public String getExample(@RequestParam String message, @PathVariable String name) {
        return "Hello " + name + " " + message;
    }

    @PostMapping("/name")
    public ResponseMessage addName(@RequestBody String name) {
        if(name == null) {
            return ResponseMessage.responseMessageError();
        }
        return ResponseMessage.responseMessageEntity();
    }

    @PostMapping("/total")
    public ResponseMessage addTotalPriceAnimal(@RequestBody AnimalRequest animalRequest) {
        animalresponse.setName(animalRequest.getName());
        animalresponse.setColor(animalRequest.getColor());
        Integer totalPrice = animalService.totalPrice(animalRequest.getPrice(),animalRequest.getQuantity());
        animalresponse.setTotalPrice(totalPrice);
        Animalresponse data = animalresponse;
        return ResponseMessage.responseMessageObject(data);
    }

}
