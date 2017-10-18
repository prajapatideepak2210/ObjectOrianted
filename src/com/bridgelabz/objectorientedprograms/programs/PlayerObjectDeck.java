package com.bridgelabz.objectorientedprograms.programs;

import java.util.LinkedList;

import com.bridgelabz.objectorientedprograms.utility.Queue;
import com.bridgelabz.objectorientedprograms.utility.Utility;

public class PlayerObjectDeck {
	public static void main(String[] args) {
		Utility utility=new Utility();
		String[] suits={"Clubs","Diamonds","Hearts","Spades"};
		String [] cards={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		String[] deck=utility.Deck(suits, cards);
		Queue<String> queue=new Queue<String>();
		int indexOfDeck=0;
		for(int i=0; i<4; i++)
		{
			LinkedList<String> linkList=new LinkedList<String>();
			for(int j=0; j<9; j++)
			{
				linkList.add(deck[indexOfDeck]);
				indexOfDeck++;
			}
			queue.enqueue(linkList);
		}
		
		queue.getelement();
	}
}
