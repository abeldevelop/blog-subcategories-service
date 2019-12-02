package com.abeldevelop.blog.subcategory.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.property.enums.States;
import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.repository.SubcategoryRepository;
import com.abeldevelop.blog.subcategory.repository.specification.SubcategorySpecifications;
import com.abeldevelop.blog.subcategory.service.domain.Subcategory;
import com.abeldevelop.blog.subcategory.service.exception.SubcategoryExistException;
import com.abeldevelop.blog.subcategory.service.exception.SubcategoryNotFoundException;
import com.abeldevelop.blog.subcategory.service.mapper.SubcategoryMapper;
import com.abeldevelop.blog.subcategory.service.service.v1.UpdateSubcategoryService;
import com.abeldevelop.blog.subcategory.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateSubcategoryServiceImpl implements UpdateSubcategoryService {
    
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;
    private final SubcategorySpecifications subcategorySpecifications;
    
    
    @Override
    @Transactional
    public Subcategory executeUpdate(String code, Subcategory subcategory) {
        checkIfSubcategoryExist(code);
        checkIfNewSubcategoryExist(subcategory);
        
        subcategoryRepository.executeDeleteById(code);
        SubcategoryEntity newSubcategoryEntity = subcategoryMapper.mapDomainToEntity(subcategory);
        newSubcategoryEntity.setState(States.ENABLED);
        
        return subcategoryMapper.mapEntityToDomain(subcategoryRepository.executeSave(newSubcategoryEntity));
    }
    
    private void checkIfSubcategoryExist(String code) {
        Optional<SubcategoryEntity> subcategoryEntityOptional = subcategoryRepository.executeFindOne(subcategorySpecifications.byCode(code));
        if(!subcategoryEntityOptional.isPresent()) {
            throw new SubcategoryNotFoundException(ErrorCodesConstants.SUBCATEGORY_NOT_FOUND, Arrays.asList(code));
        }
    }
    
    private void checkIfNewSubcategoryExist(Subcategory subcategory) {
        Optional<SubcategoryEntity> categoryEntityOptional = subcategoryRepository.executeFindById(subcategory.getCode());
        if(categoryEntityOptional.isPresent()) {
            throw new SubcategoryExistException(ErrorCodesConstants.SUBCATEGORY_CODE_EXIST, Arrays.asList(subcategory.getName()));
        }
    }

}
