package task5;

import java.util.Random;

public class OS {
	private int produceNum=0;
	private int consumeNum=0;
	private int s1=10;
	private int s2=0;
	private int in=0;
	private int out=0;
	private int[] buffer=new int[10];
	private int PC=0;
	private int maxProduction=20;
	private int[] producerExe=new int[]{4,0,2,1,6};
	private int[] consumerExe=new int[] {0,3,1,5,6};
	private PCB producer=new PCB("producer",0,0,0);
	private PCB consumer=new PCB("consumer",0,0,0);
	private PCB current=producer;
	public OS(int maxProduction) {
		this.maxProduction=maxProduction;
	}
	public void produce() {
		produceNum++;
		System.out.println(produceNum+"�Ų�Ʒ�ѱ�������");
	}
	public void consume() {
		System.out.println(consumeNum+"�Ų�Ʒ�ѱ����ѣ�");
	}
	public void p() {
		if(current==producer) {
			System.out.println("�����߽���p������");
			s1--;
			if(s1<0) {
				System.out.println("�����ߵȴ���");
				current.state=2;
				current.waitReason=1;
				current.breakpoint=0;
			}
		}
		else {
			System.out.println("�����߽���p������");
			s2--;
			if(s2<0) {
				System.out.println("�����ߵȴ���");
				current.state=2;
				current.waitReason=2;
				current.breakpoint=0;
			}
		}
	}
	public void v() {
		if(current==producer) {
			System.out.println("�����߽���v������");
			s2++;
			if(s2<=0&&consumer.state==2) {
				consumer.state=0;
			}
		}
		else {
			System.out.println("�����߽���v������");
			s1++;
			if(s1<=0&&producer.state==2) {
				producer.state=0;
			}
		}
	}
	public void put() {
		buffer[in]=produceNum;
		System.out.println("�������ڻ����������˲�Ʒ��");
		in=(in+1)%10;
	}
	public void get() {
		consumeNum=buffer[out];
		System.out.println("�������ڻ�����ȡ���˲�Ʒ��");
		out=(out+1)%10;
	}
	public void myGoto() {
		if(current==producer) {
			System.out.println("������ִ��goto��");
			if(produceNum>=maxProduction) {
				System.out.println("������������ϣ�");
				current.state=3;
			}
		}
		else {
			System.out.println("������ִ��goto��");
		}
		PC=0;
	}
	public void run() {
		while(true) {
			current.breakpoint=PC;
			Random random = new Random();
			int ranNum=random.nextInt(2);
			if(producer.state==0&&consumer.state==0) {
				current=(ranNum==0)?producer:consumer;
			}
			else if(producer.state==0) {
				current=producer;
			}
			else if(consumer.state==0) {
				current=consumer;
			}
			else {
				System.out.println("����Ϊ�� ���Ƚ�����");
				return;
			}
			PC=current.breakpoint;
			switch((current==producer)?producerExe[PC++]:consumerExe[PC++]) {
				case 0:
					p();break;
				case 1:
					v();break;
				case 2:
					put();break;
				case 3:
					get();break;
				case 4:
					produce();break;
				case 5:
					consume();break;
				case 6:
					myGoto();break;
				default:
					break;
			}
		}
	}
}