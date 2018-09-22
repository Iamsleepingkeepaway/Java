import java.util.Scanner;
//定义一个汽车类
public class Car{

//汽车的三个属性:型号，油箱容量，油耗
String name;
double tank;
double oilConsumption;

//有参数构造函数
Car(String n,double t,double o){
name=n;
tank=t;
oilConsumption=o;
}
//无参构造函数，赋初值
Car(){
name="路虎";
tank=60;
oilConsumption=8.33;
}

public void gas(){}//加油
public void run(){}//跑
public void display(){System.out.println("汽车型号:"+name+" 油箱容量/L:"+tank+" 油耗/L:"+oilConsumption);}
//主函数
public static void main(String args[]){
//从键盘键入数据函数
Scanner	in=new Scanner(System.in);
System.out.println("请输入汽车数量:");
int n;
n=in.nextInt();
Car[] arr=new Car[n];
System.out.println("请输入汽车的属性：型号 油箱容量/L 油耗/L");
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
