//���������
public class Highspeed implements Vehicle{
	public String name="����";//��ͨ��ʽ����
	public double gotime=1.5;//��վʱ��
	public double retime=1.5;//����ʱ��
	public double tickettime=0.5;//ȡƱʱ��
	public double securitytime=0.01;//����ʱ��
	public double waittime=0.01;//��ʱ��
	public double speed=250;//�ٶ�
	public double unitprice=0.45;//����
	public double distance=0;//����
	//public double takingtime=distance/speed;
	public double time=0;//�ܺ�ʱ
	public double price=0;//�ܼ۸�
	public void consume() {
		time=gotime+retime+securitytime+waittime+tickettime+distance/speed;
		price=distance*unitprice;
	};//���ĵ�ʱ��ͼ۸�
	public void show() {
		System.out.println("��ͨ��ʽ��"+name+" ��ʱ��"+time+"h"+" �۸�"+price+"Ԫ");
	};//�������
}
