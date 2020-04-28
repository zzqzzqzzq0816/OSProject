package task1;

import java.util.ArrayList;
import java.util.Comparator;

public class OS {
	private ArrayList<PCB> readyList=new ArrayList<PCB>();
	private ArrayList<PCB> endList=new ArrayList<PCB>();
	public void init() {
		for(int i=0;i<5;i++) {
			PCB p=new PCB();
			readyList.add(p);
		}
	}
	public void show() {
		if(!readyList.isEmpty()) {
			System.out.println("就绪进程如下：");
			for(PCB p:readyList) {
				System.out.println(p);
			}
		}
		if(!endList.isEmpty()) {
			System.out.println("结束进程如下：");
			for(PCB p:endList) {
				System.out.println(p);
			}
		}
	}
	public void run() {
		int num=1;
		readyList.sort(new Comparator<PCB>() {
			@Override
			public int compare(PCB o1, PCB o2) {
				int result=o1.getPriority()<o2.getPriority()?1:-1;
				return result;
			}	
		});
		while(!readyList.isEmpty()) {
			System.out.println("第"+num+"轮运行：");
			num++;
			readyList.get(0).run();
			if(!readyList.get(0).isStatus()) {
				endList.add(readyList.get(0));
				readyList.remove(0);
			}
			readyList.sort(new Comparator<PCB>() {
				@Override
				public int compare(PCB o1, PCB o2) {
					int result=o1.getPriority()<o2.getPriority()?1:-1;
					return result;
				}	
			});
			show();
		}
		System.out.println("所有进程完成！");
	}
}
