package com.abeldevelop.blog.subcategory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.abeldevelop.architecture.library.property.enums.States;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "subcategories", schema = "blog_db")
public class SubcategoryEntity {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "category_code", nullable = false)
    private String categoryCode;
	
	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private States state;
}
