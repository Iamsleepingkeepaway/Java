import java.util.Scanner;

//定义股东类
public class Shareholder extends People{
	double sh=0;
double share() {
	System.out.println("请输入股东股份：");
	Scanner a=new Scanner(System.in);
	double b=a.nextDouble();
	sh=b;
	return b;
}
}