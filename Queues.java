package Questions3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queues<Item> implements Iterable<Item> {
	private Node first ; 
	private Node last ;
	private int N ;
	
	private class Node
	{
		private Item item ;
		private Node next ;
	}
	public Queues()
	{
		N = 0 ;
		this.first = null ;
		this.last = null ;
	}
	public boolean isEmpty ()
	{
		return first == null ;
	}
	
	public void makeQueue (Item item)
	{
		//if (isEmpty()) 
			//first = last ; //first.item = item ;
		Node oldlast = last ;
		last = new Node ();
		last.item =item ;
		last.next = null ;
		if (isEmpty ())
			{
			first = last ;
			assert check () ;
			}
		
		else
			oldlast.next = last ;
		N++ ;
	}
	public Item deQueque ()
	{
		if (isEmpty()) 
			throw new RuntimeException("Stack overflow") ;
			Item it = first.item ;
			first = first.next ;
			N -- ;	
			if ( isEmpty()) last = null ;
			assert check();
			return it;
		
	}
	
	 private boolean check() {
	        if (N == 0) {
	            if (first != null) return false;
	            if (last  != null) return false;
	        }
	        else if (N == 1) {
	            if (first == null || last == null) return false;
	            if (first != last)                 return false;
	            if (first.next != null)            return false;
	        }
	        else {
	            if (first == last)      return false;
	            if (first.next == null) return false;
	            if (last.next  != null) return false;

	            // check internal consistency of instance variable N
	            int numberOfNodes = 0;
	            for (Node x = first; x != null; x = x.next) {
	               numberOfNodes++;
	            }
	            if (numberOfNodes != N) return false;

	            // check internal consistency of instance variable last
	            Node lastNode = first;
	            while (lastNode.next != null) {
	               lastNode = lastNode.next;
	            }
	            if (last != lastNode) return false;
	        }

	        return true;
	    } 
	 


	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		 return new ListIterator();  
	}
	private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
	}
}


	
	
