package com.abeldevelop.blog.subcategory.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.abeldevelop.architecture.library.pagination.resource.PaginationResponseResource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@ApiModel(description="Resource with pagination information and subcategories")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubcategoryPaginationResponseResource {

	@ApiModelProperty(notes="Resource with pagination information", required = true, position = 0)
	@NotNull
	private PaginationResponseResource pagination;

	@ApiModelProperty(notes="List of subcategories", required = true, position = 1)
	@Singular
	private List<SubcategoryResponseResource> subcategories;
	
}
