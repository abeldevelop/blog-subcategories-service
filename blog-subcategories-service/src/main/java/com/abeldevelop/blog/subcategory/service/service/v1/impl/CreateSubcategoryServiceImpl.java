package com.abeldevelop.blog.subcategory.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.property.enums.States;
import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.repository.SubcategoryRepository;
import com.abeldevelop.blog.subcategory.service.domain.Subcategory;
import com.abeldevelop.blog.subcategory.service.exception.SubcategoryExistException;
import com.abeldevelop.blog.subcategory.service.mapper.SubcategoryMapper;
import com.abeldevelop.blog.subcategory.service.service.v1.CreateSubcategoryService;
import com.abeldevelop.blog.subcategory.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateSubcategoryServiceImpl implements CreateSubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;
    
    @Override
    @Transactional
    public Subcategory executeCreate(Subcategory subcategory) {
        checkIfSubcategoryExist(subcategory);
        SubcategoryEntity newCategoryEntity = subcategoryMapper.mapDomainToEntity(subcategory);
        newCategoryEntity.setState(States.ENABLED);
        return subcategoryMapper.mapEntityToDomain(subcategoryRepository.executeSave(newCategoryEntity));
    }

    private void checkIfSubcategoryExist(Subcategory subcategory) {
        Optional<SubcategoryEntity> categoryEntityOptional = subcategoryRepository.executeFindById(subcategory.getCode());
        if(categoryEntityOptional.isPresent()) {
            throw new SubcategoryExistException(ErrorCodesConstants.SUBCATEGORY_CODE_EXIST, Arrays.asList(subcategory.getName()));
        }
    }
}
