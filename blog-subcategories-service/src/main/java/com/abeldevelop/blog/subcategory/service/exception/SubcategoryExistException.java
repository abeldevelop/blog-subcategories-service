package com.abeldevelop.blog.subcategory.service.exception;

import java.util.List;

import com.abeldevelop.architecture.library.exception.client.BadRequestException;

public class SubcategoryExistException extends BadRequestException {

    private static final long serialVersionUID = 1715093032715295230L;

    public SubcategoryExistException(String message) {
        super(message);
    }

    public SubcategoryExistException(String message, List<Object> arguments) {
        super(message, arguments);
    }
    
    public SubcategoryExistException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public SubcategoryExistException(String message, List<Object> arguments, Throwable cause) {
        super(message, arguments, cause);
    }
}
