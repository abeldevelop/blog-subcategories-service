package com.abeldevelop.blog.subcategory.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.client.ValidationRequestException;
import com.abeldevelop.blog.subcategory.dto.CreateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.service.util.ErrorCodesConstants;

@Component
public class CreateSubcategoryRequestResourceValidation implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return CreateSubcategoryRequestResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(ErrorCodesConstants.SUBCATEGORY_CODE_NOT_NULL);
        }
        CreateSubcategoryRequestResource createSubcategoryRequestResource = (CreateSubcategoryRequestResource) toValidate;
        if(createSubcategoryRequestResource.getName() == null) {
            throw new ValidationRequestException(ErrorCodesConstants.SUBCATEGORY_NAME_NOT_NULL);
        }
        if(createSubcategoryRequestResource.getName().length() < 3 || createSubcategoryRequestResource.getName().length() > 25) {
            throw new ValidationRequestException(ErrorCodesConstants.SUBCATEGORY_NAME_SIZE);
        }
        if(createSubcategoryRequestResource.getCategoryCode() == null || createSubcategoryRequestResource.getCategoryCode().isEmpty()) {
            throw new ValidationRequestException(ErrorCodesConstants.CATEGORY_CODE_NOT_NULL);
        }
    }

}
