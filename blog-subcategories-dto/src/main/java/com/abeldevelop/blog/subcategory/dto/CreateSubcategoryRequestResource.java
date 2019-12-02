package com.abeldevelop.blog.subcategory.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="Create Subcategory resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateSubcategoryRequestResource {

    @ApiModelProperty(notes="Code of category to reference the subcategory", example="first-category", required = true, position = 0)
    @NotNull
    @Size(min = 3, max = 25)
    private String categoryCode;
    
	@ApiModelProperty(notes="Name of the subcategory", example="First Subcategory", required = true, position = 1)
	@NotNull
	@Size(min = 3, max = 25)
	private String name;
	
}
