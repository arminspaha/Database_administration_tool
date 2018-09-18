package com.spahic.profileController;

public class ProfileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProfileNotFoundException() {
		
	}

	public ProfileNotFoundException(String arg0) {
		super(arg0);
		
	}

	public ProfileNotFoundException(Throwable arg0) {
		super(arg0);
		
	}

	public ProfileNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ProfileNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
