package Advanced_Java.FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderProgram {
	public static void main(String[] args) throws IOException {
		File f = new File("D:\\Capgemini Training\\Discussion (daywise)\\Advanced Java training\\test.txt");
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader(fr);
		String s1="";
		String s2="";
		while ((s1=bf.readLine()) != null) {
			s2=s2+s1;
		}
		System.out.println(s2);
		bf.close();
	}
}
