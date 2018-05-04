/**
 * synchronized关键字
 * 锁对象。synchronized(this)和synchronized方法都是锁当前对象。
 */
package concurrent.t01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test_01 {
	private int count = 0;
	private Object o = new Object();
	
	public void testSync1(){
		synchronized(o){
			System.out.println(Thread.currentThread().getName() 
					+ " count = " + count++);
		}
	}
	
	public void testSync2(){
		synchronized(this){
			System.out.println(Thread.currentThread().getName() 
					+ " count = " + count++);
		}
	}
	
	public synchronized void testSync3(){
		System.out.println(Thread.currentThread().getName() 
				+ " count = " + count++);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		//通过打印的时间，可以看出锁定对象
		final Test_01 t = new Test_01();
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程1调用testSync3开始:"+df.format(new Date()));
				t.testSync3();
				System.out.println("线程1调用testSync3结束:"+df.format(new Date()));
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程2调用testSync3开始:"+df.format(new Date()));
				t.testSync3();
				System.out.println("线程2调用testSync3结束:"+df.format(new Date()));
			}
		}).start();
	}
	
}
