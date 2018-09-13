public class Test1{
public static void main(String args[]){
int i=99;
for(;i<100&&i>2;i--){
System.out.println(i+" bottles of beer on the wall,"+i+" bottles of beer.");
System.out.println("Take one down.");
System.out.println("Pass it around.");
System.out.println((i-1)+" bottles of beer on the wall.");
}
if(i==2){
System.out.println(i+" bottles of beer on the wall,"+i+" bottles of beer.");
System.out.println("Take one down.");
System.out.println("Pass it around.");
System.out.println((i-1)+" bottle of beer on the wall.");
i--;
}
if(i==1){
System.out.println(i+" bottle of beer on the wall,"+i+" bottle of beer.");
System.out.println("Take one down.");
System.out.println("Pass it around.");
System.out.println("No bottle of beer on the wall.");
}
}
}