package com.abeldevelop.blog.subcategory.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.abeldevelop.blog.subcategory.dto.CreateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.dto.SubcategoryPaginationResponseResource;
import com.abeldevelop.blog.subcategory.dto.SubcategoryResponseResource;
import com.abeldevelop.blog.subcategory.dto.SubcategorySort;
import com.abeldevelop.blog.subcategory.dto.UpdateSubcategoryRequestResource;

@FeignClient("blog-subcategories-service")
public interface BlogSubcategoriesClient {

    @PostMapping("/v1/subcategories")
    public SubcategoryResponseResource executeCreate(@RequestBody CreateSubcategoryRequestResource createSubcategoryRequestResource);

    @PutMapping("/v1/subcategories/{code}")
    public SubcategoryResponseResource executeUpdate(@PathVariable("code") String code, @RequestBody UpdateSubcategoryRequestResource updateSubcategoryRequestResource);

    @DeleteMapping("/v1/subcategories/{code}")
    public void executeDelete(@PathVariable("code") String code);

    @GetMapping("/v1/subcategories/{code}")
    public SubcategoryResponseResource executeFindByCode(@PathVariable("code") String code);

    @GetMapping("/v1/subcategories")
    public SubcategoryPaginationResponseResource executeFindAll(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size, @RequestParam(name = "sort", required = false) SubcategorySort sort, @RequestParam(name = "query", required = false) String query);

}
