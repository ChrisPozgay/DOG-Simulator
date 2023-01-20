package com.company;

import java.util.Scanner;

public class IO {


    //This tells the class that the IO has a memory object it is writing to/reading from
    private Memory memory;

    //A scanner needed to take information from the user
    private Scanner sc;

    public IO() //The default constructor that initializes a scanner and initializes a new memory object
    {
         sc = new Scanner(System.in);
         memory = new Memory();
    }

    public IO(Memory pMemory) //Overloaded constructor that takes a memory object as a parameter so that it can
                              //    know what memory object to work with
    {
        sc = new Scanner(System.in);
        memory = pMemory;
    }

    public void getInstructionsFromUser() //Takes instruction sets from user and stores them in memory
    {
        int input = 0000; //empty integer that will be changed as input is read
        int ioCounter = 0; //represents the next point in the memory array that will hold an instruction
        while (input >= 0) //Until input is entered as a negative, continue to take input. This allows for multiple halts to be used
        {
            System.out.println("Please enter a 4-digit instruction (To complete instruction input, enter '-100'): "); //Prompts for input
            input = sc.nextInt(); //Takes the next integer as input
            if(String.valueOf(input).length()==4) //If the input is 4 integers long, store it in memory
            {
                memory.setValue(ioCounter, input); //stores input at address[ioCounter]
                ioCounter ++; //increments ioCounter so it'll look at the next memory location properly
            }
            else //Else prompt the user to try again
            {
                System.out.println("Invalid entry...\nPlease try again: ");
            }
        }
        System.out.println("*** PROGRAM LOADING ***");
    }

    public int getRead() //used to get the input for the READ instruction
    {
        int input = sc.nextInt();
        return input;
    }

    public void writeToScreen(int output) //outputs an integer to the user
    {
        System.out.println("*** PROGRAM OUTPUT ***");
        System.out.println("Output: " + output);
    }
}
