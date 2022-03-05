package chatonlineserver.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat();
        String s = df.format(new Date());
        java.sql.Date sqlTime = new java.sql.Date(new Date().getTime());
        System.out.println(s);
        System.out.println(sqlTime);
    }
    /*
    * 获得使用 java.sql.Date获得当前系统时间
    * */
    public static void getCurrentTSystemTime(){
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        System.out.println(currentDate);
    }
    public static void main(String[] args) {
        //getCurrentTime();
        getCurrentTSystemTime();
    }
}
