package Thread;

import java.util.ArrayList;
import java.util.HashMap;

public class SuffixNode
{
    char data ;
    HashMap<Character,SuffixNode> children = new HashMap<Character,SuffixNode>() ;
    // hashmap to store first char as key and it's suffixNode as value, if current char's suffixnode exisits, get suffix child recursively to insert the substring 
    ArrayList<Integer> Index = new ArrayList<Integer>() ;
    
    public SuffixNode()
    {
        ;
    }
    public void insertIntoNode(String s , int i)
    {
        Index.add(i) ;  // add string
        if(s!=null && s.length()>0)
        {
            char first = s.charAt(0) ;
            SuffixNode child = null ;
            if(children.containsKey(first))
            {
                 child = children.get(first) ;
            }
            else
            {
                child = new SuffixNode() ;
                children.put(first,child ) ;
            }
            String remianer = s.substring(1);
            child.insertIntoNode(remianer,i) ;
        }
    }
    public ArrayList<Integer> getIndex(String s)
    {
        if(s.length()==0 || s==null) return Index ;
        char first = s.charAt(0) ;
        if(children.containsKey(first))
        {
            String remainder = s.substring(1) ;
            SuffixNode child = children.get(first) ;
            return child.getIndex(remainder) ;
        }
        return null ;
    }
    
}