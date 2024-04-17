package com.app.covw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DataUtils {

    public static String getCurrentData() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:dd");
        String dataStr = format.format(new Date());
        return dataStr;

    }
}
