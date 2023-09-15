package com.onursir.rentACar.Core.utilites;

public class BusinessException extends RuntimeException {
    public BusinessException(String brandAlreadyExists) {
        super(brandAlreadyExists);
    }
}
