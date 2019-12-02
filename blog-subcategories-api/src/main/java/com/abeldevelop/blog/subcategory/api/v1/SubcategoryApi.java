package com.abeldevelop.blog.subcategory.api.v1;

import org.springframework.web.bind.annotation.PathVariable;

import com.abeldevelop.architecture.library.exception.dto.ErrorResponseResource;
import com.abeldevelop.architecture.starter.api.SpringFoxConfiguration;
import com.abeldevelop.blog.subcategory.dto.CreateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.dto.SubcategoryPaginationResponseResource;
import com.abeldevelop.blog.subcategory.dto.SubcategoryResponseResource;
import com.abeldevelop.blog.subcategory.dto.SubcategorySort;
import com.abeldevelop.blog.subcategory.dto.UpdateSubcategoryRequestResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags= {"Subcategories"})
public interface SubcategoryApi {

	@ApiOperation(value = "Create new subcategory")
	@ApiResponses({ 
		@ApiResponse(code = 201, response = SubcategoryResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_201_MESSAGE), 
		@ApiResponse(code = 400, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_400_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public SubcategoryResponseResource executeCreate(@ApiParam(name="category", value="Category to create", required = true) CreateSubcategoryRequestResource createSubcategoryRequestResource);
	
	@ApiOperation(value = "Update a subcategory")
	@ApiResponses({ 
		@ApiResponse(code = 200, response = SubcategoryResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_200_MESSAGE), 
		@ApiResponse(code = 400, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_400_MESSAGE),
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public SubcategoryResponseResource executeUpdate(
			@ApiParam(name="code", value="Code of the subcategory", required = true, example="first-subcategory") String code,
			@ApiParam(name="subcategory", value="Subcategory to updated", required = true) UpdateSubcategoryRequestResource updateSubcategoryRequestResource);
	
	@ApiOperation(value = "Delete a subcategory")
	@ApiResponses({ 
		@ApiResponse(code = 204, response = Void.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_204_MESSAGE), 
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public void executeDelete(@PathVariable("code") String code);
	
	@ApiOperation(value = "Find subcategory by code")
	@ApiResponses({ 
		@ApiResponse(code = 200, response = SubcategoryResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_200_MESSAGE), 
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public SubcategoryResponseResource executeFindByCode(@ApiParam(name="code", value="Code of the subcategory", required = true, example="first-subcategory") String code);
	
	@ApiOperation(value = "Find all subcategories")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "Number of page", required = false, example="1", defaultValue="1", dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "Size of page", required = false, example="1", defaultValue="10", dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "sort", value = "Field and type to sort the fields", required = false, defaultValue = "NAME_DESC", example="NAME_DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "query", value = "Name or part of subcategory name to search", required = false, example="fir", dataType = "string", paramType = "query")
	})
	@ApiResponses({ 
		@ApiResponse(code = 200, response = SubcategoryPaginationResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_200_MESSAGE),
		@ApiResponse(code = 400, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_400_MESSAGE),
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public SubcategoryPaginationResponseResource executeFindAll(Integer page, Integer size, SubcategorySort sort, String query);
	
}
