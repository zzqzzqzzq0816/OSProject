package task1;

import java.util.Scanner;

public class PCB {
	private String name;//进程名
	private int time;//要求运行时间
	private int priority;//优先级
	private boolean status;//状态：0为完成 1为就绪
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public PCB() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入进程名：");
		name=scanner.nextLine();
		System.out.println("请输入进程要求时间：");
		time=scanner.nextInt();
		System.out.println("请输入优先级：");
		priority=scanner.nextInt();
		status=true;
		System.out.println("创建成功！");
	}
	@Override
	public String toString() {
		return "PCB [name=" + name + ", time=" + time + ", priority=" + priority + ", status=" + status + "]";
	}
	public void run() {
		if(status) {
			time--;
			priority--;
			if(time<1) status=false;
			System.out.println("进程"+name+"正在运行！");
		}
	}
}
