//���巢������
import java.util.Scanner;
import java.util.ArrayList;
public class Salary {
	public static void main(String args[]) {
		Employee p=new Employee();
		ArrayList<Employee> list1=new ArrayList<>();//����һ�������������Ա����Ϣ
		ArrayList<Manager> list2=new ArrayList<>();//����
		ArrayList<Shareholder> list3=new ArrayList<>();//�ɶ�
		double sum1=0;
		double sum2=0;
		int sa1 = 0;
		for(;;) {
		System.out.println("������Ա��ְ��1.��ͨԱ�� 2.���� 3.�ɶ� ¼������밴��4");
		Scanner a=new Scanner(System.in);
		int b=a.nextInt();
		if(b==1) {
			System.out.println("������Ա��������");
			Scanner t=new Scanner(System.in);
			int n=t.nextInt();
			int r=p.salary();
			sa1=r;
			System.out.println("Ա����Ϣ¼�뿪ʼ��");
			for(int i=0,sum=0;i<n;i++) {
				Employee e=new Employee();
				e.inputname();
				e.inputbirthday();
				e.reward=r+e.bonus();
				list1.add(e);
				sum=sum+r;
				sum1=sum;
			}
		}
		if(b==2) {
			System.out.println("�����뾭��������");
			Scanner t=new Scanner(System.in);
			int n=t.nextInt();
			System.out.println("������Ϣ¼�뿪ʼ��");
			double sum=0;
			for(int i=0;i<n;i++) {
				Manager m=new Manager();
				m.inputname();
				m.inputbirthday();
				m.salary();
				m.bonus();
				m.reward=m.sa+m.bo;
				list2.add(m);
				sum=sum+m.reward;
				sum2=sum;
			}
		}
		if(b==3) {
			System.out.println("������ɶ�������");
			Scanner t=new Scanner(System.in);
			int n=t.nextInt();
			System.out.println("�����빫˾��Ӫҵ�");
			Scanner y=new Scanner(System.in);
			double r=y.nextDouble();
			System.out.println("�ɶ���Ϣ¼�뿪ʼ��");
			for(int i=0;i<n;i++) {
				Shareholder s=new Shareholder();
				s.inputname();
				s.inputbirthday();
				s.share();
				s.reward=(r-sum1-sum2)*s.sh;
				list3.add(s);
		}
	}
		if(b==4) {
			break;
		}
	}
		System.out.println("��Ϣ¼����ϣ�");
		for(;;) {
		System.out.println("�����Ϣ�����밴��1  ��ѯ�밴��2 �˳��밴��3");
		Scanner a=new Scanner(System.in);
		int b=a.nextInt();
		if(b==1) {
			for (int i = 0; i < list1.size(); i++) { 
				System.out.println("������"+list1.get(i).name+" ���գ�"+list1.get(i).year+" "+list1.get(i)
				.month+" "+list1.get(i).day+" "+" ���ʣ�"+list1.get(i).reward);
			}
			for(int i = 0; i < list2.size(); i++) {
				System.out.println("������"+list2.get(i).name+" ���գ�"+list2.get(i).year+" "+list2.get(i)
				.month+" "+list2.get(i).day+" "+" ���ʣ�"+list2.get(i).reward);
			}
			for(int i = 0; i < list3.size(); i++) {
				System.out.println("������"+list3.get(i).name+" ���գ�"+list3.get(i).year+" "+list3.get(i)
				.month+" "+list3.get(i).day+" "+" ���ʣ�"+list3.get(i).reward);
			}
		}
		if(b==2) {
			System.out.println("������Ҫ��ѯ��Ա�������֣�");
			Scanner na=new Scanner(System.in);
			String n=na.next();
			for(int i=0;i<list1.size();i++) {
				if(n.equals(list1.get(i).name)) {
					System.out.println("ְ����ͨԱ�� "+list1.get(i).m+"��"+" ��������:"+sa1+
							" ����"+list1.get(i).bo);
				}
			}
			for(int i=0;i<list2.size();i++) {
				if(n.equals(list2.get(i).name)) {
					System.out.println("ְ�񣺾��� "+list2.get(i).m+"��"+" ��������:"+list2.get(i).sa+
							" ����"+list2.get(i).bo);
				}
			}
			for(int i=0;i<list3.size();i++) {
				if(n.equals(list3.get(i).name)) {
					System.out.println("ְ�񣺹ɶ� "+" ���շֺ죺"+list3.get(i).reward);
				}
			}
		}
		if(b==3)break;
}
}
}