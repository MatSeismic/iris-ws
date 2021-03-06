package edu.iris.dmc.ws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	private static String SHORTDATE = "yyyy-MM-dd";
	private static String LONGDATE = "yyyy-MM-dd'T'HH:mm:ss";
	//public static SimpleDateFormat SHORTDF = new SimpleDateFormat(SHORTDATE);
	//public static SimpleDateFormat LONGDF = new SimpleDateFormat(LONGDATE);
	
	public static Date parse(String string) throws ParseException{
		if(string == null){
			return null;
		}
		
		SimpleDateFormat sdf =  new SimpleDateFormat(SHORTDATE);
		if(string.length()>SHORTDATE.length()){
			sdf = new SimpleDateFormat(LONGDATE);
		}
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = sdf.parse(string);
		return date;
	}
	
	public static Date parse(String string, String pattern) throws ParseException{
		if(string == null){
			return null;
		}
		
		SimpleDateFormat sdf =  new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = sdf.parse(string);
		return date;
	}
	
	public static String format(Date date){
		if(date == null){
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(LONGDATE);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(date);
	}
}
