package com.pp.bplat.common.support.searcher;

/**
 * 비교조건 Interface
 * <pre>
 * com.kt.prm.common.support.searcher
 * PrmComparator.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 6. 20. 오후 5:59:08
 * @Version : 1.0
 */
public interface PrmComparator {
    
    /**
     * Collection에 들어있는 bean이 keyObject의 조건에 맞는지 check
     * @param beanObj 검색대상의 Collection에 들어있는 bean
     * @param keyObject 검색조건이 들어있는 keyObject
     * @return 일치할경우 true, 불일치시 false
     */
    public boolean isEqual(Object beanObj,Object keyObject);
}
