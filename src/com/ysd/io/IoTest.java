package com.ysd.io ;

import com.ysd.pojo.Grade;
import com.ysd.pojo.Student;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;


public class IoTest {

	private static final String path = "C:/";

	public static void main(String[] args) throws Exception {

		//createAndDeleteDirecctory();

		//selectFile(path);

		//createAndDeleteFile();

		//writeFile();

		//readFile();

		//testStream();

		//testBufferedStream();

		//writeObject();

		//readObiect();

		//testFilereadOrWrite();

		//testStreamReader();

		//testBufferedReaderAndWriter();

		//testPrintWrite();

		copyPictures();
	}

	//图片复制

	public static void copyPictures() throws Exception{

		//原路径
		String path = "C:\\Users\\fly\\Pictures\\Saved Pictures\\巴塞罗那.jpg";
		//目标路径
		String targetPath = "D:\\UTIL\\SQL\\我的名字.";

		File file = new File(path);
		String fileName = file.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null ;
		BufferedInputStream bufferedInputStream = null ;
		BufferedOutputStream bufferedOutputStream = null;

		fileInputStream = new FileInputStream(file);
		fileOutputStream = new FileOutputStream(targetPath+suffix);
		bufferedInputStream = new BufferedInputStream(fileInputStream,1024);
		bufferedOutputStream = new BufferedOutputStream(fileOutputStream);



		byte[] data = new byte[1024];

		while(bufferedInputStream.read(data) != -1) {
			bufferedOutputStream.write(data);
		}

		fileInputStream.close();
		bufferedInputStream.close();
		fileOutputStream.flush();
		fileOutputStream.close();
		bufferedOutputStream.flush();
		bufferedInputStream.close();

		System.out.println("图片复制完成");



	}


	//printWrite测试

