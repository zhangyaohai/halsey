package com.halsey.netty.kit;

import java.io.File;

/**
 * create by zhangyaohai
 * 2018-02-06 17:28
 **/
public class FileKit {

    public  static void delete(File file) {
        if (file != null && file.exists()) {
            if(file.isFile()) {
                file.delete();
            }
        }else if (file.isDirectory()) {
            File files[] = file.listFiles();
            if(files != null) {
                for (int i=0; i<files.length; i++) {
                    delete(files[i]);
                }
            }
            file.delete();
        }
    }

    public static String getFileExtension(String fileFullName) {
        if (StrKit.isBank(fileFullName)) {
            throw  new RuntimeException("fileFullName is empty");
        }
        return getFileExtension(new File(fileFullName));
    }

    public static String getFileExtension(File file) {
        if (null == file) {
            throw new NullPointerException();
        }
        String fileName = file.getName();
        int dotIdx = fileName.lastIndexOf('.');
        return (dotIdx == -1) ? "" : fileName.substring(dotIdx + 1);
    }
}
