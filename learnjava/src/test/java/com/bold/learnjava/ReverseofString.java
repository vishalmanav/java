package com.bold.learnjava;

public class ReverseofString {

	public static void main(String[] args) {

		ReverseofString rs = new ReverseofString();
		
		String reverseName = rs.string_reverse("vishal manav singh");
		System.err.println(reverseName);
		 
	}
	
	
	
	public String string_reverse(String value_to_reversed)
	{
		String[] strarray = value_to_reversed.split(" ");
		String newReverse = "";
		
		for(String single_word : strarray)
		{
			//char[] stra = single_word.toCharArray() ;
			for (int i = single_word.length()-1; i>=0 ; i--)
			{
				
				char c = single_word.charAt(i);
				newReverse = newReverse+c;
				
			}
			
				 newReverse = newReverse+" ";
		}
		
		return newReverse;	
		
	}
	
	
	}
