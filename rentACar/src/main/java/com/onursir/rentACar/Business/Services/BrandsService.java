package com.onursir.rentACar.Business.Services;

import com.onursir.rentACar.Business.DTO.CreateBrandsRequest;
import com.onursir.rentACar.Business.DTO.GetAllBrandsResponse;
import com.onursir.rentACar.Business.DTO.GetByIDResponse;
import com.onursir.rentACar.Business.DTO.UpdateBrandRequest;

import java.util.List;
public interface BrandsService {
    List<GetAllBrandsResponse> getAll();
    GetByIDResponse getById(int id);
    void add(CreateBrandsRequest createBrandsRequest);

    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
