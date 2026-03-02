package Advanced_Java.FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamProgram {
	public static void main(String[] args) throws IOException {
		File f = new File("D:\\Capgemini Training\\Discussion (daywise)\\Advanced Java training\\test.txt");
		System.out.println(f.exists());
//		if(f.exists()) {
//			System.out.println(f.delete());
//		}
		
		if(! f.exists()) {
			System.out.println(f.createNewFile());
		}
		
		FileInputStream fls = new FileInputStream(f);
		
		int ch;
		while ((ch = fls.read()) != -1) {
			System.out.print((char)ch);
		}
		fls.close();
	}
}
