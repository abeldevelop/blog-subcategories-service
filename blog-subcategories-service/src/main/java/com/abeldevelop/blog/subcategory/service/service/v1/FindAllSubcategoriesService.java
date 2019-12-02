package com.abeldevelop.blog.subcategory.service.service.v1;

import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.blog.subcategory.service.domain.Subcategory;

public interface FindAllSubcategoriesService {

    public PaginationResult<Subcategory> executeFindAll(PageIn pageIn, String query);
    
}
