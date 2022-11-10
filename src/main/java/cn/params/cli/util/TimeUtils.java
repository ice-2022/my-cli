package cn.params.cli.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static long now() {
        return System.currentTimeMillis();
    }

    public static long time(String date) throws Exception {
        SimpleDateFormat sdf;
        if (date.indexOf('/') > 0) {
            if (date.length() == 10) {
                sdf = new SimpleDateFormat("yyyy/MM/dd");
            } else if (date.length() == 13) {
                sdf = new SimpleDateFormat("yyyy/MM/dd HH");
            } else if (date.length() == 16) {
                sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            } else {
                sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            }
        } else {
            if (date.length() == 10) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (date.length() == 13) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH");
            } else if (date.length() == 16) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
        }

        return sdf.parse(date).getTime();
    }

    public static String date(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
