package com.adm.azs.shipping.infrastructure.converter.modelmapper.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperServiceImp implements ModelMapperService{

    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public <T> T convert(Object data, Class<T> type) {
        return modelMapper.map(data,type);
    }

    @Override
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
            .stream()
            .map(element->modelMapper.map(element, targetClass))
            .collect(Collectors.toList());
    }

}
