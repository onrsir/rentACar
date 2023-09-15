package com.onursir.rentACar.Business.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandsRequest {
    private String name;
}
// request ve responseler DTO olarak adlandırılır.