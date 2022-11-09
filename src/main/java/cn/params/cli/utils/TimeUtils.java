package cn.params.cli.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static long now() {
        return System.currentTimeMillis();
    }

    public static long time(String date) throws Exception {
        // 默认 yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date).getTime();
    }

    public static String date(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
