package com.pp.bplat.common.support.configure;

import org.apache.commons.dbcp.BasicDataSource;

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.security.StringEncrypter;
import com.pp.bplat.common.support.util.Error;

public class PartnerBasicDataSource extends BasicDataSource {
	
	@Override
	public void setPassword(String password) {
		StringEncrypter stringEncrypter = new StringEncrypter(false);
		try {
			super.setPassword(stringEncrypter.decrypt(password));
		} catch (Exception e) {
			throw new PartnerException(Error.E0000.getValue());
		}
    }
	
	@Override
	public void setUsername(String username) {
		StringEncrypter stringEncrypter = new StringEncrypter(false);
		try {
			super.setUsername(stringEncrypter.decrypt(username));
		} catch (Exception e) {
			throw new PartnerException(Error.E0000.getValue());
		}
    }

}
