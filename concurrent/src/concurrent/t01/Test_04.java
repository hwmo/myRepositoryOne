/**
 * synchronized关键字
 * 同步方法 - 同步方法和非同步方法的调用
 * 同步方法只影响锁定同一个锁对象的同步方法。不影响其他线程调用非同步方法，或调用其他锁资源的同步方法。
 */
package concurrent.t01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_04 {
	Object o = new Object();
	DateFormat df = new SimpleDateFormat("yyyy0-MM-dd HH:mm:ss");
	public synchronized void m1(){ // 重量级的访问操作。
		System.out.println("public synchronized void m1() start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("public synchronized void m1() end");
	}
	
	public void m2(){
		System.out.println("public void m2() start");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("public void m2() end");
	}
	
	public void m3(){
		System.out.println("m3开始执行时间：" + df.format(new Date()));
		synchronized(o){
			//System.out.println("public void m3() start");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("public void m3() end");
		}
		System.out.println("m3执行结束时间：" + df.format(new Date()));
	}
	
	public void m4(){
		System.out.println("m4开始执行时间：" + df.format(new Date()));
		synchronized(o){
			//System.out.println("public void m4() start");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("public void m4() end");
		}
		System.out.println("m4执行结束时间：" + df.format(new Date()));
	}
	
	public static class MyThread01 implements Runnable{
		public MyThread01(int i, Test_04 t){
			this.i = i;
			this.t = t;
		}
		int i ;
		Test_04 t;
		public void run(){
			if(i == 1){
				t.m1();
			}else if (i == 2){
				t.m2();
			}else if (i == 3){
				t.m3();
			}else if (i == 4){
				t.m4();
			}
		}
	}
	
	public static void main(String[] args) {
		Test_04 t = new Test_04();
		//new Thread(new Test_04.MyThread01(1, t)).start();
		//new Thread(new Test_04.MyThread01(2, t)).start();
		new Thread(new Test_04.MyThread01(3, t)).start();
		new Thread(new Test_04.MyThread01(4, t)).start();
	}
	
}
