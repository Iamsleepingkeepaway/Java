//����ɻ���
public class Airplane implements Vehicle{
	public String name="�ɻ�";//��ͨ��ʽ����
	public double gotime=3;//��վʱ��
	public double retime=3;//����ʱ��
	public double tickettime=0.2;//ȡƱʱ��
	public double securitytime=0.02;//����ʱ��
	public double waittime=0.02;//��ʱ��
	public double speed=900;//�ٶ�
	public double unitprice=0.75;//����
	public double distance=0;//����
	//public double takingtime=distance/speed;
	public double time=0;//�ܺ�ʱ
	public double price=0;//�ܼ۸�
	public void consume() {
		time=gotime+retime+securitytime+waittime+tickettime+distance/speed;;
		price=distance*unitprice;
	};//���ĵ�ʱ��ͼ۸�
	public void show() {
		System.out.println("��ͨ��ʽ��"+name+" ��ʱ��"+time+"h"+" �۸�"+price+"Ԫ");
	};//�������
}
