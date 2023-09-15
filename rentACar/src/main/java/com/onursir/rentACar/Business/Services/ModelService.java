package com.onursir.rentACar.Business.Services;

import com.onursir.rentACar.Business.DTO.CreateModelRequest;
import com.onursir.rentACar.Business.DTO.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);

}
