package com.abeldevelop.blog.subcategory.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.server.ValidationResponseException;
import com.abeldevelop.blog.subcategory.dto.SubcategoryResponseResource;
import com.abeldevelop.blog.subcategory.service.util.ErrorCodesConstants;

@Component
public class SubcategoryResponseResourceValidation implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return SubcategoryResponseResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationResponseException(ErrorCodesConstants.SUBCATEGORY_NOT_NULL);
        }

        SubcategoryResponseResource subcategoryResponseResource = (SubcategoryResponseResource) toValidate;
        
        if(subcategoryResponseResource.getCategoryCode() == null) {
            throw new ValidationResponseException(ErrorCodesConstants.CATEGORY_CODE_NOT_NULL);
        }
        
        if(subcategoryResponseResource.getCode() == null) {
            throw new ValidationResponseException(ErrorCodesConstants.SUBCATEGORY_CODE_NOT_NULL);
        }
        
        if(subcategoryResponseResource.getCode().length() < 3 || subcategoryResponseResource.getCode().length() > 25) {
            throw new ValidationResponseException(ErrorCodesConstants.SUBCATEGORY_CODE_SIZE);
        }
        
        if(subcategoryResponseResource.getName() == null) {
            throw new ValidationResponseException(ErrorCodesConstants.SUBCATEGORY_CODE_NOT_NULL);
        }
        
        if(subcategoryResponseResource.getName().length() < 3 || subcategoryResponseResource.getName().length() > 25) {
            throw new ValidationResponseException(ErrorCodesConstants.SUBCATEGORY_CODE_SIZE);
        }
        
    }

}
