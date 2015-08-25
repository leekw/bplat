package com.pp.bplat.common.support.searcher;

import java.util.ArrayList;
import java.util.List;

/**
 * List에 담긴 Object들중에 특정 조건에 맞는 것을 검색한다.
 * <pre>
 * com.kt.prm.common.support.searcher
 * Searcher.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 6. 20. 오후 6:00:04
 * @Version : 1.0
 */
public abstract class Searcher {
    
    /**
     * List에담긴 Object중 특정조건에 맞는 Object만 검색하여 List를 만들어준다 
     * @param targetList 검색대상 List
     * @param keyObj 검색하고픈 값이 들어있는 Object
     * @param comparator 검색조건 operator
     * @return 검색조건에 일치하는 Object가 담긴 List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List searchList(List targetList,Object keyObj,PrmComparator comparator)
    {
        List resultList = null;
        
        if(targetList != null)
        {
            resultList = new ArrayList();
            int size = targetList.size();
            
            for(int i=0;i<size;i++)
            {
                Object beanObj = targetList.get(i);
                if(comparator.isEqual(beanObj, keyObj))
                    resultList.add(beanObj);
            }
            
            if(resultList.size() == 0)
                resultList = null;
        }
        
        return resultList;
    }
    
    /**
     * List에담긴 Object중 특정조건에 맞지않는 Object만 검색하여 List를 만들어준다 
     * @param targetList 검색대상 List
     * @param keyObj 검색하고픈 값이 들어있는 Object
     * @param comparator 검색조건 operator
     * @return 검색조건에 일치하지 않는 Object가 담긴 List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List searchListNot(List targetList,Object keyObj,PrmComparator comparator)
    {
        List resultList = null;
        
        if(targetList != null)
        {
            resultList = new ArrayList();
            int size = targetList.size();
            
            for(int i=0;i<size;i++)
            {
                Object beanObj = targetList.get(i);
                if(!comparator.isEqual(beanObj, keyObj))
                    resultList.add(beanObj);
            }
            
            if(resultList.size() == 0)
                resultList = null;
        }
        
        return resultList;
    }
    
    /**
     * List에담긴 Object중 특정조건에 맞는 List의 첫번째 index를 얻어준다 
     * @param targetList 검색대상 List
     * @param keyObj 검색하고픈 값이 들어있는 Object
     * @param comparator 검색조건 operator
     * @return 특정조건에 맞는 List의 첫번째 index, 검색하고자하는 Object가 없을 경우 -1을 return한다 
     */
    @SuppressWarnings({ "rawtypes" })
    public static int searchIndex(List targetList,Object keyObj,PrmComparator comparator)
    {
        int resultIdx = -1;
        
        if(targetList != null)
        {
            int size = targetList.size();
            
            for(int i=0;i<size;i++)
            {
                Object beanObj = targetList.get(i);
                if(comparator.isEqual(beanObj, keyObj)) {
                	resultIdx = i;
                	break;
                }
            }
        }
        
        return resultIdx;
    }
    
    /**
     * List에담긴 Object중 특정조건에 맞는 List의 첫번째 Object를 얻어준다 
     * @param targetList 검색대상 List
     * @param keyObj 검색하고픈 값이 들어있는 Object
     * @param comparator 검색조건 operator
     * @return 특정조건에 맞는 List의 첫번째 Object, 검색하고자하는 Object가 없을 경우 null을 return한다 
     */
    @SuppressWarnings("rawtypes")
    public static Object searchObject(List targetList,Object keyObj,PrmComparator comparator)
    {
        Object resultObj = null;
        
        if(targetList != null)
        {
            int size = targetList.size();
            for(int i=0;i<size;i++)
            {
                Object beanObj = targetList.get(i);
                if(comparator.isEqual(beanObj, keyObj)) {
                	resultObj = beanObj;
                	break;
                }
            }
        }
        
        return resultObj;
    }
}
