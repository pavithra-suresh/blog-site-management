package com.blog.site.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

/*
 *  Custom Annotation Definition
 *  
 *  @Constraint annotation links the custom annotation to the WordCountValidator class.
 *  @Target specifies where the annotation can be applied (methods, fields, etc.).
 *  @Retention defines how long the annotation is retained (runtime in this case)
 */

@Constraint(validatedBy = WordCountValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface WordCount {
	
	// Attributes required by bean validation
	String message() default "Text must be at most 1000 words";
	
	int min() default 1000;

}
