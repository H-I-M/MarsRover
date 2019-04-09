package com.clyde.mars.logic;

import java.util.ArrayList;
import java.util.List;

public class CalculateMoveSet 
{
	private String terrain;
	private String startPoint;
	private String command;
	private int[][] bounds;
	private char[] orders;
	private List currentSpot;

	public CalculateMoveSet()
	{
		
	}
	
	public CalculateMoveSet(String terrain, String startPoint, String command)
	{ 
		this.terrain = terrain;
		this.startPoint = startPoint;
		this.command = command;
		
		try
		{
			loadTerrain(this.terrain);
			currentSpot = loadCurrentPosition(this.startPoint);
			loadCommands(this.command);
			
			if(orders != null)
			{
				for(char c : orders)
				{
					if(c == 'M' || c == 'm')
						currentSpot = moveRover(currentSpot);
					else if((c == 'R' || c == 'L') || (c == 'r' || c == 'l'))
					{
						String tmp = rotateRover((String)currentSpot.get(2), c);
						currentSpot.add(2, tmp);
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getTerrain() 
	{
		return terrain;
	}
	
	public void setTerrain(String dimen) 
	{
		this.terrain = dimen;
		loadTerrain(terrain);
	}
	
	public String getstartPoint() 
	{
		return startPoint;
	}
	
	public void setstartPoint(String startP) 
	{
		this.startPoint = startP;
		currentSpot = loadCurrentPosition(startPoint);
	}
	
	public String getCurrentLocation()
	{
		if(currentSpot != null)
			return String.format("Rover is currently located at %1s , %2s facing %3s .", currentSpot.get(0), currentSpot.get(1), ((String)currentSpot.get(2)).toUpperCase());
		else
			return "";
	}
	
	public String getCommand() 
	{
		return command;
	}
	
	public void setCommand(String comm) 
	{
		this.command = comm;
		loadCommands(command);
	}
	
	private void loadTerrain(String terrain)
	{
		int x, y;
		String temp[] = terrain.split(" "); 
		x = Integer.valueOf(temp[0]);
		y = Integer.valueOf(temp[1]);
		
		bounds = new int[x][y];
	}
	
	public int[][] getTerrainBoundaries()
	{
		return bounds;
	}
	
	private List loadCurrentPosition(String start)
	{
		String direction;
		int x, y;
		String temp[], subTemp[];
		List tempArray;
		
		temp = start.split(" "); 
		subTemp = (temp[0]).split("");
		x = Integer.valueOf(subTemp[0]);
		y = Integer.valueOf(subTemp[1]);
		direction = temp[1];
		
		tempArray = new ArrayList();
		tempArray.add(x);
		tempArray.add(y);
		tempArray.add(direction);
		return tempArray;
	}
	
	private void loadCommands(String comm)
	{
		orders = comm.toCharArray();
	}
	
	public List moveRover(List currentLocation)
	{
		int temp = 0;
		
		if(currentLocation != null)
		{
			String orientation = (String) currentLocation.get(2); // current orientation of rover
			
			if(orientation.equalsIgnoreCase("N"))
			{
				temp = (int) currentLocation.get(1);
				temp = (++temp);
				currentLocation.set(1, temp);
				temp = 0;
			}
			else if(orientation.equalsIgnoreCase("S"))
			{
				temp = (int) currentLocation.get(1);
				temp = (--temp);
				currentLocation.set(1, temp);
				temp = 0;
			}
			else if(orientation.equalsIgnoreCase("E"))
			{
				temp = (int) currentLocation.get(0);
				temp = (++temp);
				currentLocation.set(0, temp);
				temp = 0;
			}
			else if(orientation.equalsIgnoreCase("W"))
			{
				temp = (int) currentLocation.get(0);
				temp = (--temp);
				currentLocation.set(0, temp);
				temp = 0;
			}
		}
		
		return currentLocation;
	}
	
	public String rotateRover(String current, char rotate)
	{
		if(current.equalsIgnoreCase("N"))
			return rotate == 'L' ? "W" : "E";
		else if(current.equalsIgnoreCase("S"))
			return rotate == 'L' ? "E" : "W";
		else if(current.equalsIgnoreCase("E"))
			return rotate == 'L' ? "N" : "S";
		else if(current.equalsIgnoreCase("W"))
			return rotate == 'L' ? "S" : "N";
		
		return current;
	}

}
