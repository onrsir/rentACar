package com.onursir.rentACar.Business.Rules;

import com.onursir.rentACar.Core.utilites.BusinessException;
import com.onursir.rentACar.DataAccess.abstracts.BrandDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor // ioc'de zaten var git ordan injection yap. tekrar üretme
@Service
public class BrandBusinessRules {

    private BrandDao brandDao;
    public void checkIfBrandNameExists(String name) { // marka ismi tekrar ediyor mu?

        if (this.brandDao.existsByName(name)) {
            throw new BusinessException("Brand already exists");
        }
    }
}
