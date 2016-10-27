package org.csip.bigData.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bun@csip.org.cn on 2016/9/16.
 */
public class DateUtil {
    private static  SimpleDateFormat df=null;
    static
    {
        df=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        df.setLenient(false);
    }
    public boolean isValidDate(String s)
    {
    try
    {
        df.parse(s);
        return true;
    }
    catch(Exception e)
    {
        return false;
    }
    }
    public Date validDate(String s) throws ParseException {

            return df.parse(s);
    }
    public String getMongoDate(String date)
    {
        StringBuilder sb=new StringBuilder();
        String[] dates=date.split("_");
        String returnDate=sb.append(dates[0]+" "+dates[1]).toString();
        System.out.println("returnDate:"+returnDate);
        return returnDate;
    }

}
