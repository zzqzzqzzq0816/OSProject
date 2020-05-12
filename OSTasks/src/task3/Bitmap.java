package task3;

public class Bitmap {
	private int[][] bitmap=new int[8][8];
	private int[][] workmap=new int[8][8];
	public Bitmap() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				bitmap[i][j]=0;
				workmap[i][j]=0;
			}
		}
	}
	public void apply(Work work) {
		int remainSize=0;
		int workSize=work.getSize();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(bitmap[i][j]==0) remainSize++;
			}
		}
		if(remainSize<workSize) {
			System.out.println("---申请失败！---");
			System.out.println();
			return;
		}
		int index=1;
		System.out.println("---开始申请---");
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(workSize>0&&bitmap[i][j]==0) {
					bitmap[i][j]=1;
					workmap[i][j]=work.getIndex();
					System.out.println("作业号："+work.getIndex()+"作业大小："+work.getSize());
					System.out.println("本次作业第"+index+"块");
					System.out.println("柱面号："+i);
					System.out.println("磁道号："+(j/4));
					System.out.println("物理记录号："+(j%4));
					index++;
					workSize--;
				}
			}
		}
		System.out.println("---申请成功！本次申请空间："+work.getSize()+"---");
		System.out.println();
	}
	public void release(int workIndex) {
		int index=1;
		System.out.println("---开始释放---");
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(workmap[i][j]==workIndex) {
					workmap[i][j]=0;
					bitmap[i][j]=0;
					System.out.println("作业号："+workIndex+"第"+index+"块");
					System.out.println("字节号："+i);
					System.out.println("位数:"+j);
					index++;
				}
			}
		}
		if(index!=1) {
			System.out.println("---释放成功！本次释放空间："+(index-1)+"---");
		}
		else {
			System.out.println("---释放失败！---");
		}
		System.out.println();
	}
	public void displayBitmap() {
		System.out.println("---位示图---");
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int i=0;i<8;i++) {
			System.out.print(i+" ");
			for(int j=0;j<8;j++) {
				System.out.print(bitmap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
