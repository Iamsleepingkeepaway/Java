//���������
import java.util.Scanner;
public class Control{
	public static void main(String args[]) {
		Car c=new Car();
		Airplane a=new Airplane();
		Highspeed h=new Highspeed();
		System.out.println("����������أ�");
		Scanner n1=new Scanner(System.in);
		String m1=n1.next();
		System.out.println("������Ŀ�ĵأ�");
		Scanner n2=new Scanner(System.in);
		String m2=n2.next();
		System.out.println("��������룺�����");
		Scanner n3=new Scanner(System.in);
		double distance=n3.nextDouble();
		c.distance=distance;
		a.distance=distance;
		h.distance=distance;
		System.out.println("�����أ�"+m1+" Ŀ�ĵأ�"+m2+" ����:"+distance+"����");
		c.consume();
		c.show();
		a.consume();
		a.show();
		h.consume();
		h.show();
	}
}
