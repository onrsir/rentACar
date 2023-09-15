package com.onursir.rentACar.Business.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIDResponse {
    private int id;
    private String name;

}
