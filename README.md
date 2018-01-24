# Monty Hall Simulation

This application simulates the Monty Hall problem. 

The application is only tested and run under the following prerequisites
 - Java 1.8
 - Maven 3.5

There is a jarfile built and available at /distribution/monty-hall-1.0-SNAPSHOT.jar
Download the jar file at any location on your computer. 
Go to the command line and run the java -jar command: 

java -jar monty-hall-1.0-SNAPSHOT.jar

Follow the instructions on the command line. 
You will be prompted according to the information below:  

----------------------------------------------------------------
Welcome to the Monty Hall Simulation Application
1) Choose number of iterations for the simulator.
1) Choose the desired strategy: 
 K for Keeping the first choice
 S for Switching to the remaining box
 R for randomly choosing "keeping" or "switching"
 A for running all strategies.
-----------------------------------------------------------------


The result will show that when using the "Keep" game strategy, the number of wins will be 1/3 of the number of the number of iterations, and for the "Switch" strategy it will be 2/3. 

Note that in order to get a good statistical result, the number of iterations should be at least around 5000 iterations.