//定义发工资类
import java.util.Scanner;
import java.util.ArrayList;
public class Salary {
	public static void main(String args[]) {
		Employee p=new Employee();
		ArrayList<Employee> list1=new ArrayList<>();//定义一个数组用来存放员工信息
		ArrayList<Manager> list2=new ArrayList<>();//经理
		ArrayList<Shareholder> list3=new ArrayList<>();//股东
		double sum1=0;
		double sum2=0;
		int sa1 = 0;
		for(;;) {
		System.out.println("请输入员工职务：1.普通员工 2.经理 3.股东 录入完成请按：4");
		Scanner a=new Scanner(System.in);
		int b=a.nextInt();
		if(b==1) {
			System.out.println("请输入员工人数：");
			Scanner t=new Scanner(System.in);
			int n=t.nextInt();
			int r=p.salary();
			sa1=r;
			System.out.println("员工信息录入开始：");
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
			System.out.println("请输入经理人数：");
			Scanner t=new Scanner(System.in);
			int n=t.nextInt();
			System.out.println("经理信息录入开始：");
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
			System.out.println("请输入股东人数：");
			Scanner t=new Scanner(System.in);
			int n=t.nextInt();
			System.out.println("请输入公司总营业额：");
			Scanner y=new Scanner(System.in);
			double r=y.nextDouble();
			System.out.println("股东信息录入开始：");
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
		System.out.println("信息录入完毕！");
		for(;;) {
		System.out.println("浏览信息功能请按：1  查询请按：2 退出请按：3");
		Scanner a=new Scanner(System.in);
		int b=a.nextInt();
		if(b==1) {
			for (int i = 0; i < list1.size(); i++) { 
				System.out.println("姓名："+list1.get(i).name+" 生日："+list1.get(i).year+" "+list1.get(i)
				.month+" "+list1.get(i).day+" "+" 工资："+list1.get(i).reward);
			}
			for(int i = 0; i < list2.size(); i++) {
				System.out.println("姓名："+list2.get(i).name+" 生日："+list2.get(i).year+" "+list2.get(i)
				.month+" "+list2.get(i).day+" "+" 工资："+list2.get(i).reward);
			}
			for(int i = 0; i < list3.size(); i++) {
				System.out.println("姓名："+list3.get(i).name+" 生日："+list3.get(i).year+" "+list3.get(i)
				.month+" "+list3.get(i).day+" "+" 工资："+list3.get(i).reward);
			}
		}
		if(b==2) {
			System.out.println("请输入要查询的员工的名字：");
			Scanner na=new Scanner(System.in);
			String n=na.next();
			for(int i=0;i<list1.size();i++) {
				if(n.equals(list1.get(i).name)) {
					System.out.println("职务：普通员工 "+list1.get(i).m+"月"+" 基本工资:"+sa1+
							" 奖金"+list1.get(i).bo);
				}
			}
			for(int i=0;i<list2.size();i++) {
				if(n.equals(list2.get(i).name)) {
					System.out.println("职务：经理 "+list2.get(i).m+"月"+" 基本工资:"+list2.get(i).sa+
							" 奖金"+list2.get(i).bo);
				}
			}
			for(int i=0;i<list3.size();i++) {
				if(n.equals(list3.get(i).name)) {
					System.out.println("职务：股东 "+" 年终分红："+list3.get(i).reward);
				}
			}
		}
		if(b==3)break;
}
}
}