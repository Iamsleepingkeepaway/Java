import java.util.Scanner;
//����һ���û���
public class User {
	User(){};
	Song s;
	public boolean Adding(){
		Scanner in=new Scanner(System.in);
		System.out.println("������������ƣ�");
		String a=in.next();
		System.out.println("���������ԭ�����֣�");
		String b=in.next();
		System.out.println("���������ʱ�䣺");
		double c=in.nextDouble();
		s=new Song(a,b,c);
		return true;
}
}