package com.helloworld.threadlocaldemo;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		
		//	创建 ThreadLocal
		final ThreadLocal<Integer> th = new ThreadLocal<Integer>();
		
		//	向 ThreadLocal 中存放数据
		th.set(23);
		
		new Thread() {
			
			@Override
			public void run() {
				th.set(45);
				System.out.println("------------------------");
				System.out.println("thread=======" + th.get());
			}
		}.start();
		
		System.out.println("main======" + th.get());
		
	}
}
