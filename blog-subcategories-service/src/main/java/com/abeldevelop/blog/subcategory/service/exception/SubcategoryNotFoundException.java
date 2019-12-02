package com.abeldevelop.blog.subcategory.service.exception;

import java.util.List;

import com.abeldevelop.architecture.library.exception.client.NotFoundException;

public class SubcategoryNotFoundException extends NotFoundException {

    private static final long serialVersionUID = 4219512666464137957L;

    public SubcategoryNotFoundException(String message) {
        super(message);
    }

    public SubcategoryNotFoundException(String message, List<Object> arguments) {
        super(message, arguments);
    }
    
    public SubcategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public SubcategoryNotFoundException(String message, List<Object> arguments, Throwable cause) {
        super(message, arguments, cause);
    }
}
