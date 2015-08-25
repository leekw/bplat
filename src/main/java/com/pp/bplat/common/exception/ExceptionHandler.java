package com.pp.bplat.common.exception;

import java.sql.SQLException;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PRM ExceptionHander
 * <pre>
 * com.kt.prm.common.exception
 * ExceptionHandler.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 11. 7. 오후 2:55:26
 * @Version : 1.0
 */
public class ExceptionHandler {
    
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    
    private enum Code {
        SQL_ERROR_CODE_PREFIX("ORA-"),COL(" : "),ZERO("00000");
        private String value;
        private Code(String value) { this.value = value;} 
        private String getValue() { return this.value;}
    }

	private static void writeLog(IPartnerException pe) {
		if (logger.isErrorEnabled()) {
			StringBuffer strBuff = new StringBuffer();
			strBuff.append(pe.getCode()).append(Code.COL.getValue()).append(pe.getMessage());

			logger.error(strBuff.toString(), (Throwable) pe);
		}
	}

	public static Throwable handleException(Throwable t) {
		IPartnerException exception = null;
		if (t instanceof IPartnerException)
			exception = (IPartnerException) t;
		else {
			SQLException sqlException = extractSQLException(t);
			if (sqlException != null) {
				DecimalFormat formatter = new DecimalFormat(Code.ZERO.getValue());
				String sqlErrorCode = Code.SQL_ERROR_CODE_PREFIX.getValue() + formatter.format(sqlException.getErrorCode());
				exception = new PartnerException(sqlErrorCode, sqlException.getMessage(), t);
			} else {
				exception = new PartnerException(t);
			}
		}

		if (!exception.isWriteLog()) {
			writeLog(exception);
			exception.setWriteLog(true);
		}
		return (Throwable) exception;
	}

	public static SQLException extractSQLException(Throwable t) {
		SQLException sqlException = null;

		if (t != null) {
			if (t instanceof SQLException) {
				sqlException = (SQLException) t;
				if (sqlException.getCause() != null)
					sqlException = extractSQLException(t.getCause());
				else {
					if (sqlException.getNextException() != null)
						sqlException = extractSQLException((Throwable) sqlException.getNextException());
				}
			} else {
				if (t.getCause() != null)
					sqlException = extractSQLException(t.getCause());
			}
		}

		return sqlException;
	}
}
