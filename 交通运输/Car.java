//定义汽车类
public class Car implements Vehicle{
	public String name="汽车";
	public double gotime=0;
	public double retime=0;
	public double tickettime=0;
	public double securitytime=0;
	public double waittime=0;
	public double speed=80;//80公里/小时
	public double unitprice=0.32;//单价:元/公里
	public double distance=0;
	//public double takingtime=distance/speed;
	double time=0;
	double price=0;
	public void consume() {
		time=gotime+retime+securitytime+waittime+tickettime+distance/speed;
		price=distance*unitprice;
	};
	public void show() {
		System.out.println("交通方式："+name+" 耗时："+time+"h"+" 价格："+price+"元");
	};
}
