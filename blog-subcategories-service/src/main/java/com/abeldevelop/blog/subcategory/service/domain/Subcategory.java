package com.abeldevelop.blog.subcategory.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Subcategory {

    @EqualsAndHashCode.Include
    @NonNull
    private String categoryCode;
    
	@EqualsAndHashCode.Include
	@NonNull
	private String code;
	
	@NonNull
	private String name;
	
}
