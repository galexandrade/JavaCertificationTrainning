package com.acme.testing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

import com.acme.utils.MyDate;

public class TestCollections {
	public static void main(String[] args){
		ArrayList list = new ArrayList(4);
		System.out.println(list.size());
		list.add("Hello");
		list.add(new MyDate(11,11,1918));
		list.add("Hello");
		list.add("Hello");
		list.add("Hello");
		System.out.println(list);
		
		//Only the last one
		list.remove("Hello");
		System.out.println(list);		

		System.out.println(list.contains("Hello"));

		list.clear();
		System.out.println(list);
		
		
		/*-----------------------------------------*/
		ArrayList languages = new ArrayList();
		languages.add("Java");
		languages.add("Swift");
		languages.add("JavaScript");
		
		languages.remove(0);
		
		//Run time error
		//languages.set(3, "Angular");
		
		Iterator i = languages.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		//Only for list (ArrayList, LinkedList)
		ListIterator i2 = languages.listIterator();
		//i2.previous();
		
		/* ArrayList are SLOWER to add or remove elements on the middle
		 * LinkedList are FASTER to add or remove elements on the middle
		 * */
		
		/*------------------------------------*/
		/*SET
		 * No duplicate objects are allowed (use equals)
		 * */
		
		HashSet salesRegion = new HashSet();
		salesRegion.add("Minnesota");
		salesRegion.add("Wisconsin");
		salesRegion.add("Iowa");
		salesRegion.add("Minnesota"); //has no effect
		
		System.out.println(salesRegion);
		
		/*------------------------------------*/
		/*TREESET
		 * Orders the elements automaticaly, based on compareTo()
		 * not indexed
		 * */
		
		TreeSet tree = new TreeSet();
		tree.add(88);
		tree.add(12);
		tree.add(53);
		tree.add(66);
		
		System.out.println(tree);
		
		/*------------------------------------*/
		/*QUEUE
		 * Must initialize with a capacity (5)
		 * */
		ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
		queue.offer("Bruce Banner");
		queue.offer("Barry Allen");
		queue.offer("Bruce Wayne");
		//queue.offer(null); //Throws an exception
		queue.offer("B");
		queue.offer("C"); //Not fail, it returns false
		
		System.out.println(queue);
		
		String superHero = (String) queue.poll(); //Remove the first one on the head. Could also call remove()
		System.out.println(superHero);
		System.out.println(queue);
		
		String nextHero = (String) queue.peek(); //Returns the first one on the head. Could also call element()
		System.out.println(nextHero);
		System.out.println(queue);
		
		/*------------------------------------*/
		/*PRIORITYQUEUE
		 * Not needed to initialize with a capacity
		 * It's organized. Priorized alphabeticaly 
		 * */
		
		PriorityQueue pQueue = new PriorityQueue();
		pQueue.offer("Bruce Banner");
		pQueue.offer("Barry Allen");
		pQueue.offer("Bruce Wayne");
		//pQueue.offer(null); //Throws an exception
		pQueue.offer("B");
		pQueue.offer("C");
		
		System.out.println(pQueue);
		
		/*------------------------------------*/
		/*Deque
		 * Add and removes elements at both sides
		 * Cannot put null elements
		 */
		ArrayDeque deque = new ArrayDeque();
		deque.offer("Bruce Banner");
		deque.offer("Barry Allen");
		deque.offerFirst("Bruce Wayne");
		//deque.offer(null); //Throws an exception
		deque.offer("B");
		deque.offerFirst("C");
		deque.pollFirst();
		System.out.println(deque);
		
		/*------------------------------------*/
		/*Maps
		 * Objects keys instead of numeric keys
		 * No duplicate keys are allowed
		 * Duplicate values allowed
		 * */
		Map map = new HashMap();
		MyDate birthDay = new MyDate(1,20,1964);
		MyDate taxDay = new MyDate(2,20,1964);		
		map.put("birthday", birthDay);
		map.put("taxday", taxDay);
		System.out.println(map);
		
		System.out.println(map.get("birthday"));
		map.remove("birthday");
		System.out.println(map);
		
		MyDate d = (MyDate) map.get("taxday");
		System.out.println(map.containsKey("taxday"));
		System.out.println(map.containsValue(d));
		
		Set keys = map.keySet(); //Returns a Set of the keys. Set cannot be repeated, that's why it is a Set format
		System.out.println(keys);
		
		Collection c = map.values(); //Collections can have equals values
		System.out.println(c);
	}
}
