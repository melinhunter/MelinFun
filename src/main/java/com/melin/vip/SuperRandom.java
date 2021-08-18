package com.melin.vip;

public class SuperRandom {
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			int s = (int) (Math.random() * Math.random() * 1000);
			System.out.println(s);
		}
	}
}
