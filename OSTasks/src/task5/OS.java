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
		System.out.println(produceNum+"号产品已被生产！");
	}
	public void consume() {
		System.out.println(consumeNum+"号产品已被消费！");
	}
	public void p() {
		if(current==producer) {
			System.out.println("生产者进行p操作！");
			s1--;
			if(s1<0) {
				System.out.println("生产者等待！");
				current.state=2;
				current.waitReason=1;
				current.breakpoint=0;
			}
		}
		else {
			System.out.println("消费者进行p操作！");
			s2--;
			if(s2<0) {
				System.out.println("消费者等待！");
				current.state=2;
				current.waitReason=2;
				current.breakpoint=0;
			}
		}
	}
	public void v() {
		if(current==producer) {
			System.out.println("生产者进行v操作！");
			s2++;
			if(s2<=0&&consumer.state==2) {
				consumer.state=0;
			}
		}
		else {
			System.out.println("消费者进行v操作！");
			s1++;
			if(s1<=0&&producer.state==2) {
				producer.state=0;
			}
		}
	}
	public void put() {
		buffer[in]=produceNum;
		System.out.println("生产者在缓冲区存入了产品！");
		in=(in+1)%10;
	}
	public void get() {
		consumeNum=buffer[out];
		System.out.println("消费者在缓存区取出了产品！");
		out=(out+1)%10;
	}
	public void myGoto() {
		if(current==producer) {
			System.out.println("生产者执行goto！");
			if(produceNum>=maxProduction) {
				System.out.println("生产者生产完毕！");
				current.state=3;
			}
		}
		else {
			System.out.println("消费者执行goto！");
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
				System.out.println("队列为空 调度结束！");
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