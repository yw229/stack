package LinkedIn;

import java.util.Stack;

public class Evaluation {
	public double eval(String[] expre)
	{
		Stack<Double> s = new Stack<Double>() ;
		
		for(int i = 0 ; i < expre.length ; i ++)
		{
			if(expre[i].matches("\\d"))  // digit number 
			{
				s.push(Double.parseDouble(expre[i])) ;
			}
			else
			{
				double result = 0 ;
				//double v1 = (double) s.pop() ;
				//double v2 = (double) s.pop() ;
				double v1 = s.pop() ;
				double v2 = s.pop() ;
				String chunk = expre[i] ;
				if(chunk == "+" )
				{
					result = v1 + v2 ;
				}else
					if(chunk == "-")
					{
						result = v2-v1 ;
					}
					else
						if(chunk == "*")
						{
							result = v1*v2;
						}
						else
							if(chunk == "/")
							{
								result = v2/v1 ;
							}
				
				s.push(result) ;
			}
				
		}
		return s.pop() ;
	}
	public static void main(String[] args)
	{
		String[] ex = {"4", "1", "+", "2", "*"};
		String[] ex1 = {"5", "8", "4", "/", "+"} ;
		Evaluation e = new Evaluation();
		e.eval(ex) ;
		System.out.println(e.eval(ex) +"and" + e.eval(ex1)) ;
	}

}
