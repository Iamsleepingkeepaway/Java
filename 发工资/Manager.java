//定义经理类
import java.util.Scanner;
public class Manager extends People{
	int m=0;
	double sa=0;
	double bo=0;
	double salary() {
		System.out.println("请输入经理基本工资：");
		Scanner a=new Scanner(System.in);
		double b=a.nextDouble();
		sa=b;
		return b;
	}
	double bonus() {
		System.out.println("请输入经理所在部门本月营业额：");
		Scanner a=new Scanner(System.in);
		double b=a.nextDouble();
		System.out.println("请输入当前月数：");
		Scanner c=new Scanner(System.in);
		int d=c.nextInt();
		m=d;
		if(d==month) {
			bo=500+b*0.001;
		return (500+b*0.001);
	}
		else bo=b*0.01; return (b*0.01);
	}
}