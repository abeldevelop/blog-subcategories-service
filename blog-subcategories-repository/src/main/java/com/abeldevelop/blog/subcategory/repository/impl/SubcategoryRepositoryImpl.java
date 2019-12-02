package com.abeldevelop.blog.subcategory.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.repository.SubcategoryRepository;
import com.abeldevelop.blog.subcategory.repository.springdata.SubcategorySpringDataRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SubcategoryRepositoryImpl implements SubcategoryRepository {

    private final SubcategorySpringDataRepository subcategorySpringDataRepository;
    
    @Override
    public SubcategoryEntity executeSave(SubcategoryEntity subcategoryEntity) {
        return subcategorySpringDataRepository.save(subcategoryEntity);
    }

    @Override
    public Optional<SubcategoryEntity> executeFindById(String id) {
        return subcategorySpringDataRepository.findById(id);
    }

    @Override
    public Optional<SubcategoryEntity> executeFindOne(Specification<SubcategoryEntity> spec) {
        return subcategorySpringDataRepository.findOne(spec);
    }

    @Override
    public void executeDeleteById(String code) {
        subcategorySpringDataRepository.deleteById(code);
    }

    @Override
    public Page<SubcategoryEntity> executeFindAll(Pageable pageable) {
        return subcategorySpringDataRepository.findAll(pageable);
    }

    @Override
    public Page<SubcategoryEntity> executeFindAll(Specification<SubcategoryEntity> spec, Pageable pageable) {
        return subcategorySpringDataRepository.findAll(spec, pageable);
    }

}
