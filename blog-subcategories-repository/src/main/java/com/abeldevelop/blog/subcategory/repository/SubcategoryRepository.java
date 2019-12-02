package com.abeldevelop.blog.subcategory.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;

public interface SubcategoryRepository {

    public SubcategoryEntity executeSave(SubcategoryEntity subcategoryEntity);
    
    public Optional<SubcategoryEntity> executeFindById(String id);
    
    public Optional<SubcategoryEntity> executeFindOne(Specification<SubcategoryEntity> spec);
    
    public void executeDeleteById(String code);

    public Page<SubcategoryEntity> executeFindAll(Pageable pageable);
    
    public Page<SubcategoryEntity> executeFindAll(Specification<SubcategoryEntity> spec, Pageable pageable);
    
}
