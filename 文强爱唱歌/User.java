import java.util.Scanner;
//定义一个用户类
public class User {
	User(){};
	Song s;
	public boolean Adding(){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入歌曲名称：");
		String a=in.next();
		System.out.println("请输入歌曲原唱歌手：");
		String b=in.next();
		System.out.println("请输入歌曲时间：");
		double c=in.nextDouble();
		s=new Song(a,b,c);
		return true;
}
}