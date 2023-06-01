package com.example.aviation.dto;

import javax.validation.constraints.Positive;

public class CreateDTO extends ResponseDTO {

    public CreateDTO(Integer statusCode, String message) {
        super(statusCode, message);
    }

}
