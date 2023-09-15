package com.onursir.rentACar.Business.Services;

import com.onursir.rentACar.Business.DTO.CreateModelRequest;
import com.onursir.rentACar.Business.DTO.GetAllModelsResponse;
import com.onursir.rentACar.Core.utilites.mappers.ModelMapperService;
import com.onursir.rentACar.DataAccess.abstracts.ModelDao;
import com.onursir.rentACar.Entites.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService{

    private ModelDao modelDao;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelDao.findAll();

        List<GetAllModelsResponse> modelsResponses =
                models.stream().map(model->this.modelMapperService.forResponse()
                        .map(model,GetAllModelsResponse.class)).collect(Collectors.toList());


        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelDao.save(model);
    }
}
