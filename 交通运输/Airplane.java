//定义飞机类
public class Airplane implements Vehicle{
	public String name="飞机";//交通方式名称
	public double gotime=3;//到站时间
	public double retime=3;//返回时间
	public double tickettime=0.2;//取票时间
	public double securitytime=0.02;//安检时间
	public double waittime=0.02;//候车时间
	public double speed=900;//速度
	public double unitprice=0.75;//单价
	public double distance=0;//距离
	//public double takingtime=distance/speed;
	public double time=0;//总耗时
	public double price=0;//总价格
	public void consume() {
		time=gotime+retime+securitytime+waittime+tickettime+distance/speed;;
		price=distance*unitprice;
	};//消耗的时间和价格
	public void show() {
		System.out.println("交通方式："+name+" 耗时："+time+"h"+" 价格："+price+"元");
	};//输出方法
}
