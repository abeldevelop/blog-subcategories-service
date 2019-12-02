package com.abeldevelop.blog.subcategory.service.controller.v1;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.architecture.library.common.validation.ValidationFactory;
import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.architecture.library.pagination.mapper.PaginationMapper;
import com.abeldevelop.blog.subcategory.api.v1.SubcategoryApi;
import com.abeldevelop.blog.subcategory.dto.CreateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.dto.SubcategoryPaginationResponseResource;
import com.abeldevelop.blog.subcategory.dto.SubcategoryResponseResource;
import com.abeldevelop.blog.subcategory.dto.SubcategorySort;
import com.abeldevelop.blog.subcategory.dto.UpdateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.service.domain.Subcategory;
import com.abeldevelop.blog.subcategory.service.mapper.SubcategoryMapper;
import com.abeldevelop.blog.subcategory.service.mapper.SubcategorySortMapper;
import com.abeldevelop.blog.subcategory.service.service.v1.CreateSubcategoryService;
import com.abeldevelop.blog.subcategory.service.service.v1.DeleteSubcategoryService;
import com.abeldevelop.blog.subcategory.service.service.v1.FindAllSubcategoriesService;
import com.abeldevelop.blog.subcategory.service.service.v1.FindSubcategoryByCodeService;
import com.abeldevelop.blog.subcategory.service.service.v1.UpdateSubcategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/subcategories")
public class SubcategoryApiController implements SubcategoryApi {

    private final ValidationFactory validationFactory;
    private final SubcategoryMapper subcategoryMapper;
    private final PaginationMapper paginationMapper;
    private final SubcategorySortMapper subcategorySortMapper;
    
    private final CreateSubcategoryService createSubcategoryService;
    private final UpdateSubcategoryService updateSubcategoryService;
    private final DeleteSubcategoryService deleteSubcategoryService;
    private final FindSubcategoryByCodeService findSubcategoryByCodeService;
    private final FindAllSubcategoriesService findAllSubcategoriesService;
    
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubcategoryResponseResource executeCreate(@RequestBody CreateSubcategoryRequestResource createSubcategoryRequestResource) {
        log.info("Data IN executeCreate => createSubcategoryRequestResource: {}", createSubcategoryRequestResource);
        validationFactory.validate(createSubcategoryRequestResource);
        SubcategoryResponseResource subcategoryResponseResource = subcategoryMapper.mapDomainToResource(createSubcategoryService.executeCreate(subcategoryMapper.mapResourceToDomain(createSubcategoryRequestResource)));
        log.info("Data OUT executeCreate => subcategoryResponseResource: {}", subcategoryResponseResource);
        validationFactory.validate(subcategoryResponseResource);
        return subcategoryResponseResource;
    }

    @Override
    @PutMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public SubcategoryResponseResource executeUpdate(@PathVariable("code") String code, @RequestBody UpdateSubcategoryRequestResource updateSubcategoryRequestResource) {
        log.info("Data IN executeUpdate => code: {}, updateSubcategoryRequestResource: {}", code, updateSubcategoryRequestResource);
        validationFactory.validate(updateSubcategoryRequestResource);
        SubcategoryResponseResource subcategoryResponseResource = subcategoryMapper.mapDomainToResource(updateSubcategoryService.executeUpdate(code, subcategoryMapper.mapResourceToDomain(updateSubcategoryRequestResource)));
        log.info("Data OUT executeUpdate => subcategoryResponseResource: {}", subcategoryResponseResource);
        validationFactory.validate(subcategoryResponseResource);
        return subcategoryResponseResource;
    }

    @Override
    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeDelete(@PathVariable("code") String code) {
        log.info("Data IN executeDelete => code: {}", code);
        deleteSubcategoryService.executeDeleteByCode(code);
        log.info("Data OUT executeDelete => code: {}", code);
    }

    @Override
    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public SubcategoryResponseResource executeFindByCode(@PathVariable("code") String code) {
        log.info("Data IN executeFindByCode => code: {}", code);
        
        SubcategoryResponseResource subcategoryResponseResource = subcategoryMapper.mapDomainToResource(findSubcategoryByCodeService.executeFindByCode(code));
        
        log.info("Data IN executeFindByCode => categoryResponseResource: {}", subcategoryResponseResource);
        validationFactory.validate(subcategoryResponseResource);
        return subcategoryResponseResource;
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SubcategoryPaginationResponseResource executeFindAll(
            @RequestParam(name = "page", required = false) Integer page, 
            @RequestParam(name = "size", required = false) Integer size, 
            @RequestParam(name = "sort", required = false) SubcategorySort sort,
            @RequestParam(name = "query", required = false) String query) {
        log.info("Data IN executeFindAll => page: {}, size: {}, sort: {}, query: {}", page, size, sort, query);
        
        PageIn pageRequest = PageIn.builder()
                .pagination(paginationMapper.map(page, size))
                .sort(subcategorySortMapper.map(sort))
                .build();
        
        PaginationResult<Subcategory> paginationResult = findAllSubcategoriesService.executeFindAll(pageRequest, query);
        
        SubcategoryPaginationResponseResource subcategoryPaginationResponseResource = SubcategoryPaginationResponseResource.builder()
                .pagination(paginationMapper.map(paginationResult.getPagination()))
                .subcategories(paginationResult.getResults().stream().map(subcategoryMapper::mapDomainToResource).collect(Collectors.toList()))
                .build();
        
        log.info("Data OUT executeFindAll => subcategoryPaginationResponseResource: {}", subcategoryPaginationResponseResource);
        //TODO validationFactory.validate(categoryPaginationResponseResource)
        return subcategoryPaginationResponseResource;
    }

}
