package task1;

import java.util.Scanner;

public class PCB {
	private String name;//������
	private int time;//Ҫ������ʱ��
	private int priority;//���ȼ�
	private boolean status;//״̬��0Ϊ��� 1Ϊ����
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
		System.out.println("�������������");
		name=scanner.nextLine();
		System.out.println("���������Ҫ��ʱ�䣺");
		time=scanner.nextInt();
		System.out.println("���������ȼ���");
		priority=scanner.nextInt();
		status=true;
		System.out.println("�����ɹ���");
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
			System.out.println("����"+name+"�������У�");
		}
	}
}
