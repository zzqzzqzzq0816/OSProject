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
			System.out.println("---����ʧ�ܣ�---");
			System.out.println();
			return;
		}
		int index=1;
		System.out.println("---��ʼ����---");
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(workSize>0&&bitmap[i][j]==0) {
					bitmap[i][j]=1;
					workmap[i][j]=work.getIndex();
					System.out.println("��ҵ�ţ�"+work.getIndex()+"��ҵ��С��"+work.getSize());
					System.out.println("������ҵ��"+index+"��");
					System.out.println("����ţ�"+i);
					System.out.println("�ŵ��ţ�"+(j/4));
					System.out.println("�����¼�ţ�"+(j%4));
					index++;
					workSize--;
				}
			}
		}
		System.out.println("---����ɹ�����������ռ䣺"+work.getSize()+"---");
		System.out.println();
	}
	public void release(int workIndex) {
		int index=1;
		System.out.println("---��ʼ�ͷ�---");
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(workmap[i][j]==workIndex) {
					workmap[i][j]=0;
					bitmap[i][j]=0;
					System.out.println("��ҵ�ţ�"+workIndex+"��"+index+"��");
					System.out.println("�ֽںţ�"+i);
					System.out.println("λ��:"+j);
					index++;
				}
			}
		}
		if(index!=1) {
			System.out.println("---�ͷųɹ��������ͷſռ䣺"+(index-1)+"---");
		}
		else {
			System.out.println("---�ͷ�ʧ�ܣ�---");
		}
		System.out.println();
	}
	public void displayBitmap() {
		System.out.println("---λʾͼ---");
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
