package com.mm.api.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Time;
import java.text.DateFormat;
import java.time.Instant;
//
//import org.joda.time.Days;
//import org.joda.time.LocalDate;

public class TimeUtil {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
    public static final DateTimeFormatter yearMMDDFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   // public static final DateTimeFormatter yearMMDDFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final  SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    public static final Timestamp TIME = Timestamp.from(Instant.now());
       
    public static boolean areDateInFourHoursGapAndWithIn24Hour(String first, String second, String third) {
        //String firstDateStr = "2018-01-04 12";

        LocalDateTime firstDate = LocalDateTime.parse(first, formatter);

        //String secondDateStr = "2018-01-05 15";
        LocalDateTime secondDate = LocalDateTime.parse(second, formatter);

        //String thirdDateStr = "2018-01-06 20";
        LocalDateTime thirdDate = LocalDateTime.parse(third, formatter);

        if (thirdDate.getHour() >= 3 && thirdDate.getHour() <= 10) {
            System.out.println("Third Alert is Wrong");
            return false;
        }

        if (ChronoUnit.HOURS.between(secondDate, thirdDate) >= 16 || ChronoUnit.HOURS.between(secondDate, thirdDate) < 4
                || ChronoUnit.HOURS.between(firstDate, secondDate) >= 16 || ChronoUnit.HOURS.between(firstDate, secondDate) < 4) {
            System.out.println("Wrong Scheduler Difference");
            return false;
        }

        return true;
    }

    /**
     * The String should be in the follwoing format 2018-01-06 20
     *
     * @param dateHour
     * @return
     */
    public static int getHour(String dateHour) {
        LocalDateTime localDate = LocalDateTime.parse(dateHour, formatter);
        return localDate.getHour();
    }

//    public static int daysBetweenUsingJoda(Date d1, Date d2) {
//        return Days.daysBetween(new LocalDate(d1.getTime()), new LocalDate(d2.getTime())).getDays();
//    }
//
    public static boolean isTodayDate(Date date) {
//    	if(date == null){
//    		throw new Exception("Date can not be null");
//    	}
    	Date date2 = new Date();
    	if (date.compareTo(date2) == 0) {
    		return true;
    	}
    	return false;
    }
    
    public static boolean isAfterDate(Date date) {
//    	if(date == null){
//    		throw new Exception("Date can not be null");
//    	}
    	Date date2 = new Date();
    	if (date.compareTo(date2) > 0) {
    		return true;
    	}
    	return false;
    }
    
    public static boolean isBeforeDate(Date date) {
//    	if(date == null){
//    		throw new Exception("Date can not be null");
//    	}
    	Date date2 = new Date();
    	if (date.compareTo(date2) < 0) {
    		return true;
    	}
    	return false;
    }
    
    public static Timestamp addHoursInTimeStamp(Timestamp timestamp, int hours) {
    	
    	if(timestamp == null){
    		return null;
    	}
    	
    	Calendar cal = Calendar.getInstance();
	    cal.setTimeInMillis(timestamp.getTime());
	 
	    cal.setTimeInMillis(timestamp.getTime());
	    cal.add(Calendar.HOUR, hours);
	    timestamp = new Timestamp(cal.getTime().getTime());
	    
	    return timestamp;
    }
    
    public static Timestamp addDayssInTimeStamp(Timestamp timestamp, long days) {
    	
    	if(timestamp == null){
    		return null;
    	}
    	
    	Calendar cal = Calendar.getInstance();
	    cal.setTimeInMillis(timestamp.getTime());
	 
	    cal.setTimeInMillis(timestamp.getTime());
	    cal.add(Calendar.DAY_OF_MONTH, (int)days);
	    timestamp = new Timestamp(cal.getTime().getTime());
	    
	    return timestamp;
    }
    
    public static Timestamp addMinInTimeStamp(Timestamp timestamp, int min) {
    	
    	if(timestamp == null){
    		return null;
    	}
    	
    	Calendar cal = Calendar.getInstance();
	    cal.setTimeInMillis(timestamp.getTime());
	 
	    cal.setTimeInMillis(timestamp.getTime());
	    cal.add(Calendar.MINUTE, min);
	    timestamp = new Timestamp(cal.getTime().getTime());
	    
	    return timestamp;
    }
    
    public static Timestamp getCurrentTimeStamp(){
    	Timestamp timestamp = null;
		try {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			Date parsedDate = dateFormat.parse(timeStamp);
	        timestamp = new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return timestamp;
    }
    
    public static Time getTime(String strTime) {
        Time ppstime = null;
        try {
            Date d1 = (Date)format.parse(strTime);
            ppstime = new Time(d1.getTime());
        
        } catch (ParseException ex) {
            Logger.getLogger(TimeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ppstime;
    }
    
    public static String lastWeekDay() {
        String str = TimeUtil.addDayssInTimeStamp(TimeUtil.TIME, -6).toString();
        String[] split = str.split(" ");
        str = split[0].concat(" 00:00:00");
        return str;
    }

    public static String lastDay() {
        String str = TimeUtil.addDayssInTimeStamp(TimeUtil.TIME, -1).toString();
        String[] split = str.split(" ");
        str = split[0].concat(" 00:00:00");
        return str;
    }
}
