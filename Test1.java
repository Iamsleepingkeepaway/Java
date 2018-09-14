1.
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

2.
public class Arr{
public static void main(String args[]){
int a[]={1,2,3,4};
System.out.println(a[4]);
}
}

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
        at Arr.main(Arr.java:4)
  
3.
class test{
public static void main(String[] args){
String c="abc";
String a=c;
c="efg";
System.out.println(a);
}
}

abc
