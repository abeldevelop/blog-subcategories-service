package com.abeldevelop.blog.subcategory.service.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.pagination.domain.SortDirection;
import com.abeldevelop.architecture.library.pagination.domain.SortIn;
import com.abeldevelop.architecture.library.pagination.mapper.CommonSortDirectionMapper;
import com.abeldevelop.blog.subcategory.dto.SubcategorySort;

@Component
public class SubcategorySortMapper extends CommonSortDirectionMapper<SubcategorySort> {

    @Override
    public SortIn map(SubcategorySort enumSort) {
        if(enumSort != null) {
            if(SubcategorySort.NAME_DESC.getSort().equals(enumSort.getSort())) {
                return new SortIn(SortDirection.DESC, "name");
            }
        }
        //Default Sort
        return new SortIn(SortDirection.DESC, "name");
    }

}
