package task2;

public class Work {
	private int workIndex;
	private double size;
	public int getWorkIndex() {
		return workIndex;
	}
	public void setWorkIndex(int workIndex) {
		this.workIndex = workIndex;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public Work(int workIndex, double size) {
		this.workIndex = workIndex;
		this.size = size;
	}
	
}
