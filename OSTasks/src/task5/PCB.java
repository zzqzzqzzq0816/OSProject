package task5;

public class PCB {
	public String name;
	public int state;//����״̬��0����̬ 1����̬ 2�ȴ�̬ 3���̬
	public int waitReason;//�ȴ�ԭ��1Ϊ�ȴ�s1 2Ϊ�ȴ�s2
	public int breakpoint;//�ϵ�
	public PCB(String name, int state, int waitReason, int breakpoint) {
		super();
		this.name = name;
		this.state = state;
		this.waitReason = waitReason;
		this.breakpoint = breakpoint;
	}
}
