import java.util.Scanner;

//����ɶ���
public class Shareholder extends People{
	double sh=0;
double share() {
	System.out.println("������ɶ��ɷݣ�");
	Scanner a=new Scanner(System.in);
	double b=a.nextDouble();
	sh=b;
	return b;
}
}