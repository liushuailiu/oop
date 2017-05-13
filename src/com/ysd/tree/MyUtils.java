package com.ysd.tree;

import java.io.File;

/**
 * Created by fanliyang on 17-5-13.
 */
public class MyUtils {
    public void getTheFileName(String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println(fileName + "not exists");
            return;
        }
        File[] files = file.listFiles();
        if(files!=null){
            for (File f : files) {
                if(f.isDirectory()){
                    System.out.println(f.getName()+"目录");
                    getTheFileName(f.getAbsolutePath());
                }else {
                    System.out.println(f.getName());
                }
            }
        }
    }
}
