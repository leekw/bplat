package com.pp.bplat.common.exception.settlement;

import com.pp.bplat.common.exception.PartnerException;

/**
 * settlement module process 시 runtime exception 
 * <pre>
 * com.kt.prm.common.exception.settlement
 * SettlementException.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 5. 2. 오전 11:27:37
 * @Version : 1.0
 */
public class SettlementException extends PartnerException {

    private static final long serialVersionUID = 3432309886356217770L;

    public SettlementException(String code) {
        super(code);
        // TODO Auto-generated constructor stub
    }

}
