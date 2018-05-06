package com.arkhipov.ayur.todofirebaseapp.common;


import android.text.TextUtils;

public final class Log {

    private static String addToMsg = " ------------------------";

    public static void l() {
        android.util.Log.d(getLocation(), "");
    }

    public static void d(String msg) {
        android.util.Log.d(getLocation(),/* getLocation() + */msg + addToMsg);
    }

    public static void w(String msg) {
        android.util.Log.w(getLocation(),/* getLocation() + */msg + addToMsg);

    }

    private static String getLocation() {
        final String className = Log.class.getName();
        final StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        boolean found = false;

        for (int i = 0; i < traces.length; i++) {
            StackTraceElement trace = traces[i];

            try {
                if (found) {
                    if (!trace.getClassName().startsWith(className)) {
                        Class<?> clazz = Class.forName(trace.getClassName());
                        return "[" + getClassName(clazz) + ":" + trace.getMethodName() + ":" + trace.getLineNumber() + "]: ";
                    }
                }
                else if (trace.getClassName().startsWith(className)) {
                    found = true;
                    continue;
                }
            }
            catch (ClassNotFoundException e) {
            }
        }

        return "[]: ";
    }

    private static String getClassName(Class<?> clazz) {
        if (clazz != null) {
            if (!TextUtils.isEmpty(clazz.getSimpleName())) {
                return clazz.getSimpleName();
            }

            return getClassName(clazz.getEnclosingClass());
        }

        return "";
    }
}
