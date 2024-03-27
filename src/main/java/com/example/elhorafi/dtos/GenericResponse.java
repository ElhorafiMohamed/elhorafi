package com.example.elhorafi.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GenericResponse<T> {
    private  String message;
    private T data;
    public static <T> GenericResponse<T> success(T data, String message){
        return GenericResponse.<T>builder()
                .message(message)
                .data(data)
                .build();
    }
}
