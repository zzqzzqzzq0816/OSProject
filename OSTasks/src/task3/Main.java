package task3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Bitmap bitmap = new Bitmap();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("---���˵�---");
			System.out.println("������������ɶ�Ӧ�Ĳ�����");
			System.out.println("1������ռ� 2���ͷſռ� 3���鿴λʾͼ");
			switch(scanner.nextInt()) {
				case 1:
					System.out.println("��������ҵ�ż���ҵ��С:");
					bitmap.apply(new Work(scanner.nextInt(),scanner.nextInt()));
					break;
				case 2:
					System.out.println("��������Ҫ�ͷŵ���ҵ��:");
					bitmap.release(scanner.nextInt());
					break;
				case 3:
					bitmap.displayBitmap();
					break;
				default:
					System.out.println("�������");
					break;
			}
		}
	}
}
