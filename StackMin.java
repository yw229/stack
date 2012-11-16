package Questions3;

import java.util.Random;
import java.util.Stack;

public class StackMin extends Stack<Integer> {
	 public Stack<Integer> s ;  // using additional track
	    public StackMin()
	    {
	        s = new Stack<Integer>() ;
	    }
	    public void push(int value)
	    {
	       if( value <=min())
	           s.push(value) ;
	       else
	           super.push(value) ;
	    }
	    public int min()
	    {
	        if( s.isEmpty())
	            return Integer.MAX_VALUE ;
	        else
	            return s.peek() ;
	    }
	    public Integer pop()
	    {
	        Integer value =  super.pop() ;
	        if( value == min())
	            s.pop();
	        return value ;
	    }
	    public static void main (String[] args)
	    {
	    	StackMin sm = new StackMin() ;
	    	int n = 10 ;
			int array[] = new int[n] ;
			Random ran = new Random();
			
			for (int i = 0 ; i < array.length ; i ++)
			{
				array[i] = ran.nextInt(n) ;
				System.out.print(" " + array[i]) ;
				sm.push(array[i]) ;
			}
			System.out.println() ;
			//while(!sm.isEmpty())
				System.out.println(" " + sm.min()) ;
			
	    }

}
