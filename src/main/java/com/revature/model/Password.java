package com.revature.model;

public class Password {
	
	private static String userPwd = "1234";

	/**
	 * @return the userPwd
	 */
	public static String getUserPwd() {
		return userPwd;
	}

	/**
	 * @param userPwd the userPwd to set
	 */
	public static void setUserPwd(String userPwd) {
		Password.userPwd = userPwd;
	}
	
	

}
