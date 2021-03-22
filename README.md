# Visitor Application (CS2263 HW 4)

## Installation
This project should be installable simply by cloning the github repository and cd'ing into the header directory

## Running the program
There are three different methods of running this application, they will all be described.
### 1. Through IntelliJ
Import the Gradle project into Intellij. Run the primary file (which is Application) from the app/src/main/java/edu.isu.cs2263.Visitor directory.
### 2. Command line without command line arguments
Use the command 'gradle run' while in the Visitor directory. The system should compile and automatically run the primary file (Application)
### 3. Command line with command line arguments
This program allows for the user to specify a .json file to import and display the results for. If a user has this file, they can input it on the command line by using the following syntax:  
->gradle run --args fileName  
For example, you could execute the following two commands in series:  
->gradle run  
->gradle run --args savedNetwork  
Here, the program would load the json graph from the first command, and run the data analysis again  
