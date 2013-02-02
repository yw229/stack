package Thread;

import java.util.ArrayList;

public class SuffixTree
{
    //public String s ;
    SuffixNode root = new  SuffixNode();

    public SuffixTree(String s)
    {
       
         //SuffixNode root = new  SuffixNode();
        for(int i = 0 ; i < s.length() ; i ++)
        {
        	String suffix = s.substring(i) ;
           root.insertIntoNode(suffix,i) ;
        }
    }
    public ArrayList<Integer> getIndex(String s)
    {
    	return root.getIndex(s) ;
    }
    public static void main(String[] args)
    {
    	String list = "mississippi" ;
    	String[] tlist = {"is", "sip", "hi", "sis"};
    	SuffixTree t = new SuffixTree(list) ;
    	for(String s : tlist)
    	{
    		ArrayList<Integer> index = t.getIndex(s) ;
    		if(index!=null)
    		{
    			System.out.println(" " + index.toString()) ;
    		}
    	}
    }
}