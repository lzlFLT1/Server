package kasei.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /** 字符串转日期
     * @param "yyyy-MM-dd HH:mm:ss"
     * */
    public static Date string2Date(String str, String pattern){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            System.out.println("String convert to Date encounter error");
            e.printStackTrace();
        }
        return null;
    }

    /** 日期转字符串
     * @param "yyyy-MM-dd HH:mm:ss"
     * */
    public static String date2String(Date date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String str = simpleDateFormat.format(date);
        return str;
    }


}
