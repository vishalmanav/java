package com.bold.learnjava;

import java.util.HashMap;

public class CountOfCharactersInString {

	public static void main(String[] args) {

		countOfCharacter("Java J2EE Java JSP J2EE");
		
	}

	
	public static void countOfCharacter(String inputString)
	{
		
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		
		char[] chararray = inputString.toCharArray();
		
		for(char carray : chararray)
		{
			if(charCountMap.containsKey(carray))
			{
				charCountMap.put(carray, charCountMap.get(carray)+1);
			}else
			{
				charCountMap.put(carray, 1);
			}
			
			
			
		}
		System.out.println(charCountMap);
		
	}
	
	
	
	
}
