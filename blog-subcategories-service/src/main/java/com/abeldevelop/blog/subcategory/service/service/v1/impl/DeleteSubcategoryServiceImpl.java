package com.abeldevelop.blog.subcategory.service.service.v1.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.property.enums.States;
import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.repository.SubcategoryRepository;
import com.abeldevelop.blog.subcategory.repository.specification.SubcategorySpecifications;
import com.abeldevelop.blog.subcategory.service.exception.SubcategoryNotFoundException;
import com.abeldevelop.blog.subcategory.service.service.v1.DeleteSubcategoryService;
import com.abeldevelop.blog.subcategory.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteSubcategoryServiceImpl implements DeleteSubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final SubcategorySpecifications subcategorySpecifications;
    
    @Override
    @Transactional
    public void executeDeleteByCode(String code) {
        SubcategoryEntity subcategoryEntity = checkIfCategoryExist(code);
        subcategoryEntity.setState(States.PENDING_TO_DELETED);
        subcategoryRepository.executeSave(subcategoryEntity);
    }
    
    private SubcategoryEntity checkIfCategoryExist(String code) {
        return subcategoryRepository.executeFindOne(subcategorySpecifications.byCode(code)).orElseThrow(() -> new SubcategoryNotFoundException(ErrorCodesConstants.SUBCATEGORY_NOT_FOUND, Arrays.asList(code)));
    }

}
