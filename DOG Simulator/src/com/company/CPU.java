package com.company;

public class CPU {
    private int registerAccumulator; //Accumulator
    private int registerCounter; //Instruction Counter
    private int registerMemLocation; //Memory Location the system is currently viewing
    private int registerOperationCode; //Holds the 2-digit operation code
    private int registerOperand; //Holds the 2-digit 'variable' that contains the memory location operated on.
    public Memory memory; //Memory object that the CPU will interact with
    private IO io;

    //CPU's default constructor
    public CPU() {
        //All registers start as 0
        registerAccumulator = 0;
        registerCounter = 0;
        registerMemLocation = 0;
        registerOperationCode = 0;
        registerOperand = 0;
        memory = new Memory();
        io = new IO();
    }

    //CPU's overloaded constructor that tells it what memory object to interact with
    public CPU(Memory pMemory, IO io) {
        //All registers start as 0
        registerAccumulator = 0;
        registerCounter = 0;
        registerMemLocation = 0;
        registerOperationCode = 0;
        registerOperand = 0;
        this.memory = pMemory;
        this.io = io;
    }

    //Accessors and Mutators as needed for the registers
    public int getRegisterAccumulator() {
        return registerAccumulator;
    }
    public void setRegisterAccumulator(int registerAccumulator) {
        this.registerAccumulator = registerAccumulator;
    }
    public int getRegisterCounter() {
        return registerCounter;
    }
    public void setRegisterCounter(int registerCounter) {
        this.registerCounter = registerCounter;
    }
    public int getRegisterMemLocation() {
        return registerMemLocation;
    }
    public void setRegisterMemLocation(int registerMemLocation) {
        this.registerMemLocation = registerMemLocation;
    }
    public int getRegisterOperationCode() {
        return registerOperationCode;
    }
    public void setRegisterOperationCode(int registerOperationCode) {
        this.registerOperationCode = registerOperationCode;
    }
    public int getRegisterOperand() {
        return registerOperand;
    }
    public void setRegisterOperand(int registerOperand) {
        this.registerOperand = registerOperand;
    }

    //Instructions that reads information to/from memory and to/from the accumulator register
    public void Read() //Reads an integer into a memory location; the only method that takes arguments
    {
        System.out.print("Enter an integer: ");
        memory.setValue(registerOperand, io.getRead());
        registerCounter++;
    }
    public void Write() //Writes an integer from the memory to the screen (output)
    {
        io.writeToScreen(memory.getValue(registerOperand));
        registerCounter++;
    }
    public void Load() //Sets the accumulator equal to a value in memory
    {
        setRegisterAccumulator(memory.getValue(registerOperand));
        registerCounter++;
    }
    public void Store() //Stores value in accumulator into a memory location
    {
        memory.setValue(registerOperand, getRegisterAccumulator());
        registerCounter++;
    }

    //Instructions that conduct basic mathematical operations on data stored in the accumulator, leaving the results in the accumulator
    public void Add() //Takes what is in the memory location indicated by registerOperand and adds it to the accumulator
    {
        registerAccumulator += memory.getValue(registerOperand);
        registerCounter++;
    }
    public void Sub() //Takes what is in the memory location indicated by registerOperand and subs it from the accumulator
    {
        registerAccumulator -= memory.getValue(registerOperand);
        registerCounter++;
    }
    public boolean Div() //Takes what is in the memory location indicated by registerOperand and divides the value in accumulator by it
    {
        if(memory.getValue(registerOperand)!=0)
        {
            registerAccumulator /= memory.getValue(registerOperand);
            registerCounter++;
            return true;
        }
        else
        {
            System.out.println("Cannot divide by zero...");
            return false;
        }
    }
    public void Mul() //Takes what is in the memory location indicated by registerOperand and multiplies the value in accumulator by it
    {
        registerAccumulator *= memory.getValue(registerOperand);
        registerCounter++;
    }

    //Instructions that conduct branching. This will be useful for looping within the DML
    public void Branch() //Simply branches to a desired instruction number
    {
        registerCounter = registerOperand;
    }

    public void BranchNegative() //Branches to a desired instruction number IF the accumulator is NEGATIVE
    {
        if (registerAccumulator < 0){
            registerCounter = registerOperand;
        }
    }

    public void BranchZero() //Branches to a desired instruction number IF the accumulator is ZERO
    {
        if (registerAccumulator == 0){
            registerCounter = registerOperand;
        }
    }

    public void HALT() //Tells the user that the program is complete and terminated
    {
        System.out.println("\n*** PROGRAM COMPLETE ***\n*** MEMORY DUMP TO FOLLOW ***");
        this.dumpRegisters();
        memory.memoryDump();
    }

    public void BARK()
    {
        while (true){
            System.out.println("BARK!!");
        }
    }


    public void dumpRegisters() //A quick function that dumps the registers to the user
    {
        System.out.println("Accumulator: " + String.format("%+05d", registerAccumulator));
        System.out.println("Program Counter: " + registerCounter);
        System.out.println("Memory Location: " + String.format("%+05d", registerMemLocation));
        System.out.println("Operand: " + registerOperand);
        System.out.println("Operation Code: " + registerOperationCode);
    }



}
