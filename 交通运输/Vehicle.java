//定义接口
interface Vehicle {
	public String name="";//交通方式名称
	public double gotime=0;//到站时间
	public double retime=0;//返回时间
	public double tickettime=0;//取票时间
	public double securitytime=0;//安检时间
	public double waittime=0;//候车时间
	public double speed=0;//速度
	public double unitprice=0;//单价
	public double distance=0;//距离
	//public double takingtime=distance/speed;//交通耗时
	public double time=0;//总耗时
	public double price=0;//总价格
	public void consume();//消耗的时间和价格
	public void show();//输出方法
}
