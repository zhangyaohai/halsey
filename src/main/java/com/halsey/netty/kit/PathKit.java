package com.halsey.netty.kit;

import java.io.File;

/**
 * create by zhangyaohai
 * 2018-02-08 14:24
 **/
public class PathKit {

    private static String webRootPath;
    private static String rootClassPath;

    public static String getPath(Class classz){
        String path = classz.getResource("").getPath();
        return new File(path).getAbsolutePath();
    }

    public static String getPath(Object object) {
        String path = object.getClass().getResource("").getPath();
        return new File(path).getAbsolutePath();
    }

    public static String getRootClassPath() {
        if(rootClassPath == null) {
            try {
                String path = PathKit.class.getClassLoader().getResource("").toURI().getPath();
                rootClassPath = new File(path).getAbsolutePath();
            }catch (Exception e){
                String path = PathKit.class.getClassLoader().getResource("").getPath();
                rootClassPath = new File(path).getAbsolutePath();
            }
        }
        return rootClassPath;
    }

    public static String getPackagePath(Object object){
        Package p = object.getClass().getPackage();
        return p != null ? p.getName().replaceAll("\\.", "/"):"";
    }
}
