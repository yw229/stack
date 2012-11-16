package Questions3;

import java.util.Stack;

public class Tower {
	private Stack<Integer> disks ;
	private int index ;
	
	public Tower (int i)
	{
		disks = new Stack<Integer>() ;
		this.index = i ;
	}
	public int getIndex ()
	{
		return index ;
	}
	public void add (int d)
	{
		if (disks.isEmpty() || disks.peek() > d) {
			//
			disks.push(d);
		} else {
			System.out.println("Error placing disk " + d);
		}
	}
	public void moveToTop (Tower t)
	{
		int top = disks.pop() ;
		t.add(top) ;
		System.out.println("Move disk" + top + "from tower"+ getIndex()+ " to the disk" + t.getIndex()) ;
	}
	public void print ()
	{
		System.out.println("Contents of tower" + getIndex()) ;
		for (int i= disks.size()-1 ; i >=0; i--)
		{
			System.out.println(" " + disks.get(i)) ;
		}
	}
	public void moveDisks (int n , Tower Buffer, Tower Des)
	{
		if (n > 0)
		{
			moveDisks(n-1,Des, Buffer);
			moveToTop(Des);
			Buffer.moveDisks(n-1, this, Des) ;
		}
	}
}
