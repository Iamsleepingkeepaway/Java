//定义父类people
import java.util.Scanner;
public class People {
String name;
double reward;
void inputname() {
	System.out.println("请输入姓名：");
	Scanner n=new Scanner(System.in);
	String na=n.next();
	name=na;
}
int year;
int month;
int day;
void inputbirthday() {
	System.out.println("请输入生日年份：");
	Scanner a=new Scanner(System.in);
	int y=a.nextInt();
	System.out.println("请输入生日月份：");
	Scanner b=new Scanner(System.in);
	int m=a.nextInt();
	System.out.println("请输入生日日期：");
	Scanner c=new Scanner(System.in);
	int d=a.nextInt();
	year=y;
	month=m;
	day=d;
}
}