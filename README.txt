***Mars Rover Challenge***


**Context:

Rovers have been sent to Mars to survey the terrain and you have been charged with creating
their navigation system. The specifications of the challenge are listed below.

Mars’s surface can be thought of as a zone that is itself a two-dimensional grid of square areas.
The zones have been very carefully surveyed ahead of time and are deemed safe for
exploration within the landing terrain bounds, as represented by a single cartesian coordinate - for example: (5, 5).

1. The rover understands the cardinal points and can face either East (E), West (W), North(N) or South (S) at any given time.
2. The rover understands three commands:
  - M - Move one space forward in the direction it is facing
  - R - rotate 90 degrees to the right
  - L - rotate 90 degrees to the left
3. Due to the transmission delay in communicating with the rover on Mars, you are only able to send the rover a single list of commands.
4. These commands will be executed by the rover and its resulting location sent back to HQ. This is an example of the list of commands sent to the rover:

8 10
12 E
MMLMRMMRRMML

5. This is how the rover will interpret the above commands:
  - The first line describes how big the current zone is. This zone’s boundary is at
	the Cartesian coordinate of 8,10 and the zone comprises 80 blocks.
  - The second line describes the rover’s starting location and orientation.
  - This rover would start at position 1 on the horizontal axis, position 2 on the vertical axis and would be facing East (E). The third line is the list of commands (movements and rotations) to be executed by the rover.
  - As a result of following these commands, a rover starting at 1 2 E in this zone
  would land up at 3 3 S .
  
  
**Design:

1. I did not over complicate the code, tried to keep it intuitive and to the point.
2. Followed a very simple MVC-like pattern by sepparating the view/ui, logic and validation classes. 
3. Use of Regex expressions for input validation.
4. Used JUnit testing framework for testing purposes.


**Testing:

1. Used JUnit testing framework for testing purposes, test cases are targeted towards user input and movement logic.

**Known bugs

1. Movement isnt always within boundaries
2. Validity of movement commands against the terrains boundaries.


** Running/ Deploying the app

1. have the latest version of Java installed 
2. Ensure 'JAVA_HOME' is set up in enviroment variables
3. Download/pull the project into your IDE.
4. Clean and build project (just encase)
5. Run the project (this is a terminal interface application).


*** Thank you for your time and consideration .

