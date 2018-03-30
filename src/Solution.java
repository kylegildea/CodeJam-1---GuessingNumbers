import java.util.*;
import java.io.*;
public class Solution {
  static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static void main(String[] args) {
    
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    String response = null;
    for (int i = 1; i <= t; ++i) 
    {
      int a = in.nextInt();//lower bound
      int b = in.nextInt();//upper bound
      int n = in.nextInt();//number of guesses
      
      response = guessCase(a,b,n);
      if(response.equalsIgnoreCase("WRONG_ANSWER"))
      {
    	  break;
      }
      
    }
    
    System.exit(0);
  }

	private static String guessCase(int lowerBound, int upperBound, int n) 
	{
		int middle = getMiddle(lowerBound,upperBound);
		int guess = middle;
		boolean keepGuessing = true;
		String response = null;
		int runs = n;
		
		while(keepGuessing)
		{			
			response = submitGuess(guess);
			switch(response)
			{
			case "TOO_SMALL":
				if(lowerBound == upperBound - 1)
				{
					guess = upperBound;
				}
				else 
				{
					lowerBound = guess;
					guess = getMiddle(lowerBound, upperBound);
				}
				break;
			case "TOO_BIG":
				upperBound = guess;
				guess = getMiddle(lowerBound, upperBound);
				break;
			case "WRONG_ANSWER":
				keepGuessing = false;
				break;
			case "CORRECT":
				keepGuessing = false;
				break;
			default:
				break;
			}
			runs--;
			if(runs < 1)
			{
				break;
			}
		}
		return response;
	}

	private static String submitGuess(int guess) 
	{
		System.out.println(guess);
		System.out.flush();
		String response = in.next();
			
		return response;
	}
	

	private static int getMiddle(int lowerBound, int upperBound)
	{
		return (upperBound + lowerBound) / 2;
	}
}