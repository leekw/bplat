package com.bplat.common;

import org.junit.Test;

import com.bplat.common.support.security.StringEncrypter;

public class SecurityTest {
	
	@Test
	public void testSecurity() throws Exception {
		StringEncrypter ss = new StringEncrypter(false);
		try {
			String eValue = ss.encrypt("test1234567test1234567test1234567test1234567test1234567test1234567test1234567");
			System.out.print(" encription :" +  eValue + "\n");
			String dValue = ss.decrypt(eValue);
			System.out.println(" decription :" + dValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
