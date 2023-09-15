package com.onursir.rentACar.Business.Services;

import com.onursir.rentACar.Business.DTO.CreateBrandsRequest;
import com.onursir.rentACar.Business.DTO.GetAllBrandsResponse;
import com.onursir.rentACar.Business.DTO.GetByIDResponse;
import com.onursir.rentACar.Business.DTO.UpdateBrandRequest;
import com.onursir.rentACar.Business.Rules.BrandBusinessRules;
import com.onursir.rentACar.Core.utilites.mappers.ModelMapperService;
import com.onursir.rentACar.DataAccess.abstracts.BrandDao;
import com.onursir.rentACar.Entites.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandsServiceImpl implements BrandsService{
 private BrandDao brandDao;
 private ModelMapperService modelMapperService;
 private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
     List<Brand> brands = brandDao.findAll();

        List<GetAllBrandsResponse> brandsResponses =
                         brands.stream().map(brand->this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());


        return brandsResponses;
    }

    @Override
    public GetByIDResponse getById(int id) {
       Brand brand = this.brandDao.findById(id).orElseThrow();
       GetByIDResponse response = this.modelMapperService.forResponse().map(brand,GetByIDResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandsRequest createBrandsRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandsRequest.getName());

     Brand brand = this.modelMapperService.forRequest().map(createBrandsRequest,Brand.class);
     this.brandDao.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        // update ve create metotları brand'den anlar yani dto değil entity şeklinde göndericem.
        this.brandDao.save(brand);


    }

    @Override
    public void delete(int id) {
        this.brandDao.deleteById(id);

    }
}
