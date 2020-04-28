package task2;

import java.util.LinkedList;

public class RAMList {
	public LinkedList<RAMPart> RAMPartList=new LinkedList<RAMPart>();
	public RAMList() {
		RAMPartList.add(new RAMPart(128,true,0,-1));
	}
	public boolean apply(Work work) {
		for(int i=0;i<RAMPartList.size();i++) {
			if(RAMPartList.get(i).isState()) {
				if(RAMPartList.get(i).getCapacity()>work.getSize()) {
					RAMPartList.add(i, new RAMPart(work.getSize(), false, 
							RAMPartList.get(i).getStartAddress(), work.getWorkIndex()));
					RAMPartList.get(i+1).setCapacity(RAMPartList.get(i+1).getCapacity()
							-work.getSize());
					RAMPartList.get(i+1).setStartAddress(RAMPartList.get(i).getStartAddress()
							+work.getSize());
					return true;
				}
				else if(RAMPartList.get(i).getCapacity()==work.getSize()) {
					RAMPartList.get(i).setState(false);
					RAMPartList.get(i).setWorkIndex(work.getWorkIndex());
					return true;
				}
			}
		}
		return false;
	}
	public boolean release(int workIndex) {
		for(int i=0;i<RAMPartList.size();i++) {
			if(RAMPartList.get(i).getWorkIndex()==workIndex) {
				RAMPartList.get(i).setState(true);
				RAMPartList.get(i).setWorkIndex(-1);
				merge();
				return true;
			}
		}
		return false;
	}
	public void merge() {
		if(RAMPartList.size()>1) {
			for(int i=0;i<RAMPartList.size()-1;i++) {
				if(RAMPartList.get(i).isState()&&RAMPartList.get(i+1).isState()) {
					RAMPartList.get(i).setCapacity(RAMPartList.get(i).getCapacity()
							+RAMPartList.get(i+1).getCapacity());
					RAMPartList.remove(i+1);
					i--;
				}
			}
		}
	}
}
