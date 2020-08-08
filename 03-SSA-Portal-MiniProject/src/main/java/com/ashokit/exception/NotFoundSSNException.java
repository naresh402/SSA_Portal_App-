package com.ashokit.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class NotFoundSSNException extends RuntimeException{
	
	
	public NotFoundSSNException(String msg) {
		super(msg);
	}
	

}
