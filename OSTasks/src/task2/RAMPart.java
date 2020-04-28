package task2;

public class RAMPart {
	private double capacity;
	private boolean state;
	private double startAddress;
	private int workIndex;
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public boolean isState() {
		return state;
	}
	public RAMPart(double capacity, boolean state, double startAddress, int workIndex) {
		super();
		this.capacity = capacity;
		this.state = state;
		this.startAddress = startAddress;
		this.workIndex = workIndex;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "RAMPart [capacity=" + capacity + ", state=" + state + ", startAddress=" + startAddress + ", workIndex="
				+ workIndex + "]";
	}
	public double getStartAddress() {
		return startAddress;
	}
	public void setStartAddress(double startAddress) {
		this.startAddress = startAddress;
	}
	public int getWorkIndex() {
		return workIndex;
	}
	public void setWorkIndex(int workIndex) {
		this.workIndex = workIndex;
	}
}
