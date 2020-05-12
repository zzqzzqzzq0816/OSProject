package task3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Bitmap bitmap = new Bitmap();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("---主菜单---");
			System.out.println("请输入数字完成对应的操作：");
			System.out.println("1：分配空间 2：释放空间 3；查看位示图");
			switch(scanner.nextInt()) {
				case 1:
					System.out.println("请输入作业号及作业大小:");
					bitmap.apply(new Work(scanner.nextInt(),scanner.nextInt()));
					break;
				case 2:
					System.out.println("请输入想要释放的作业号:");
					bitmap.release(scanner.nextInt());
					break;
				case 3:
					bitmap.displayBitmap();
					break;
				default:
					System.out.println("输入错误！");
					break;
			}
		}
	}
}
