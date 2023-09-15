package com.onursir.rentACar.webAPI.controllers;


import com.onursir.rentACar.Business.DTO.CreateModelRequest;
import com.onursir.rentACar.Business.DTO.GetAllModelsResponse;
import com.onursir.rentACar.Business.Services.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest){ // eğer hata verirse hatayı yakalamak için valid kullandım
        this.modelService.add(createModelRequest);
    }
}
