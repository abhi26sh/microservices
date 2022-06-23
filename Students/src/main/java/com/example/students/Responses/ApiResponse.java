package com.example.students.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class ApiResponse {
    private String message;
    private boolean flag;


}
