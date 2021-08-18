package com.melin.vip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sun.javafx.binding.StringFormatter;

public class Lottery {
	
	public List listA = null;
	public List listB = null;
	public Map<String, String> ballPoola = new TreeMap<String, String>();
	public Map<String, String> ballPoolb = new TreeMap<String, String>();
	public Lottery() {
		listA = new ArrayList<String>();
		listB = new ArrayList<String>();
		for(int i = 1; i <= 42; i++) {
			String balNumber = String.valueOf(i);
			listA.add(balNumber);
		}
		for(int i = 1; i <= 42; i++) {
			String balNumber = String.valueOf(i);
			listB.add(balNumber);
		}
		
		for(Iterator<String> itr = listA.iterator(); itr.hasNext();)
		{
			String bal = itr.next();
			String k = String.valueOf(trandom());
			//System.out.println(k);
			ballPoola.put(k, bal);
		}
		for(Iterator<String> itr = listB.iterator(); itr.hasNext();)
		{
			String bal = itr.next();
			ballPoolb.put(String.valueOf(trandom()), bal);
		}
		
		
		String[] anumber = new String[6];
		List<String> ballPoolLista = new ArrayList<String>();
		List<String> ballPoolListb = new ArrayList<String>();
		ballPoolLista.addAll(ballPoola.values());
		ballPoolListb.addAll(ballPoolb.values());
		int c = 0;
		System.out.println("A區選號");
		System.out.println("--");
		List sortList = new ArrayList();
		while(!ballPoolLista.isEmpty() && c <= 5) {
			randomSleep();
			int size = ballPoolLista.size();
			int idx = (int)(Math.random()* (size-1));
			//System.out.println("size is " + size);
			//System.out.println("idx = " + idx);
			//System.out.println(StringFormatter.format("List size is %d, and index is %d",size, idx));
			String v = String.format("%02d", Integer.parseInt(ballPoolLista.get(idx)));
			System.out.println(v);
			sortList.add(v);
			ballPoolLista.remove(idx);
			
			c++;
		}
		Collections.sort(sortList);
		System.out.println("--");
		System.out.println("由低至高" + sortList);
		System.out.println("--");
		System.out.println("--");
		System.out.println("B區選號");
		System.out.println("--");
		int idx = (int)(Math.random()* (ballPoolListb.size()-1));
		System.out.println(String.format("%02d", Integer.parseInt(ballPoolListb.get(idx))));
		System.out.println("--");
		System.out.println("祝您中大獎");
		
	}
	
	public static int trandom() {
		int s1 = (int) (Math.random() * Math.random() * 1000);
		int s2 = (int) (Math.random()*1000 * Math.random()*999 * Math.random());
		int s3 = (int) (s1 * s2 );
		return s3;
		
	}
	
	public static void main(String[] args) {
		Lottery l = new Lottery();
	
	}
	
	public void randomSleep() {
		try {
			Thread.sleep((long)(Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