	public static void testPrintWrite() throws IOException {

		PrintWriter printWriter = new PrintWriter("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt");
		printWriter.println("换一个行");
		printWriter.write("新的一行");

		printWriter.flush();
		printWriter.close();

		System.out.println("文件读取完成");

		FileReader fileReader = new FileReader("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		char[] data = new char[1024];
		int length = bufferedReader.read(data);
		String txt = new String(data,0,length);

		System.out.println(txt);
		bufferedReader.close();
		fileReader.close();

		System.out.println("文件读取完成");


	}


	//BufferedReader与BufferedWriter

	public static void testBufferedReaderAndWriter() throws IOException {


		FileWriter fileWriter = new FileWriter("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt",true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter,1024);
		bufferedWriter.write("杨幂");
		bufferedWriter.flush();
		bufferedWriter.close();
		fileWriter.close();
		System.out.println("文件写入成功");

		FileReader fileReader = new FileReader("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String txt = bufferedReader.readLine();
		System.out.println(txt);
		System.out.println("文件读取成功");


	}


	//StreamReader测试

	public static void testStreamReader() throws IOException {

		FileOutputStream fileOutputStream = new FileOutputStream("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt",true);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		outputStreamWriter.write("今天的痛苦是明白最甜美的回忆");
		outputStreamWriter.close();
		System.out.println("文件输入完成");

		FileInputStream fileInputStream = new FileInputStream("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
		char[] data = new char[1024];
		int length = inputStreamReader.read(data);
		String txt = new String(data, 0, length);
		System.out.println(txt);
		inputStreamReader.close();
		System.out.println("文件读取完成");

	}


	//字符流读取

	public static void testFilereadOrWrite() throws IOException {

		File file = new File("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt");
		FileWriter fileWriter = new FileWriter(file,false);
		fileWriter.write("文件字符流读取");
		fileWriter.close();

		FileReader fileReader = new FileReader(file);
		char[] data = new char[1024];
		int length = fileReader.read(data);
		System.out.println(new String(data,0,length));

		fileReader.close();


	}

	//对象读取

	public static void readObiect() {

		File file = new File("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt");

		try {

			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			Student student = (Student) object;
			System.out.println(student.toString());

			objectInputStream.close();
			fileInputStream.close();

			System.out.println("文件读取成功");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	//对象写入

	public static void writeObject() throws IOException {

		File file = new File("D:\\java-oop\\第六章\\IO操作\\stuInfo.txt");

		if(!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fileOutputStream = new FileOutputStream(file,false);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		Grade grade = new Grade(1,"1601");
		Student student = new Student("杜广源",20,grade);

		objectOutputStream.writeObject(student);
		objectOutputStream.close();
		fileOutputStream.close();

		System.out.println("文件写入成功");


	}

	// 缓冲字节流
	public static void testBufferedStream() {
		File file = new File("D:\\java-oop\\第六章\\IO操作\\测试.txt");
		if(file.exists()) {
			file.delete();
		}else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {

			byte[] bytes = new byte[512];

			FileInputStream fileInputStream = new FileInputStream("D:\\java-oop\\第六章\\IO操作\\学习.txt");
			FileOutputStream fileOutputStream = new FileOutputStream("D:\\java-oop\\第六章\\IO操作\\测试.txt");

			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream,512);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream,512);

			while(bufferedInputStream.read(bytes) != -1) {
				bufferedOutputStream.write(bytes);
			}

			bufferedOutputStream.flush();
			bufferedInputStream.close();
			fileInputStream.close();
			bufferedOutputStream.close();
			fileOutputStream.close();

			System.out.println("文件复制完成");



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// 字节流测试
	public static void testStream() {
		File file = new File("D:\\java-oop\\第六章\\IO操作\\学习.txt");

		try {

			FileOutputStream fileOutputStream = new FileOutputStream(file,false);
			String string = "hello-world";
			fileOutputStream.write(string.getBytes());
			fileOutputStream.close();
			System.out.println("数据写入完成");

			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int length = fileInputStream.read(bytes);
			System.out.println(new String(bytes,0,length));
			fileInputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//文件读取
	public static void readFile() {

		File file = new File("D:\\java-oop\\第六章\\IO操作\\学习.txt");

		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
			randomAccessFile.skipBytes(14);
			byte[] bytes = new byte[4];
			randomAccessFile.read(bytes);
			String name_3 = new String(bytes);
			Integer age_3 = randomAccessFile.readInt();
			System.out.println("第三个人的姓名:"+name_3 + ":"+"年龄:"+age_3);
			randomAccessFile.seek(0);
			byte[] b = new byte[3];
			randomAccessFile.read(b);
			String name_1 = new String(b);
			Integer age_1 = randomAccessFile.readInt();
			System.out.println("第一个人的姓名:"+name_1 + ":"+"年龄:"+age_1);
			randomAccessFile.close();
			System.out.println("数据读取成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//写入文件
	public static void writeFile() {
		File file = new File("D:\\java-oop\\第六章\\IO操作\\学习.txt");

		try {

			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
			randomAccessFile.writeBytes("jim");
			randomAccessFile.writeInt(23);
			randomAccessFile.writeBytes("tom");
			randomAccessFile.writeInt(24);
			randomAccessFile.writeBytes("john");
			randomAccessFile.writeInt(22);
			randomAccessFile.close();
			System.out.println("文件写入成功");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//创建文件
	public static void createAndDeleteFile() {
		File file = new File("D:\\java-oop\\第六章\\IO操作\\学习.txt");
		if(file.exists()) {
			file.delete();
		}else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length()+"bytes");
		System.out.println(file.isDirectory() ? "目录":"文件");


	}

	//创建和删除文件夹
	public static void createAndDeleteDirecctory() {
		File file2 = new File("d:/java-oop/第六章/IO操作");
		file2.mkdirs();
		System.out.println("文件创建成功");
		File file = new File("d:/source");
		if(file.isDirectory()) {
			file.delete();
			System.out.println("文件删除成功");
		}
	}

	//递归遍历硬盘文件夹
	public static void selectFile(String path) {


		File file = new File(path);

		File[] files = file.listFiles();

		if(files==null) {
			return;
		}

		for (File f : files) {

			if(f.isDirectory()) {

				System.out.println(f.getName()+"目录");
				selectFile(f.getAbsolutePath());

			}else {

				System.out.println(f.getName());

			}

		}
	}

}
