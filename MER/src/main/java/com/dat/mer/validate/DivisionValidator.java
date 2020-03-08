package com.dat.mer.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dat.mer.repository.DivisionRepository;

public class DivisionValidator implements ConstraintValidator<DivisionNotExist,String> {
	@Autowired
	DivisionRepository divisionRepo;
	@Override
	 public void initialize(DivisionNotExist divisionExist) {
	    }
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.print("This is value"+value);
		if(value.isEmpty()) {
			return true;
		}
		int count=divisionRepo.isDivisionExist(value);
		return count!=0;
	}
}
