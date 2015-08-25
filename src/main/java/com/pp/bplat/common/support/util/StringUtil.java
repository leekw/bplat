package com.pp.bplat.common.support.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pp.bplat.common.exception.PartnerException;

public class StringUtil {
	
	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
    
	private enum ProcessUnit {
		COUNT(10);
		private int value;
		private ProcessUnit(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public boolean isMatch(int compare) {
			return value == compare;
		}
	}
	
	public static String getUniqueKey(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.reset();
			byte[] buffer = input.getBytes();
			md.update(buffer);
			byte[] digest = md.digest();

			StringBuffer hexStr = new StringBuffer();
			for (byte dg : digest) {
				hexStr.append(Integer.toString((dg & 0xff) + 0x100, 16).substring(1));
			}
			return hexStr.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new PartnerException(Error.E0000.getValue());
		}
	}
	
	public static List<List<String>> cross(List<String[]> sets) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (sets.size() == 1) {
			String[] values = sets.get(0);
			for (String s : values) {
				List<String> al = new ArrayList<String>();
				al.add(s);
				result.add(al);
			}
		} else if (sets.size() == 2) {
			int valueSetSize = ((String[]) sets.get(0)).length;
			for (int i = 0; i < valueSetSize; i++) {
				int innerValueSetSize = ((String[]) sets.get(1)).length;
				for (int j = 0; j < innerValueSetSize; j++) {
					List<String> al = new ArrayList<String>();
					al.add(((String[]) sets.get(0))[i]);
					al.add(((String[]) sets.get(1))[j]);
					result.add(al);
				}
			}
		} else {
			List<List<String>> temp = cross(sets.subList(0, sets.size() - 1));
			String[] x = (String[]) sets.get(sets.size() - 1);
			
			int tempSize = temp.size();
			for (int i = 0; i < tempSize; i++) {
				int xSize = x.length;
				for (int j = 0; j < xSize; j++) {
					List<String> al = new ArrayList<String>();
					int tempListSize = temp.get(i).size();
					for (int p = 0; p < tempListSize; p++) {
						al.add(temp.get(i).get(p));
					}
					al.add(x[j]);
					result.add(al);
				}
			}
		}
		return result;
	}
	
	public static boolean isEmpty(String param){
		boolean result = false;
		
		if( param == null || "".equals(param.trim()) )
			result = true;
		
		return result;
	}

	public static String nullToEmptyString(Object param){
		String result = "";
		if( param != null ) {
			try {
				result = String.valueOf(param);
			} catch (Exception e) {
				logger.debug(StringUtil.getPrintStackTrace(e));
			}
		} 
		return result;
	}
	
	public static String upperFirstLetter(String paramString) {	
		StringBuilder result = new StringBuilder();
		result.append(Character.toUpperCase(paramString.charAt(0))).append(paramString.substring(1));
		return result.toString();
	}
	
	public static String lowerFirstLetter(String paramString) {	
		StringBuilder result = new StringBuilder();
		result.append(Character.toLowerCase(paramString.charAt(0))).append(paramString.substring(1));
		return result.toString();
	}
	
	public static String lowerCase(String paramString) {	
		StringBuilder result = new StringBuilder();
		int size = paramString.length();
		for (int i = 0; i < size; i++) {			
			result.append(Character.toLowerCase(paramString.charAt(i)));				
		}
		return result.toString();
	}
	
	public static String upperCase(String paramString) {	
		StringBuilder result = new StringBuilder();
		int size = paramString.length();
		for (int i = 0; i <size ; i++) {			
			result.append(Character.toUpperCase(paramString.charAt(i)));				
		}
		return result.toString();
	}

	public static String underBarToCapital(String paramString) {		
		StringBuilder result = new StringBuilder();
		boolean upperCase = false;
		int paramSize = paramString.length();
		for (int i = 0; i < paramSize; i++) {
			if (paramString.charAt(i) == '_') {
				upperCase = true;
			} else {
				if (upperCase) {
					result.append(Character.toUpperCase(paramString.charAt(i)));
					upperCase = false;
				} else {
					result.append(paramString.charAt(i));
				}
			}
		}
		return result.toString();
	}
	
	public static String capitalToUnderBar(String paramString) {		
		StringBuilder result = new StringBuilder();
		int paramSize = paramString.length();
		for (int i = 0; i < paramSize; i++) {
			if (paramString.charAt(i) >= 'A' && paramString.charAt(i) <= 'Z') {
				result.append("_");
				result.append(Character.toLowerCase(paramString.charAt(i)));
			} else {				
				result.append(paramString.charAt(i));			
			}
		}
		return result.toString();
	}
	
	public static String getPrintStackTrace(Throwable exception) {
		Writer writer = null;
    	PrintWriter printWriter = null;
    	String result = null;
    	try {
    		writer = new StringWriter();
    		printWriter = new PrintWriter(writer);
    		
    		exception.printStackTrace(printWriter);
        	result = writer.toString();
        	
    	} catch (Exception e) {
    		throw new PartnerException(e);
    	}finally {
    		if(printWriter != null) printWriter.close();
    		try{
    			if(writer != null) writer.close();
    		}catch(Exception e1){
    			throw new PartnerException(e1); 
    		}
    	}
    	
    	return result;
    }
	
	public static String getProcessUnit(String type, String value) {
		String result = null;
		if(!StringUtil.isEmpty(type) && !StringUtil.isEmpty(value)){
			int unit = value.hashCode() % ProcessUnit.COUNT.getValue();
			unit = unit < 0 ? unit * -1 : unit;
			result = type + "_" + String.valueOf(unit);
		}
		return result;
	}
	
	public static List<String> getListFromArray(String...strings){
		List<String> result = null; 
		int arrayCount = 0;
		if(strings != null && strings.length > 0){
			result = new ArrayList<String>();
			arrayCount = strings.length;
			for(int i=0; i < arrayCount; i++){
				result.add(strings[i]);
			}
		}
		return result;
	}

	public static int getIntValue(String value){
		int result = 0;
		if(!isEmpty(value)){
			result = Integer.valueOf(value);
		}
		return result;
	}
	public static long getLongValue(String value){
		long result = 0;
		if(!isEmpty(value)){
			result = Long.valueOf(value);
		}
		return result;
	}
	public static String addBlank(String data, int size) {
		String result = "";
		StringBuffer sb = new StringBuffer();
		int dataLength = 0;
		for(int i=0; i < size; i++){
			sb.append(" ");
		}
		if(data == null || "".equals(data)){
			result = sb.toString();
		} else {
			dataLength = data.length();
			try{
				if(dataLength > size){
					result = data.substring(0, size);
				} else if (dataLength == size) {
					result = data;
				} else {
					result = data + sb.toString().substring(dataLength);
				}
			}catch(Exception e){
				logger.error("data : " + data + ", blank.length() : " + sb.toString().length());
				throw new PartnerException(e);
			}
		}
		
		return result;
	}

}
