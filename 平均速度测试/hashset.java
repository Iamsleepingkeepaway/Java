import java.util.HashSet;
import java.util.ArrayList;
public class hashset {
	public static void main(String args[]) {
		int n=20000;
		long time=0;
		HashSet<Integer> h=new HashSet<>();
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<n;i++) {
			int j=(int)Math.random()*n;
			h.add(j);
			a.add(j);
			 //h.contains(j);
					}
		for(int i=0;i<n;i++) {
			int j=a.get(i);
			long start=System.nanoTime();
			boolean k=h.contains(j);
			long end=System.nanoTime();
			long t=end-start;
			time=time+t;
		}
		System.out.println("ƽ����ѯ�ٶ�Ϊ��"+time/n+"ns");
}
}
