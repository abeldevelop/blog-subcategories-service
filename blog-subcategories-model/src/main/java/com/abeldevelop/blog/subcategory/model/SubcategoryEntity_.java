package com.abeldevelop.blog.subcategory.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.abeldevelop.architecture.library.property.enums.States;

@StaticMetamodel(SubcategoryEntity.class)
public class SubcategoryEntity_ {

	public static volatile SingularAttribute<SubcategoryEntity, String> code;
	public static volatile SingularAttribute<SubcategoryEntity, String> name;
	public static volatile SingularAttribute<SubcategoryEntity, String> categoryCode;
	public static volatile SingularAttribute<SubcategoryEntity, States> state;
	
}
