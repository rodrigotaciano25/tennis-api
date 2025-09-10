package com.rodrigo.tennisapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WinnerDTO {
    private String name;
    private int rank;
}
