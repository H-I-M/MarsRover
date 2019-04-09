package com.clyde.mars;

import java.util.Scanner;

import com.clyde.mars.logic.CalculateMoveSet;
import com.clyde.mars.validation.Validator;

public class MarsRover 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String dimen, start, cmd; 
		Validator valid = new Validator();
		boolean playOn = false, isValid = false;
		
		 System.out.println("Welcome to the Mars Rover X300 control system interface ...");
		 
		 System.out.println("Please enter the explored terrain co-ordinates (e.g 5 5).");
		 dimen = scan.nextLine().trim();
		 while(!valid.validateTerrainParameters(dimen))
		 {
			 System.out.println("INVALID FORMAT. Please enter the explored terrain co-ordinates in the correct format (e.g 5 5).");
			 dimen = scan.nextLine().trim();
		 }
		 
		 System.out.println();
		 System.out.println("Please enter the rover's starting location and orientation on the terrain provided above (e.g 12 S). ");
		 start = scan.nextLine().trim();
		 while(!valid.validateStartPoint(start))
		 {
			 System.out.println("INVALID FORMAT. Please enter the rover's starting location and orientation on the terain provided above in the correct format (e.g 12 S).");
			 start = scan.nextLine().trim();
		 }
		 while(valid.isOutOfBounds(start, dimen))
		 {
			 System.out.println("INVALID Position. The postion provided above would place the rover outside of the terrain safe zone, please enter a different starting location and orientation on the terrain above in the correct format (e.g 12 S).");
			 start = scan.nextLine().trim();
		 }
		 
		 do
		 {
			 System.out.println();
			 System.out.println("Please enter your desired movement commands for the rover (e.g MLR). ");
			 cmd  = scan.nextLine().trim();
			 while(!valid.validateCommand(cmd))
			 {
				 System.out.println("Please enter your desired movement commands for the rover in the correct format (e.g MLR). ");
				 cmd  = scan.nextLine().trim();
			 }
			 
			 CalculateMoveSet goRover = new CalculateMoveSet(dimen, start, cmd);
			 
			 System.out.println();
			 System.out.println(goRover.getCurrentLocation());
			 
			 System.out.println("Would you like to move the rover again on this terrain (y = new command set, n = end connection/set up new parameters) ?");
			 playOn = Boolean.valueOf(scan.nextLine().trim());
			 
		 }while(playOn);

	}

}
