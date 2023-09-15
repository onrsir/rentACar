package com.onursir.rentACar.Core.utilites.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService{
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        this.modelMapper
                .getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE); // gevşek mapleme yapar. response nesnemde 3 tane değer var fakat datamda 5 değer var ise 3 tanesini
                                                                // eşleştirir diğer ikisi boşta kalınca bana hata verme diye yazılır.
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper
                .getConfiguration().setAmbiguityIgnored(true) // belirsizlik olursa ignore et ben sonradan hallederim demek.
                .setMatchingStrategy(MatchingStrategies.STANDARD); // burda ise tüm değerler birbirini eşlemeli
        return this.modelMapper;
    }

}
