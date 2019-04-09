package com.clyde.mars.validation;

import java.util.List;
import java.util.regex.Pattern;

public class Validator 
{
	private static Pattern pat;
	
	public Validator()
	{
	}
	
	public boolean validateTerrainParameters(String param)
	{
		if(param != null)
		{
			pat = Pattern.compile("^(\\d)(\\s+)(\\d)$");
			
			if(pat.matcher(param).matches())
				return true;
		}
		return false;
	}
	
	public boolean validateStartPoint(String start)
	{
		if(start != null)
		{
			pat = Pattern.compile("^([0-9]){2}(\\s+)([nsewNSEW]){1}$");
			
			if(pat.matcher(start).matches())
				return true;
		}
		return false;
	}
	
	public boolean validateCommand(String comm)
	{
		if(comm != null)
		{
			pat = Pattern.compile("^([mlrMLR]+)");
			
			if(pat.matcher(comm).matches())
				return true;
		}
		return false;
	}
	
	public boolean isOutOfBounds(String start, String bounds)
	{
		String direction;
		int a, b;
		int x, y;
		String temp[], subTemp[];
		List tempArray;
		
		// how big is the area
		temp = bounds.split(" "); 
		a = Integer.valueOf(temp[0]); //  a = X = length
		b = Integer.valueOf(temp[1]); // b = Y = hight
		
		//where is the rover in regards to the area
		temp = start.split(" "); 
		subTemp = (temp[0]).split("");
		x = Integer.valueOf(subTemp[0]); // x position
		y = Integer.valueOf(subTemp[1]); // y position
		
		if(x > a || y > b)
			return true;
		
		return false;
	}

}
