package com.github.owly7.corsionline.web.dto;

public record ErroreDTO(
    int status,
    String message,
    long timestamp
) {

}
