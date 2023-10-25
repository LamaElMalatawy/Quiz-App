package com.lamaelmalatawy.questionservice.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor // instead of creating a parameterized constructor
public class Response {

    private Integer id;
    private String response;

    public Integer getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }
}
