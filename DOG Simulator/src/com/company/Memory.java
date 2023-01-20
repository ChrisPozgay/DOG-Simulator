package com.company;

public class Memory{

    public int[] address;
    private final int LENGTH = 100;
    Memory(){
        address = new int[LENGTH]; //sets the array to length 100 for instructions and storage
        for(int i = 0; i<LENGTH; i++) //sets each index to 0 so that every location has some form of data
        {
            address[i] = 0;
        }
    }

    public int getValue(int memLoc) //returns whatever value is stored at the memLoc
    {
        return address[memLoc];
    }
    public void setValue(int memLoc, int pInput) //sets the index at memLoc to the input desired
    {
        address[memLoc] = pInput;
    }

    public void memoryDump() //I'd like to say that yes, this is incredibly ugly to look at and I'm sure there was a better
                                //way to do this... but hell if I know how to do it. This daylight savings time has me messed up.
    {
        System.out.println("\nMEMORY: ");//Header

        for(int i=0; i<10; i++){ //Displays the one's place row for the matrix
            System.out.print("\t\t" + i);
        }
        System.out.println();

        System.out.print("00"); //Shows the memory locations that have 0 in the tens place
        for(int i=0; i<10; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i))); //formats the output to show positive/negetive attributes with leading 0's
        }
        System.out.println();

        System.out.print("10");
        for(int i=10; i<20; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("20");
        for(int i=20; i<30; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("30");
        for(int i=30; i<40; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("40");
        for(int i=40; i<50; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("50");
        for(int i=50; i<60; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("60");
        for(int i=60; i<70; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("70");
        for(int i=70; i<80; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("80");
        for(int i=80; i<90; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();

        System.out.print("90");
        for(int i=90; i<100; i++){
            System.out.print("\t" + String.format("%+05d", getValue(i)));
        }
        System.out.println();
    }

}
