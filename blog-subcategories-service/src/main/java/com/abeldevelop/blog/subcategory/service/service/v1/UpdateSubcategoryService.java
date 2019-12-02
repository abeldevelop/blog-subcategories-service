package com.abeldevelop.blog.subcategory.service.service.v1;

import com.abeldevelop.blog.subcategory.service.domain.Subcategory;

public interface UpdateSubcategoryService {

    public Subcategory executeUpdate(String code, Subcategory subcategory);
    
}
