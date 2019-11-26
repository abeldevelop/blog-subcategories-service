package com.abeldevelop.blog.subcategory.service.service.impl;


import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.error.DefaultErrorMessageService;

@Component
public class ErrorMessageServiceImpl extends DefaultErrorMessageService {

    public ErrorMessageServiceImpl() {
        addMessagesToMap();
    }

	private void addMessagesToMap() {
		
	}
}
