Folder Hierarchy
-----------------
1)The src folder contains OOLE_HW_1 folder. It contains cut.java, which is the Class Under Test and TestHarness.java, which is the Test Harness. The TestHarness.java contains main method, which instantiates the class cut and invokes it's methods.
2)Inputs are read from input.txt file.It is present in the base folder OOLE_HW1. 
3)Results of the test cases are written in to output.txt, which is also present in base folder OOLE_HW1.

Giving Input
-------------
The main program in TestHarness.java expects the name of the class( in the format of PackageName.ClassName), which is under test in command line arguments. If you are using eclipse, please configure the the class name by following these steps
 1)In package explorer, Right click of TestHarness.java
 2)Click on properties
 3)Click on Run/Debug Settings
 4)double click on the class Test under "Launch Configurations for 'TestHarness.java'"
 5)Click on Arguments
 6)write 'OOLE_HW_1.cut' (without quotes) in Program Arguments. Here OOLE_HW_1 is package and cut is class name.
 7) Click on OK.
 
Compiling and Running the code
----------------------------------
Please unzip the folder and import project OOLE_HW1 in to eclipse.
Make sure that the folder structure mentioned in "Folder Hierarchy" is maintained
Give class name in commandline arguments
Compile cut.java and Test.java
Run Test.java

OutPut
---------
The TestHarness.java will write the report of test cases and its status in to output.txt
If the invoked method prints any message, it will shown in console.

Note : If the program is not compiling, 
         please check whether the package mentioned in java file is same the package which contains the .java file.
		 Please check whether the folder structure mentioned in maintained.
		 Please check whether arguments are passed in commandline correctly.

/*********************************************************************
Submitted By 
Pavan Kumar Kothagorla
**********************************************************************/


