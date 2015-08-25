package com.pp.bplat.common.support.util;

import java.io.File;

/**
 * File 관련 util
 * <pre>
 * com.kt.prm.common.support.util
 * PrmFileUtil.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2013. 9. 16. 오전 10:55:42
 * @Version : 1.0
 */
public abstract class PrmFileUtil {
    
    public static void initDirectory(String path) {
        
        File file = new File(path);
        
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File fileBean : files) {
                initDirectory(fileBean.getAbsolutePath());
            }
        }
        
        file.delete();
    }
    
    public static void initMakeDirectory(String path) {
        File file = new File(path);
        if(!file.exists()) 
            file.mkdirs();
    }

}
