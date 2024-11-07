package com.example.demo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponceDTO {
     private String  ip;
     private int port;

    public ApiResponceDTO(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
