package com.ysd.operation;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fly
 * @create 2017-09-21 15:51
 * @desc JAVA--OOP 第六章上机任务
 */
public class ChapterSixAfterSchoolExercises {

    public static void main(String[] args) {
        //selectDriveLetterAllFile();
        //selectAllFile(path);
        breakpoint();
    }

    //第一题,查看指定盘符下的所有文件和目录信息

    private static final String path = "d:\\";
    public static void selectDriveLetterAllFile(){
        File file = new File(path);
        File[] files = file.listFiles();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy--MM--dd");
        for (File f:files) {

            System.out.println(f.getName());
            System.out.println(simpleDateFormat.format(new Date(f.lastModified())));
            System.out.println(f.length());
            System.out.println();

        }
    }

    //第二题,递归遍历D盘下所有文件

    public static void selectAllFile(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        if(files==null)
            return;
        for (File f : files) {
            System.out.println(f.getName());
            selectAllFile(f.getAbsolutePath());
        }
    }

    //第三题  使用 RandomAccessFile 模拟断点续传
    public static void breakpoint(){
        String path = "D:\\java-oop\\第六章\\IO操作\\stuInfo.txt";
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[250];
            int length = fileInputStream.read(bytes);
            System.out.println("文件讀取完成");
            FileOutputStream fileOutputStream =
                    new FileOutputStream("D:\\java-oop\\第六章\\IO操作\\测试.txt",true);
            fileOutputStream.write(new String(bytes,0,length).getBytes());
            System.out.println("文件傳輸中斷");
            System.out.println("文件继续传输.......");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
            randomAccessFile.seek(250);
            byte[] data = new byte[1024];
            int size = randomAccessFile.read(data);
            fileOutputStream.write(data,0,size);
            System.out.println("文件传输完成");
            randomAccessFile.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
