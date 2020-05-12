package task5;

public class PCB {
	public String name;
	public int state;//进程状态：0就绪态 1运行态 2等待态 3完成态
	public int waitReason;//等待原因：1为等待s1 2为等待s2
	public int breakpoint;//断点
	public PCB(String name, int state, int waitReason, int breakpoint) {
		super();
		this.name = name;
		this.state = state;
		this.waitReason = waitReason;
		this.breakpoint = breakpoint;
	}
}
