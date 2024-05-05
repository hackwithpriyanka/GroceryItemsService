package com.adminproj.groceryitmes.common;

public class Constants {
	public interface PARAMETER_TYPE {
		public static final String STRING = "STRING";
		public static final String DOUBLE = "DOUBLE";
		public static final String LONG = "LONG";
		public static final String INT = "INT";
		public static final String DATE = "DATE";
		public static final String SQLDATE = "SQLDATE";
		public static final String SQLTIMESTAMP = "SQLTIMESTAMP";
		public static final String BIGDECIMAL = "BIGDECIMAL";
	}
	
	public interface ERROR_CODE {

		public static final long NO_ERROR = 100;
		public static final long INSERTION_FAILED = 101;
		public static final long UPDATION_FAILED = 102;
	}
}
