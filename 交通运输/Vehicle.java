//����ӿ�
interface Vehicle {
	public String name="";//��ͨ��ʽ����
	public double gotime=0;//��վʱ��
	public double retime=0;//����ʱ��
	public double tickettime=0;//ȡƱʱ��
	public double securitytime=0;//����ʱ��
	public double waittime=0;//��ʱ��
	public double speed=0;//�ٶ�
	public double unitprice=0;//����
	public double distance=0;//����
	//public double takingtime=distance/speed;//��ͨ��ʱ
	public double time=0;//�ܺ�ʱ
	public double price=0;//�ܼ۸�
	public void consume();//���ĵ�ʱ��ͼ۸�
	public void show();//�������
}
