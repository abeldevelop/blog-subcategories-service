package com.abeldevelop.blog.subcategory.service.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.util.StringUtils;
import com.abeldevelop.blog.subcategory.dto.CreateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.dto.SubcategoryResponseResource;
import com.abeldevelop.blog.subcategory.dto.UpdateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.service.domain.Subcategory;

@Component
public class SubcategoryMapper {

	public Subcategory mapResourceToDomain(CreateSubcategoryRequestResource createSubcategoryRequestResource) {
		return Subcategory.builder()
		        .categoryCode(createSubcategoryRequestResource.getCategoryCode())
				.code(StringUtils.generateUrlName(createSubcategoryRequestResource.getName()))
				.name(createSubcategoryRequestResource.getName())
				.build();
	}
	
	public Subcategory mapResourceToDomain(UpdateSubcategoryRequestResource updateSubcategoryRequestResource) {
		return Subcategory.builder()
		        .categoryCode(updateSubcategoryRequestResource.getCategoryCode())
				.code(StringUtils.generateUrlName(updateSubcategoryRequestResource.getName()))
				.name(updateSubcategoryRequestResource.getName())
				.build();
	}
	
	public SubcategoryEntity mapDomainToEntity(Subcategory subcategory) {
		return SubcategoryEntity.builder()
		        .categoryCode(subcategory.getCategoryCode())
				.code(subcategory.getCode())
				.name(subcategory.getName())
				.build();
	}
	
	public Subcategory mapEntityToDomain(SubcategoryEntity subcategoryEntity) {
		return Subcategory.builder()
		        .categoryCode(subcategoryEntity.getCategoryCode())
				.code(subcategoryEntity.getCode())
				.name(subcategoryEntity.getName())
				.build();
	}
	
	public SubcategoryResponseResource mapDomainToResource(Subcategory subcategory) {
		return SubcategoryResponseResource.builder()
		        .categoryCode(subcategory.getCategoryCode())
				.code(subcategory.getCode())
				.name(subcategory.getName())
				.build();
	}
	
}
