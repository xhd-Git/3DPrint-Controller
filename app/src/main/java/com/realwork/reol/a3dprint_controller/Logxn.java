package com.realwork.reol.a3dprint_controller;

/**
 * 展示log 不写入文件
 * @author zhaowencong
 *
 */
public class Logxn {
	private static boolean isDebug = true;
	
	public static void setDebug(boolean isDebug) {
		Logxn.isDebug = isDebug;
	}

	public static final String TAG = "STLViewer";
	public static final String THROWABLE = "throwable occured.";
	
	public static void e(String message) {
		if (isDebug) {
			android.util.Log.e(TAG, message);
		}
	}

	public static void e(Throwable t) {
		if (isDebug) {
			e(THROWABLE, t);
		}
	}

	public static void e(String message, Throwable t) {
		if (isDebug) {
			android.util.Log.e(TAG, message, t);
		}
	}
	
	public static void w(String message) {
		if (isDebug) {
			android.util.Log.w(TAG, message);
		}
	}

	public static void w(Throwable t) {
		if (isDebug) {
			w(THROWABLE, t);
		}
	}

	public static void w(String message, Throwable t) {
		if (isDebug) {
			android.util.Log.w(TAG, message, t);
		}
	}
	
	public static void i(String message) {
		if (isDebug) {
			android.util.Log.i(TAG, message);
		}
	}

	public static void i(Throwable t) {
		if (isDebug) {
			i(THROWABLE, t);
		}
	}

	public static void i(String message, Throwable t) {
		if (isDebug) {
			android.util.Log.i(TAG, message, t);
		}
	}
	
	public static void d(String message) {
		android.util.Log.d(TAG, message);
	}

	public static void d(Throwable t) {
		d(THROWABLE, t);
	}

	public static void d(String message, Throwable t) {
		android.util.Log.d(TAG, message, t);
	}
	
	public static void v(String message) {
		android.util.Log.v(TAG, message);
	}

	public static void v(Throwable t) {
		v(THROWABLE, t);
	}

	public static void v(String message, Throwable t) {
		android.util.Log.v(TAG, message, t);
	}
}
