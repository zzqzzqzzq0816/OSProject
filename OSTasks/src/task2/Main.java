package task2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		RAMList ramList=new RAMList();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("---���˵�---");
			System.out.println("������������ɶ�Ӧָ��");
			System.out.println("1:������ҵ");
			System.out.println("2:�ͷ���ҵ");
			System.out.println("3:�鿴�ڴ�״��");
			switch(scanner.nextInt()) {
			case 1:
				System.out.println("��������ҵ�ź���ҵ��С��");
				if(!ramList.apply(new Work(scanner.nextInt(),scanner.nextDouble()))) {
					System.out.println("����ʧ�ܣ��ڴ治�㣡");
				}
				break;
			case 2:
				System.out.println("���������ͷŵ���ҵ�ţ�");
				if(!ramList.release(scanner.nextInt())) {
					System.out.println("�ͷ�ʧ�ܣ���ҵ�Ŵ���");
				}
				break;
			case 3:
				int ramIndex=1;
				for(int i=0;i<ramList.RAMPartList.size();i++) {
					System.out.println("---��"+(i+1)+"����---");
					if(ramList.RAMPartList.get(i).isState()) {
						System.out.println("---��"+ramIndex+"���з���---");
					}
					System.out.println(ramList.RAMPartList.get(i));
				}
				break;
			default: 
				break;
			}
		}
	}
}
