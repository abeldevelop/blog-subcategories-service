package com.abeldevelop.blog.subcategory.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;

public interface SubcategorySpringDataRepository extends JpaRepository<SubcategoryEntity, String>, JpaSpecificationExecutor<SubcategoryEntity> {

}
