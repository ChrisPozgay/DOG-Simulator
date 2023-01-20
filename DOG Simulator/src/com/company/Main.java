/*
* Program Name: Digital Operational Gateway Machine Language Simulator (DOG)
* Author: Christopher Pozgay
* Purpose: To allow a system running the Java Virtual Machine to perform calculations on a simulation of the DOG system
* Date Last Modified: 15MAR21
* Description: This simulator is comprised of 5 classes, each representing some aspect of a DOG system.
*              -CPU: The CPU.java file contains the class representing a DOG system processor. It can perform basic
*                    arithmetical calculations on data provided by the user, and store it within the simulated system's memory.
*              -Memory: The Memory.java file contains the class representing the DOG system RAM. It has the ability to store
*                       data within an array leaving space for one-hundred instructions and variables, as well as displaying a matrix
*                       containing a memory dump of each location within memory.
*              -IO: The IO.java file contains the class representing the methods for inputting and outputting information to and from
*                   the user. It is used to display the output from the CPU's calculations, and to allow for input of instructions and
*                   data from the user.
*              -Instructions: The Instructions.java file contains each integer used to compare user input with the desired instruction.
*                             It has no methods and acts more as a 'struct' than as a class.
*              -DOG: The DOG.java file contains the DOG class that acts as the DOG system as a whole. It is used for the construction of each
*                    class required for the operation of the simulator and runs the instructions input by the user on the CPU object. It
*                    serves the purpose of binding everything together, allowing for each object to interact.
* */


package com.company;

public class Main {

    public static void main(String[] args) {

        DOG dog1 = new DOG(); //Initializes a DOG Computer
        dog1.io.getInstructionsFromUser(); //Tells the DOG to get instructions from the user to store in memory
        dog1.runProgram();

        //I think this is the smallest 'main' I've ever had in a program that does more than just a few lines of code

    /* This is just for reference when testing the program and inputting instructions
    final public static int READ = 10;
    final public static int WRITE = 11;
    final public static int LOAD = 20;
    final public static int STORE = 21;
    final public static int ADD = 30;
    final public static int SUB = 31;
    final public static int DIV = 32;
    final public static int MUL = 33;
    final public static int BRANCH = 40;
    final public static int BRANCHNEG = 41;
    final public static int BRANCHZERO = 42;
    final public static int HALT = 43;
    */

    }
}
