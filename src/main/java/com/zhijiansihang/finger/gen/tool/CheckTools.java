package com.zhijiansihang.finger.gen.tool;

import com.sun.xml.internal.ws.util.Pool;

/**
 * Created by paul on 2018/1/23.
 */
public class CheckTools {
    public static boolean isInteger(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static boolean stringEmptyString(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static String nullToEmptyString(String string) {
        if (string == null || string.trim().length() == 0) {
            return "";
        }
        return string;
    }
}
