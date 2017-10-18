package com.bridgelabz.objectorientedprograms.utility;

public class test {
	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<>();
		list.add(12);
		list.add(25);
		list.add(15);
		System.out.println(list.size());
		list.remove(15);
		System.out.println(list.size());
	}
}
