package com.blog.site.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Implement the Custom Validator

public class WordCountValidator implements ConstraintValidator<WordCount, String>{

	private int minWords;
	
	/**
	 * The initialize method captures the max value from the annotation
	 */
	@Override
	public void initialize(WordCount contraintAnnotation) {
		this.minWords = contraintAnnotation.min();
	}
	
	/**
	 * The isValid method contains the logic to check if the number of words in the string matches the specified minimum. 
	 * It splits the string by whitespace to count the words
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return false; // null values are not valid
		}
		
		String[] words = value.trim().split("\\s+");
		return words.length >= minWords;
	}

}
