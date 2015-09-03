package com.bplat.common.support.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bplat.common.exception.BplatException;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class DateUtil {
	
	private static Date  currentDate = null;
	private static long currentSecond = 0L;

	private static  Logger logger = LoggerFactory.getLogger(DateUtil.class);
	
	public enum DateOrder {
		FIRST(1), LAST(2);
		private int value;
		private DateOrder(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public boolean isMatch(int compare) {
			return value == compare;
		}
	}
	
	
	
	public enum HourFormat{
		START_HOUR("000000"), END_HOUR("235959");
		private String value;
		private HourFormat(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value == compare;
		}
	}
	/**
     * Ư������ 1�ϸ� �䱸�ϴ� �����
     */
    private static final char DATE_UTIL_FIRST_DAY = 'F';

    /**
     * Ư������ ���ϸ� �䱸�ϴ� �����
     */
    private static final char DATE_UTIL_END_DAY = 'E';

    public enum Format {
    	YYYYMMDDHHMISS("yyyyMMddHHmmss"),
    	YYYYMMDDHH("yyyyMMddHH"),
    	YYYYMMDD("yyyyMMdd"),
    	YYYYMM("yyyyMM"),
    	MM_dd("MM-dd"),
    	DD("dd"),
    	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd'T'HH:mm:ss"),
    	YYYYMMDDTHHMMSSFORSOAP("yyyy-MM-dd'T'HH:mm:ss"),
    	YYYY_MM_DD_HH_MI_SS("yyyy-MM-dd HH:mm:ss");
    	private String value;
		private Format(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
    }
    
    public static Date getYesterday() {
    	Calendar cal = Calendar.getInstance(Locale.KOREA);
    	cal.add(Calendar.DATE, -1);
		return cal.getTime();
    }
    
    public static String getMonthAgo() { 
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Format.YYYYMM.getValue());
    	Calendar cal = Calendar.getInstance(Locale.KOREA);
    	cal.add(Calendar.MONTH, -1);
    	return simpleDateFormat.format(cal.getTime());
    }

	public static Date getNow() {
//		Calendar cal = Calendar.getInstance(Locale.KOREA);
//		return cal.getTime();
		long second = (System.currentTimeMillis()/1000L);
		Date returnDate;
		if(second == currentSecond){
			returnDate = currentDate;
		}else{
			Calendar cal = Calendar.getInstance(Locale.KOREA);
            currentDate = cal.getTime();
            currentSecond = second;
            returnDate = currentDate;
		}
			
		return returnDate;
	}

	public static String getDateByFormat(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	public static String getNowByFormat(String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(getNow());
	}

	public static Date getNow(Locale locale) {
		Calendar cal = Calendar.getInstance(locale);
		return cal.getTime();
	}

	public static Date getCustomDate(int index) {
		return getCustomDate(Locale.KOREA, index);
	}

	public static Date getCustomDate(Locale locale, int index) {
		return getCustomDate(locale, index, 0);
	}

	public static Date getCustomDate(Locale locale, int index, int year) {
		return getCustomDate(locale, index, year, 0);
	}

	public static Date getCustomDate(Locale locale, int index, int year, int month) {
		return getCustomDate(locale, index, year, month, 0);
	}

	public static Date getCustomDate(Locale locale, int index, int year, int month, int date) {
		return getCustomDate(locale, index, year, month, date, index == DateOrder.FIRST.getValue() ? 0 : 23);
	}

	public static Date getCustomDate(Locale locale, int index, int year, int month, int date, int hour) {
		return getCustomDate(locale, index, year, month, date, hour, index == DateOrder.FIRST.getValue() ? 0 : 59);
	}

	public static Date getCustomDate(Locale locale, int index, int year, int month, int date, int hour, int minutes) {
		return getCustomDate(locale, index, year, month, date, hour, minutes, index == DateOrder.FIRST.getValue() ? 0 : 59);
	}

	public static Date getCustomDate(Locale locale, int index, int year, int month, int date, int hour, int minutes, int second) {
		Date result = null;
		Calendar cal = Calendar.getInstance( locale != null ? locale : Locale.KOREA );
		cal.set( Calendar.YEAR, year != 0 ? year : cal.get(Calendar.YEAR) );
		cal.set( Calendar.MONTH, month != 0 ? (month - 1) : cal.get(Calendar.MONTH) );
		cal.set( Calendar.DATE, date != 0 ? date : (index == DateOrder.FIRST.getValue() ? 1 : cal.getActualMaximum(Calendar.DAY_OF_MONTH)) );
		cal.set( Calendar.HOUR_OF_DAY, hour);
		cal.set( Calendar.MINUTE, minutes);
		cal.set( Calendar.SECOND, second);
		cal.set( Calendar.MILLISECOND, index == DateOrder.FIRST.getValue() ? 0 : 59);
		result = cal.getTime();
		return result;
	}



	public static Date addDate(Date date, int amount, int field, int index) {
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		cal.setTime(date);
		cal.add(field, amount);
		return getCustomDate(Locale.KOREA, index, cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH), cal.get(Calendar.DATE),
				cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND));
	}

    /**
     * String ����� ��¥�� Ư�� format���ε� Date��ü�� ��ȯ�Ѵ�
     * format exception �߻�� null�� return �Ѵ�
     * @param str ��¥
     * @param format Ư�� ��¥����� format
     * @return Date format�� �´� ������� null�� return �Ѵ�
     */
    public static Date getDateByString(String str, String format)
    {
        Date date = null;
        try
        {
            date = new java.text.SimpleDateFormat(format).parse(getChangeDateFormat(str, format));
        }
        catch(ParseException pe)
        {
            date = null;
        }
        return date;
    }



    /**
     * getFirstDayNowMonth
     * �̴��� 1�� 0�� 0�� 0���� data�� �����ش�
     * @return �̴��� 1�� 0�� 0�� 0���� data
     */
    public static Date getFirstDayNowMonth()
    {
        Date date = null;

        Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.set(Calendar.DATE,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        date = cal.getTime();

        return date;
    }

    /**
     * getFirstSpecialDayNowMonth
     * �̴��� day�� 0�� 0�� 0���� data�� �����ش�
     * @param day : Ư�� ��
     * @return  �̴��� day�� 0�� 0�� 0���� data
     */
    public static Date getFirstSpecialDayNowMonth(int day)
    {
    	Date date = null;

    	Calendar cal = Calendar.getInstance(Locale.KOREA);
    	cal.set(Calendar.DATE,day);
    	cal.set(Calendar.HOUR_OF_DAY,0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	cal.set(Calendar.MILLISECOND,0);
    	date = cal.getTime();

    	return date;
    }

    /**
     * getLastSpecialDayNowMonth
     * �̴��� day�� 23�� 59�� 59���� data�� �����ش�
     * @param day : Ư�� ��
     * @return  �̴��� day�� 23�� 59�� 59���� data
     */
    public static Date getLastSpecialDayNowMonth(int day)
    {
    	Date date = null;

    	Calendar cal = Calendar.getInstance(Locale.KOREA);
    	cal.set(Calendar.DATE,day);
    	cal.set(Calendar.HOUR_OF_DAY,23);
    	cal.set(Calendar.MINUTE, 59);
    	cal.set(Calendar.SECOND, 59);
    	cal.set(Calendar.MILLISECOND,59);
    	date = cal.getTime();

    	return date;
    }

    /**
     * �̴��� 1�� 0�� 0�� 0���� data�� �����ش�
     * @param yearMonth  ��� ��) 200912
     * @return �̴��� 1�� 0�� 0�� 0���� data
     */
    public static Date getFirstDayMonth(String yearMonth)
    {
        Date date = null;

        Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.set(Calendar.YEAR, Integer.parseInt(yearMonth.substring(0,4)));
        cal.set(Calendar.MONTH, Integer.parseInt(yearMonth.substring(4,6)) - 1);
        cal.set(Calendar.DATE,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        date = cal.getTime();

        return date;
    }

    /**
     * Ư�� ����� ���� 23�� 59�� 59���� data�� �����ش�
     * @param yearMonth ��� ��) 200912
     * @return �̴��� 1�� 0�� 0�� 0���� data
     */
    public static Date getLastDayMonth(String yearMonth)
    {
        Date date = null;
        Calendar cal = Calendar.getInstance(Locale.KOREAN);
        cal.set(Integer.parseInt(yearMonth.substring(0,4)),Integer.parseInt(yearMonth.substring(4)) - 1,1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,0);
        date = cal.getTime();

        return date;
    }

    /**
     *  Ư�� ����� ������ ����ش�
     * @param yearMonth 201005
     * @return
     */
    public static int getLastDayOfMonth(String yearMonth)
    {
        Calendar cal = Calendar.getInstance(Locale.KOREAN);
        cal.set(Integer.parseInt(yearMonth.substring(0,4)),Integer.parseInt(yearMonth.substring(4)) - 1,1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,59);

        return cal.get(Calendar.DATE);
    }

    /**
     * Ư�� ����� ���� 00�� 00�� 00���� data�� �����ش�
     * @param yearMonth ��� ��) 2009-12
     * @return �̴� ������ 0�� 0�� 0���� data
     */
    public static Date getLastDayMonthStartTime(String yearMonth)
    {
        Date date = null;
        Calendar cal = Calendar.getInstance(Locale.KOREAN);
        cal.set(Integer.parseInt(yearMonth.substring(0,4)),Integer.parseInt(yearMonth.substring(5)) - 1,1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        date = cal.getTime();

        return date;
    }

    /**
     * ���� �����̽ð��� �ִ�ú��ʰ��� Date�� ������ش�
     * @return ���� �����̽ð��� �ִ�ú��ʰ��� Date �������� 23�� 59�� 59��
     */
    public static Date getTodayMinuteSecondMaximum()
    {
        Date date = null;

        Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.set(Calendar.HOUR,23);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        date = cal.getTime();

        return date;
    }

    /**
     * Ư�� ��¥�� �γ�¥ ���̿� ���ϴ��� check
     * @param startDate �񱳽��۳�
     * @param endDate   �����ᳯ
     * @param targetDate ������¥
     * @return true ������¥�� ���۳�¥�� ���ᳯ¥ ���̿� ������ ���
     */
    public static boolean isBetweenDate(Date startDate,Date endDate,Date targetDate)
    {
        boolean isBetween = false;

        Calendar startCal = Calendar.getInstance(Locale.KOREA);
        Calendar endCal = Calendar.getInstance(Locale.KOREA);
        Calendar targetCal = Calendar.getInstance(Locale.KOREA);

        startCal.setTime(startDate);
        endCal.setTime(endDate);
        targetCal.setTime(targetDate);

        startCal.set(Calendar.MILLISECOND,0);
        endCal.set(Calendar.MILLISECOND,0);
        targetCal.set(Calendar.MILLISECOND,0);

        long startLong = startCal.getTimeInMillis();
        long endLong = endCal.getTimeInMillis();
        long targetLong = targetCal.getTimeInMillis();

        if(targetLong >= startLong && targetLong <= endLong)
            isBetween = true;

        return isBetween;
    }
    
    public static String addMonth(String yyyymm, int addValue) {
    	Date temp = DateUtil.getDateByString(yyyymm, DateUtil.Format.YYYYMM.getValue());
    	Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.setTime(temp);
        cal.add(Calendar.MONTH, addValue);
        return new java.text.SimpleDateFormat(DateUtil.Format.YYYYMM.getValue()).format(cal.getTime()).toString();
    }
    
    public static Date addMinute(Date date, int addValue) {
    	Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.setTime(date);
    	cal.add(Calendar.MINUTE, addValue);
    	return cal.getTime();
    }

    /**
     * Ư����¥�� Ư������� ���Ĵ��� ó�� ������,Ȥ�� �������� Ȥ�� Ư����¥�� ���� �����ش�.
     * @param date Ư����¥
     * @param addMonth Ư����¥�� Ư������ �߰��� �����
     * @param startOrEnd ���¥�� �� 1�Ϸ� ���� ������� ���� �������Ϸ� ����,���¥�� �״�� ���� ����
     * @return Ư����¥�� Ư�������� ���� 1�ϳ�¥ Ȥ�� ���ϳ�¥ Ȥ�� ���� ���ڷ� ���� Date
     */
    public static Date addDate(Date date,int addMonth,char startOrEnd)
    {
        Date resultDate = null;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, addMonth);

        if(startOrEnd == DateUtil.DATE_UTIL_FIRST_DAY)
        {
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND,0);
        }
        else if(startOrEnd == DateUtil.DATE_UTIL_END_DAY)
        {
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
            cal.set(Calendar.HOUR_OF_DAY,23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND,0);
        }

        resultDate = cal.getTime();

        return resultDate;
    }

    /**
     * Ư������ 23�� 59�� 59�ʷ� ����� �ش�.
     * @param date Date
     * @return parameter data�� 23�� 59�� 59���� Date
     */
    public static Date getDayOfLastTime(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,0);

        return cal.getTime();
    }

    /**
     * Ư������ 00��00�� 00�ʷ� ����� �ش�.
     * @param date Date
     * @return parameter data�� 00�� 00�� 00���� Date
     */
    public static Date getDayOfStartTime(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND,0);

        return cal.getTime();
    }

    /**
     * Date �� Ư�� YYYY or YYYYMM or YYYYMMDD or YYYYMMDDHH �������� String���� ��ȯ���ش�.
     * @param date Date
     * @param formatType  DateUtil�� format YYYY or YYYYMM or YYYYMMDD or YYYYMMDDHH ����
     * @return format ��  date�� string
     */
    public static String getDateToString(Date date,int formatType)
    {
        Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.setTime(date);
        DecimalFormat formater = new DecimalFormat("00");
        StringBuffer dateStrBuff = new StringBuffer();
        dateStrBuff.append(cal.get(Calendar.YEAR));

        switch(formatType)
        {
            case(2):dateStrBuff.append(formater.format(cal.get(Calendar.MONTH) +1 )); break;
            case(3):dateStrBuff.append(formater.format(cal.get(Calendar.MONTH) +1 ))
                               .append(formater.format(cal.get(Calendar.DAY_OF_MONTH))); break;
            case(4):dateStrBuff.append(formater.format(cal.get(Calendar.MONTH) +1) )
                               .append(formater.format(cal.get(Calendar.DAY_OF_MONTH)) )
                               .append(formater.format(cal.get(Calendar.HOUR_OF_DAY)) );  break;
            case(5):dateStrBuff.append("-").append(formater.format(cal.get(Calendar.MONTH) +1) ).append("-")
                               .append(formater.format(cal.get(Calendar.DAY_OF_MONTH)) );  break;
            case(6):dateStrBuff.append(formater.format(cal.get(Calendar.MONTH) +1) )
                                .append(formater.format(cal.get(Calendar.DAY_OF_MONTH)) )
                                .append(formater.format(cal.get(Calendar.HOUR_OF_DAY)) )
                                .append(formater.format(cal.get(Calendar.MINUTE)) );  break;
            case(7):dateStrBuff.append(formater.format(cal.get(Calendar.MONTH) +1) )
					            .append(formater.format(cal.get(Calendar.DAY_OF_MONTH)) )
					            .append(formater.format(cal.get(Calendar.HOUR_OF_DAY)) )
					            .append(formater.format(cal.get(Calendar.MINUTE)) )
					            .append(formater.format(cal.get(Calendar.SECOND)) ); break;

        }

        return dateStrBuff.toString();
    }

    /**
     * 20120420235812 ������ string�� Ư�� format���� �߷��� ����� �ش�.
     * @param targetStr
     * @param format
     * @return exception �� null return
     */
    public static String getDateFormatString(String targetStr,int format) {
        String result = null;
        int lastIndex = 0;

        switch(format) {
            case(1) : lastIndex = 4; break;
            case(2) : lastIndex = 6; break;
            case(3) : lastIndex = 8; break;
            case(4) : lastIndex = 10; break;
            case(6) : lastIndex = 12; break;
        }

        try {
        	result = targetStr.replaceAll("-","").replaceAll(" ","").replaceAll(":", "").substring(0, lastIndex);
        }catch(Exception e) {
        	e.printStackTrace();
            result = null;
        }
        return result;
    }

    public static String getStringByDate(Date date, String format)
    {
    	String result = null;
    	if(date == null)
    		result = "";
		else
			result = new java.text.SimpleDateFormat(format).format(date).toString();
    	return result;
    }

    /**
     * �γ�¥ (Date) �� �ϼ����̸� ���Ѵ�.
     * @param date ������¥
     * @param afterDate ū��¥
     * @return �� date�� ��¥ ���̼�
     */
    public static int getDistanceDayCount(Date date,Date afterDate)
    {
        int distanceDayCount = 0;
        Calendar startCal = Calendar.getInstance(Locale.KOREA);
        Calendar endCal = Calendar.getInstance(Locale.KOREA);

        startCal.setTime(date);
        endCal.setTime(afterDate);

        startCal.set(Calendar.HOUR_OF_DAY,00);
        startCal.set(Calendar.MINUTE, 00);
        startCal.set(Calendar.SECOND, 00);
        startCal.set(Calendar.MILLISECOND,0);

        endCal.set(Calendar.HOUR_OF_DAY,00);
        endCal.set(Calendar.MINUTE, 00);
        endCal.set(Calendar.SECOND, 00);
        endCal.set(Calendar.MILLISECOND,0);

        while(!startCal.equals(endCal) && !startCal.after(endCal))
        {
            distanceDayCount++;
            startCal.add(Calendar.DATE, 1);
        }

        return distanceDayCount;
    }

    public static int getDistanceYearCount(Date date,Date afterDate) {
    	return DateUtil.getDistanceDayCount(date, afterDate) / 365;
    }

    /**
     * �γ�¥ (Date) �� ������̸� ���Ѵ�.
     * @param date ������¥
     * @param afterDate ū��¥
     * @return �� date�� �����̼�
     */
    public static int getDistanceMonthCount(Date date,Date afterDate)
    {
        int distanceMonthCount = 0;
        int distanceDayCount = 0;
        Calendar startCal = Calendar.getInstance(Locale.KOREA);
        Calendar endCal = Calendar.getInstance(Locale.KOREA);

        startCal.setTime(date);
        endCal.setTime(afterDate);

        while(!startCal.after(endCal))
        {
            distanceDayCount++;
            startCal.add(Calendar.DATE, 1);
        }

        distanceMonthCount = distanceDayCount / 30;

        return distanceMonthCount;
    }

    public static boolean isLastDayOfMonth() {
        Calendar now = Calendar.getInstance(Locale.KOREA);
        int day = now.get(Calendar.DATE);
        int lastDay = now.getActualMaximum(Calendar.DATE);
        return day==lastDay;
    }

    /**
     * java.util.Date ��
     * @param oneDate
     * @param anotherDate
     * @return  1:oneDate�� anotherDate ���� ���� ��¥, -1:oneDate�� anotherDate ���� ���� ��¥<br/>
     *          0:oneDate�� anotherDate ���� ���� ��¥
     */
    public static int compareDate(Date oneDate,Date anotherDate)
    {
    	int returnValue = 0;
        long result = oneDate.getTime() - anotherDate.getTime();

        if(result > 0) returnValue = 1;
        else if(result < 0) returnValue = -1;
        else returnValue = 0;
        return returnValue;
    }

    /**
     * ���� ��¥�� �û��� yyyyMMddhhmmsss ���·� ��ȯ �� return.
     * @return yyyyMMddHHmmss
     */
    public static String getCurrenDateTime()
    {
        Date today = new Date();
        Locale currentLocale = new Locale("KOREAN", "KOREA");
        String pattern = DateUtil.Format.YYYYMMDDHHMISS.getValue();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(today);
    }

    /**
     * GregorianCalendar ��ü�� ��ȯ��.
     * @param yyyymmdd
     * @return
     */
    public static GregorianCalendar getGreorianCalendar(String yyyymmdd)
    {
        int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int mm = Integer.parseInt(yyyymmdd.substring(4, 6));
        int dd = Integer.parseInt(yyyymmdd.substring(6));

        GregorianCalendar calendar = new GregorianCalendar(yyyy, mm -1, dd, 0, 0, 0);
        return calendar;
    }

    /**
     * ���� ��¥�� yyyyMMdd ���·� ��ȭ �� return
     * @return
     */
    public static String getCurrentYyyymmdd()
    {
        return getCurrenDateTime().substring(0, 8);
    }

    /**
     * �� ��¥���� ��¥���� ��ȯ(������ ������)
     * @param startDate ���� ��¥
     * @param endDate �� ��¥
     * @return
     * <pre>
     * ���� : long date = DateUtil.getDifferDays("20100101", "20100102");
     * </pre>
     */
    public static long getDifferDays(String startDate, String endDate)
    {
        GregorianCalendar _startDate = getGreorianCalendar(startDate);
        GregorianCalendar _endDate = getGreorianCalendar(endDate);
        long differ = (_endDate.getTime().getTime() - _startDate.getTime().getTime()) / 86400000;
        return differ;
    }

    public static String getChangeDateFormat(String paramstr, String format) {
    	String result = null;
    	String str = paramstr;
    	if (DateUtil.Format.YYYYMMDDHHMISS.isMatch(format)) {
    		result = str.replaceAll("-","").replaceAll(" ","").replaceAll(":", "");
    	} else if (DateUtil.Format.YYYYMMDD.isMatch(format)) {
    		result = (str.replaceAll("-","").replaceAll(" ","").replaceAll(":", "")).substring(0, 8);
    	} else if (DateUtil.Format.YYYYMM.isMatch(format)) {
    		result = (str.replaceAll("-","").replaceAll(" ","").replaceAll(":", "")).substring(0, 6);
    	} else {
    		result = str;
    	}
    	return result;
    }

    public static boolean isEqualsDay(Date source,Date target)
    {
    	boolean result = false;
        Calendar sourceCal = Calendar.getInstance(Locale.KOREA);
        Calendar targetCal = Calendar.getInstance(Locale.KOREA);

        sourceCal.setTime(source);
        targetCal.setTime(target);

        if (sourceCal.get(Calendar.YEAR) == targetCal.get(Calendar.YEAR))
        	if (sourceCal.get(Calendar.MONTH) == targetCal.get(Calendar.MONTH))
        		if (sourceCal.get(Calendar.DATE) == targetCal.get(Calendar.DATE)) result = true;
        return result;
    }
    
    public static int getWorkingDays(Date baseDate, List<Date> excludeHolidays) {
    	String targetYm = DateUtil.getDateByFormat(baseDate, DateUtil.Format.YYYYMM.getValue());
    	Date start = DateUtil.getFirstDayMonth(targetYm);
    	return (int) DateUtil.getTimeDifference(start, baseDate, excludeHolidays, 4);
    }

    public static long getTimeDifference(Date start, Date end, List<Date> excludeHolidays, int format) {
    	long result = -1l;
    	long diff = end.getTime() - start.getTime();
    	long excludeValue = excludeHolidays == null ? 0l : excludeHolidays.size()*24;
    	if (format == 1) {
    		result = (diff/1000/60/60) - (excludeValue);
    	} else if (format == 2) {
    		result = (diff/1000/60) - (excludeValue*60);
    	} else if (format == 3){
    		result = diff/1000 - (excludeValue*60*60);
    	} else if (format == 4) {
    		result = ((diff/1000/60/60) - (excludeValue))/24;
        } else {
    		result = 0l;
    	}
    	return result;
    }
    
    public static boolean isValidFormat(String str, String format) {
    	boolean result = false;
        try
        {
        	Date date = new java.text.SimpleDateFormat(format).parse(str);
        	if (date != null)
        		result = true;
        }
        catch(ParseException pe)
        {
            result = false;
        }
        return result;
    }
    
    public static Date getCustomFormatDate(String format,String value) {
        
        Date date = null;
        DateFormat sdFormat = new SimpleDateFormat(format);
        try {
            date = sdFormat.parse(value);
        } catch (ParseException e) {
            date = null;
        }
        
        return date;
    }
    
    public static int getNowByField(int field) {
    	Calendar cal = Calendar.getInstance(Locale.KOREA);
    	return cal.get(field);
    }
    
    public static int getYesterdayByField(int field) {
    	Calendar cal = Calendar.getInstance(Locale.KOREA);
    	cal.add(Calendar.DATE, -1);
    	return cal.get(field);
    }
}
