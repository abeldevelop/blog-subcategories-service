package com.abeldevelop.blog.subcategory.service.service.v1.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.architecture.library.pagination.mapper.PaginationMapper;
import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.repository.SubcategoryRepository;
import com.abeldevelop.blog.subcategory.repository.specification.SubcategorySpecifications;
import com.abeldevelop.blog.subcategory.service.domain.Subcategory;
import com.abeldevelop.blog.subcategory.service.mapper.SubcategoryMapper;
import com.abeldevelop.blog.subcategory.service.mapper.SubcategorySortMapper;
import com.abeldevelop.blog.subcategory.service.service.v1.FindAllSubcategoriesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAllSubcategoriesServiceImpl implements FindAllSubcategoriesService {
    
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;
    private final SubcategorySpecifications subcategorySpecifications;
    private final SubcategorySortMapper subcategorySortMapper;
    private final PaginationMapper paginationMapper;
    
    @Override
    @Transactional(readOnly = true)
    public PaginationResult<Subcategory> executeFindAll(PageIn pageIn, String query) {
        Page<SubcategoryEntity> subcategoryEntityPage = findAll(pageIn, query);
        return new PaginationResult<>(
                paginationMapper.mapPageToPaginationOut(subcategoryEntityPage),
                subcategoryEntityPage.getContent().stream().map(subcategoryMapper::mapEntityToDomain).collect(Collectors.toList()));
    }
    
    private Page<SubcategoryEntity> findAll(PageIn pageIn, String query) {
        PageRequest pageRequest = PageRequest.of(pageIn.getPagination().getPage(), pageIn.getPagination().getSize(), subcategorySortMapper.map(pageIn.getSort()));
        if(query == null || query.isEmpty()) {
            return subcategoryRepository.executeFindAll(subcategorySpecifications.stateEnabled(), pageRequest);
        } else {
            return subcategoryRepository.executeFindAll(subcategorySpecifications.nameLike(query).and(subcategorySpecifications.stateEnabled()), pageRequest);
        }
    }

}
