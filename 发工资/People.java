//���常��people
import java.util.Scanner;
public class People {
String name;
double reward;
void inputname() {
	System.out.println("������������");
	Scanner n=new Scanner(System.in);
	String na=n.next();
	name=na;
}
int year;
int month;
int day;
void inputbirthday() {
	System.out.println("������������ݣ�");
	Scanner a=new Scanner(System.in);
	int y=a.nextInt();
	System.out.println("�����������·ݣ�");
	Scanner b=new Scanner(System.in);
	int m=a.nextInt();
	System.out.println("�������������ڣ�");
	Scanner c=new Scanner(System.in);
	int d=a.nextInt();
	year=y;
	month=m;
	day=d;
}
}