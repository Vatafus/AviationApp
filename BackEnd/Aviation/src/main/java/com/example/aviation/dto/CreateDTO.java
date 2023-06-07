package com.example.aviation.dto;

import javax.validation.constraints.Positive;

public class CreateDTO extends ResponseDTO {

    private Long id;
    public CreateDTO(Integer statusCode, String message,Long id) {
        super(statusCode, message);
        this.id = id;
    }

}
