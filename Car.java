import java.util.Scanner;
//����һ��������
public class Car{

//��������������:�ͺţ������������ͺ�
String name;
double tank;
double oilConsumption;

//�в������캯��
Car(String n,double t,double o){
name=n;
tank=t;
oilConsumption=o;
}
//�޲ι��캯��������ֵ
Car(){
name="·��";
tank=60;
oilConsumption=8.33;
}

public void gas(){}//����
public void run(){}//��
public void display(){System.out.println("�����ͺ�:"+name+" ��������/L:"+tank+" �ͺ�/L:"+oilConsumption);}
//������
public static void main(String args[]){
//�Ӽ��̼������ݺ���
Scanner	in=new Scanner(System.in);
System.out.println("��������������:");
int n;
n=in.nextInt();
Car[] arr=new Car[n];
System.out.println("���������������ԣ��ͺ� ��������/L �ͺ�/L");
for(int i=0;i<n;i++){
String a=in.next();
double b=in.nextDouble();
double c=in.nextDouble();
arr[i]=new Car(a,b,c);
}
for(int i=0;i<n;i++){
arr[i].display();
}
}
}
