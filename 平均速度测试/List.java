import java.util.ArrayList;
public class List {
public static void main(String args[]) {
	int n=10000;
	long time=0;
	ArrayList<Integer> list=new ArrayList<>();
	for(int i=0;i<n;i++) {
		list.add(i);
				}
	
	
	for(int i=0;i<n;i++)
	{
		int j=list.get(i);
		long start=System.nanoTime();
		boolean k=list.contains(j);
		long end=System.nanoTime();
		long t=end-start;
		time=time+t;
	}
	
	System.out.println("Æ½¾ù²éÑ¯ËÙ¶ÈÎª£º"+time/n+"ns");
}
}
