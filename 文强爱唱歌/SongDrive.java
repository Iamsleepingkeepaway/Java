//�����������
import java.util.Scanner;
import java.util.Iterator;
public class SongDrive {
	static User s;
	static Host l ;
	public static void main(String args[]) {
		SongDrive a=new SongDrive();
		System.out.println("����밴��0���˳�����밴��1");
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		while(n==0){
			s.Adding();
			l.list.add(s);
			System.out.println("����밴��0���˳�����밴��1");
			n=in.nextInt();
		}
		Iterator<User> iterator = l.list.iterator();
		while (iterator.hasNext()) {
            User str = iterator.next();
            System.out.println(str.s.name);
        }
	}
	SongDrive(){s=new User() ;l=new Host();}
}
