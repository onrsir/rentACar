package com.onursir.rentACar.webAPI.controllers;

import com.onursir.rentACar.Business.DTO.CreateBrandsRequest;
import com.onursir.rentACar.Business.DTO.GetAllBrandsResponse;
import com.onursir.rentACar.Business.DTO.GetByIDResponse;
import com.onursir.rentACar.Business.DTO.UpdateBrandRequest;
import com.onursir.rentACar.Business.Services.BrandsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandsService brandsService;

   /* @Autowired bunun yerine allargsconstructor kullanıyoruz
    public BrandsController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }
*/

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandsService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(CreateBrandsRequest createBrandsRequest){
        this.brandsService.add(createBrandsRequest);
    }
    @GetMapping("/{id}")
    public GetByIDResponse getById(@PathVariable int id){ //pathVariable path'den al demektir
        return brandsService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        this.brandsService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandsService.delete(id);
    }

}
