//����������
public class Car implements Vehicle{
	public String name="����";
	public double gotime=0;
	public double retime=0;
	public double tickettime=0;
	public double securitytime=0;
	public double waittime=0;
	public double speed=80;//80����/Сʱ
	public double unitprice=0.32;//����:Ԫ/����
	public double distance=0;
	//public double takingtime=distance/speed;
	double time=0;
	double price=0;
	public void consume() {
		time=gotime+retime+securitytime+waittime+tickettime+distance/speed;
		price=distance*unitprice;
	};
	public void show() {
		System.out.println("��ͨ��ʽ��"+name+" ��ʱ��"+time+"h"+" �۸�"+price+"Ԫ");
	};
}
