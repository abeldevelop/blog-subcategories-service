package com.abeldevelop.blog.subcategory.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.repository.SubcategoryRepository;
import com.abeldevelop.blog.subcategory.repository.specification.SubcategorySpecifications;
import com.abeldevelop.blog.subcategory.service.domain.Subcategory;
import com.abeldevelop.blog.subcategory.service.exception.SubcategoryNotFoundException;
import com.abeldevelop.blog.subcategory.service.mapper.SubcategoryMapper;
import com.abeldevelop.blog.subcategory.service.service.v1.FindSubcategoryByCodeService;
import com.abeldevelop.blog.subcategory.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindSubcategoryByCodeServiceImpl implements FindSubcategoryByCodeService {
    
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;
    private final SubcategorySpecifications subcategorySpecifications;
    
    @Override
    @Transactional(readOnly = true)
    public Subcategory executeFindByCode(String code) {
        Optional<SubcategoryEntity> subcategoryEntityOptional = subcategoryRepository.executeFindOne(subcategorySpecifications.byCode(code));
        if(!subcategoryEntityOptional.isPresent()) {
            throw new SubcategoryNotFoundException(ErrorCodesConstants.SUBCATEGORY_NOT_FOUND, Arrays.asList(code));
        }
        return subcategoryMapper.mapEntityToDomain(subcategoryEntityOptional.get());
    }

}
