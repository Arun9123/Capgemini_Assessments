package Advanced_Java.Multithreading;

class A
{
 synchronized void methodA(B b)
 {
  System.out.println("Thread 1 holding A");
  try
  {
   Thread.sleep(1000);
  }
  catch(Exception e){}
  System.out.println("Thread 1 holding B");
  b.last();
 }
 
 public void last()
 {
  System.out.println("In A last()");
 }
 
}

class B
{
 synchronized void methodB(A a)
 {
  System.out.println("Thread 2 holding B");
  try
  {
   Thread.sleep(1000);
  }
  catch(Exception e){}
  System.out.println("Thread 2 waiting for A");
  a.last();
 }
 
 public void last()
 {
  System.out.println("In B last()");
 }
 
}

public class DeadlockPrevention {

 public static void main(String[] args) {
A a=new A();
  B b=new B();
  Thread t1=new Thread()
  {
   public void run()
   {
    a.methodA(b);
   }
  };
  Thread t2=new Thread()
  {
   public void run()
   {
    b.methodB(a);
   }
  };
  
  t1.start();
  t2.start();
  
 }

}