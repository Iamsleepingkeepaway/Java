//定义控制类
import java.util.Scanner;
public class Control{
	public static void main(String args[]) {
		Car c=new Car();
		Airplane a=new Airplane();
		Highspeed h=new Highspeed();
		System.out.println("请输入出发地：");
		Scanner n1=new Scanner(System.in);
		String m1=n1.next();
		System.out.println("请输入目的地：");
		Scanner n2=new Scanner(System.in);
		String m2=n2.next();
		System.out.println("请输入距离：（公里）");
		Scanner n3=new Scanner(System.in);
		double distance=n3.nextDouble();
		c.distance=distance;
		a.distance=distance;
		h.distance=distance;
		System.out.println("出发地："+m1+" 目的地："+m2+" 距离:"+distance+"公里");
		c.consume();
		c.show();
		a.consume();
		a.show();
		h.consume();
		h.show();
	}
}
