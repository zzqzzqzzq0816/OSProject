package task5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入生产者的最大产量：");
		OS os=new OS(scanner.nextInt());
		os.run();
	}
	
}
