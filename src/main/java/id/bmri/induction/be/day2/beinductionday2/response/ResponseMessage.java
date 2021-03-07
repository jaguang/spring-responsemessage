package id.bmri.induction.be.day2.beinductionday2.response;

import id.bmri.induction.be.day2.beinductionday2.request.AnimalRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public class ResponseMessage {
    private int code;
    private String message;
    private Animalresponse data;
    private LocalDateTime localDateTime;

    public ResponseMessage(int code, String message, Animalresponse data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.localDateTime = LocalDateTime.now();
    }
    public ResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
        this.localDateTime = LocalDateTime.now();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return message;
    }

    public void setStatus(String status) {
        this.message = status;
    }

    public Animalresponse getData() {
        return data;
    }

    public void setData(Animalresponse data) {
        this.data = data;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public static ResponseMessage responseMessageObject(Animalresponse data) {
        return new ResponseMessage(HttpStatus.OK.value(),null,data);
    }

    public static ResponseMessage responseMessageEntity() {
        return new ResponseMessage(HttpStatus.OK.value(),"OK");
    }

    public static ResponseMessage responseMessageError() {
        return new ResponseMessage(HttpStatus.NO_CONTENT.value(), "Body must not null");
    }
}
