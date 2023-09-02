package com.example.productmanagmentmodule.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse<T> {
    private Integer status;
    private String statusText;
    private String url;
    private T body;

    public HttpResponse(Integer status, T body) {
        this.status = status;
        this.body = body;
    }
}
