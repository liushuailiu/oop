package com.ysd.io;

import java.io.*;

/**
 * @author fly
 * @create 2017-09-22 11:00
 * @desc 常见IO操作封装
 **/

public class FileUtils {

    /**
     * 通过字符流拷贝文件,将文件复制到指定目录
     * @author fly_0922
     * @param path
     * @param targetPath
     */

    public static void copyPathByBufferedStream(String path , String targetPath) throws IOException {
        File file = new File(path);
        File targetFile = new File(targetPath);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream,1024);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream,1024);
        byte[] bytes = new byte[1024];
        while (bufferedInputStream.read(bytes)>-1){
            bufferedOutputStream.write(bytes);
        }

        bufferedInputStream.close();
        bufferedInputStream.close();
        fileInputStream.close();
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        fileOutputStream.close();

        System.out.println("文件写入完成");
    }

    /**
     * 通过字节流拷贝文件,将文件复制到指定目录
     * @author fly_0922
     * @param path
     * @param targetPath
     */
    public static void copyPathByStream(String path , String targetPath) throws IOException {
        //源文件
        File file = new File(path);
        //目标文件
        File targetFile = new File(targetPath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(targetFile);
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            if(fileInputStream!=null)
                fileInputStream.close();
            if(fileOutputStream!=null)
                fileOutputStream.close();


        System.out.println("文件写入完成");
    }
}
