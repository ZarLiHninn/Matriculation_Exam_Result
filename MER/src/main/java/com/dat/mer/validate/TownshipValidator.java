package com.dat.mer.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dat.mer.repository.TownshipRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TownshipValidator implements ConstraintValidator<TownshipNotExist,String> {
	@Autowired
	TownshipRepository townshipRepo;
	 @Override
	 public void initialize(TownshipNotExist townshipExist) {
	    }
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.isEmpty()) {
			return true;
		}
		int count=townshipRepo.isTownExist(value);
		return count!=0;
	}

}
