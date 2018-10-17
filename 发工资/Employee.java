//定义员工类
import java.util.Scanner;
public class Employee extends People{
	int m=0;
	int sa=0;
	int bo=0;
int salary() {
	System.out.println("请输入员工基本工资：");
	Scanner a=new Scanner(System.in);
	int b=a.nextInt();
	sa=b;
	return b;
}
int bonus() {
	System.out.println("请输入当前月数：");
	Scanner c=new Scanner(System.in);
	int d=c.nextInt();
	m=d;
	if(d==month) {
		bo=200;
	return 200;
}
	else bo=0; return 0;
}
}