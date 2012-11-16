package Questions3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Questions2.LinkedListNode;



public class StackConstr<Item> implements Iterable<Item> {
	private int N ;
	private Node top ;

	private class Node {
		private Item item ;
		private Node  next ;
	}
	
	public StackConstr()
	{
		this.top = null ;
		N = 0 ;
		
	}
	public boolean isEmpty ()
	{
		return top == null  ;		
	}
	
	public Item pop()
	{
		if( top !=null )
		{
			Item it = top.item ;
			top = top.next ;
			N -- ;
			
			return it ;
		}
		return null ;
		
	}
	
	public void push (Item it)
	{
		Node oldtop = top;
		top = new Node();
		top.item = it ;
		top.next = oldtop ;
		N ++ ;
		
	}
	public int size()
	{
		return N ;
	}
	public Item peek ()
	{
		if (isEmpty()) throw new RuntimeException("Stack overflow") ;
		return top.item ;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for (Item it : this)
		{
			sb.append(it + " ") ;
		}
		return sb.toString() ;
	}
	
	private boolean check ()
	{
		if (N == 0)
		{
			if (top != null) return false ;
		}
		else 
			if (N ==1)
			{
				if ( top ==null ) return false ;
				if ( top.next != null) return false; 
			}
			else
				if ( top.next == null) return false;
		return true ;
	}
	@Override
	public Iterator<Item> iterator() {
		//TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements  Iterator <Item>
	{
		private Node current = top ;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current !=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException(); 
			Item item = current.item ;
			current = current.next ;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
			throw new UnsupportedOperationException();
		}
		
	}
	
	 public static void main(String[] args) {
	        StackConstr<String> s = new StackConstr<String>();
	        while (!StdIn.isEmpty()) {
	            String item = StdIn.readString();
	            if (!item.equals("-")) s.push(item);
	            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
	        }
	        StdOut.println("(" + s.size() + " left on stack)");
	    }

}
