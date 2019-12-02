package com.abeldevelop.blog.subcategory.repository.specification;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.property.enums.States;
import com.abeldevelop.blog.subcategory.model.SubcategoryEntity;
import com.abeldevelop.blog.subcategory.model.SubcategoryEntity_;

@Component
public class SubcategorySpecifications {

    public Specification<SubcategoryEntity> nameLike(String query) {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            return criteriaBuilder.like(
                    criteriaBuilder.upper(root.get(SubcategoryEntity_.name)), 
                    "%" + query.toUpperCase() + "%");
        };
    }
    
    public Specification<SubcategoryEntity> stateEnabled() {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            return criteriaBuilder.equal(root.get(SubcategoryEntity_.state), States.ENABLED);
        };
    }
    
    public Specification<SubcategoryEntity> byCode(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            Predicate statePredicate = criteriaBuilder.equal(root.get(SubcategoryEntity_.state), States.ENABLED);
            Predicate idPredicate = criteriaBuilder.equal(root.get(SubcategoryEntity_.code), code);
            return criteriaBuilder.and(statePredicate, idPredicate);
        };
    }
}
