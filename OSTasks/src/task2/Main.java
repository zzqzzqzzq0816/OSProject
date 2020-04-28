package task2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		RAMList ramList=new RAMList();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("---主菜单---");
			System.out.println("请输入数字完成对应指令");
			System.out.println("1:分配作业");
			System.out.println("2:释放作业");
			System.out.println("3:查看内存状况");
			switch(scanner.nextInt()) {
			case 1:
				System.out.println("请输入作业号和作业大小：");
				if(!ramList.apply(new Work(scanner.nextInt(),scanner.nextDouble()))) {
					System.out.println("分配失败！内存不足！");
				}
				break;
			case 2:
				System.out.println("请输入想释放的作业号：");
				if(!ramList.release(scanner.nextInt())) {
					System.out.println("释放失败！作业号错误！");
				}
				break;
			case 3:
				int ramIndex=1;
				for(int i=0;i<ramList.RAMPartList.size();i++) {
					System.out.println("---第"+(i+1)+"分区---");
					if(ramList.RAMPartList.get(i).isState()) {
						System.out.println("---第"+ramIndex+"空闲分区---");
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
