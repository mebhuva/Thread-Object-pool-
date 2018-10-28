# CSX42: Assignment 3
## Name: Mehul Bhuva

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in IsPrimeThreadPool/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile IsPrimeThreadPool/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile IsPrimeThreadPool/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile IsPrimeThreadPool/src/build.xml run -Darg0=input.txt -Darg1=NUM_THREADS -Darg2=DEBUG_LEVEL

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

Flow of the project:-

1. Driver class have main method which is the entry point accepts three arguments input file , number of threads and debug value
2. All the argument validated after that we create object of class fileprocessor, isprime and result
3. Then we pass this object to the create worker class which create instance of thread pool , sets thread pool to number of threads using workerprocessor function of create thread
4. Then worker thread start and join thread
5. Worker threads calculates prime number and store it in the result
6. Result object return to the driver code
7. driver displays result using retrun reult object and call writeconsole 




Data Structure: -

Thread List created using ArrayList<Thread>
Result List created using ArrayList<Integer>
Thread implemented using Runnable Interface


Time complexity :- O(n logn) 

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 10/28/2018


