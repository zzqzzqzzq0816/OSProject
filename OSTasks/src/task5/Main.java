package task5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����������ߵ���������");
		OS os=new OS(scanner.nextInt());
		os.run();
	}
	
}
