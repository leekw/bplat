package com.pp.bplat.common.support.web.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <pre>
 * com.kt.prm.common.support.web.file
 * FileRepository.java
 * 
 * Multipart file repository
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:29:46
 * @Version : 1.0
 */
public class FileRepository {
    
    private String path;
    
    public FileRepository(String path) {
        this.path = path;
        File saveFolder = new File(path);
        if(!saveFolder.exists() || saveFolder.isFile()){
            saveFolder.mkdirs();
        }       
    }
   
    public String saveFile(MultipartFile sourcefile) throws IOException{
    	String key = null;
        if ((sourcefile==null)||(sourcefile.isEmpty())) key = null;
        key = UUID.randomUUID().toString();
        String targetFilePath = path+"/"+ key;
        sourcefile.transferTo(new File(targetFilePath));
        return key;
    }

}
