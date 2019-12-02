package com.abeldevelop.blog.subcategory.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.client.ValidationRequestException;
import com.abeldevelop.blog.subcategory.dto.UpdateSubcategoryRequestResource;
import com.abeldevelop.blog.subcategory.service.util.ErrorCodesConstants;

@Component
public class UpdateSubcategoryRequestResourceValidation implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return UpdateSubcategoryRequestResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(ErrorCodesConstants.SUBCATEGORY_CODE_NOT_NULL);
        }
        UpdateSubcategoryRequestResource updateSubcategoryRequestResource = (UpdateSubcategoryRequestResource) toValidate;
        if(updateSubcategoryRequestResource.getName() == null) {
            throw new ValidationRequestException(ErrorCodesConstants.SUBCATEGORY_NAME_NOT_NULL);
        }
        if(updateSubcategoryRequestResource.getName().length() < 3 || updateSubcategoryRequestResource.getName().length() > 25) {
            throw new ValidationRequestException(ErrorCodesConstants.SUBCATEGORY_NAME_SIZE);
        }
        if(updateSubcategoryRequestResource.getCategoryCode() == null || updateSubcategoryRequestResource.getCategoryCode().isEmpty()) {
            throw new ValidationRequestException(ErrorCodesConstants.CATEGORY_CODE_NOT_NULL);
        }
    }

}
