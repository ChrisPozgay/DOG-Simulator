package com.company;

public class DOG {

    //public attributes
        //all of the inheritance in this program is association-based (a 'has-a' relationship)
    public CPU cpu;
    public Memory memory;
    public IO io;

    //Constant variables that will be compared to the input for instructions


    DOG() //Constructor for the simulator
    {
        memory = new Memory(); //initializes a fresh memory object
        io = new IO(memory); //initializes the io object using memory as an argument
        cpu = new CPU(memory, io); //initializes the cpu which uses the memory and io as arguments
        //my logic for this was that you first need a container for information
        //next you needed to have some way to receive from and return to the user the information
        //the math can only be conducted if it has the information and a way to display it first
    }

    public void runProgram() //Method that tells the DOG simulation to execute the code entered by the user
    {
        boolean runProg = true;
        int operation = 0;
        cpu.setRegisterMemLocation(0);
        while(operation != 43 && runProg)
        {
            operation = memory.getValue(cpu.getRegisterCounter()) / 100;
            int operand = memory.getValue(cpu.getRegisterCounter()) % 100;
            cpu.setRegisterOperationCode(operation);
            cpu.setRegisterOperand(operand);
            runProg = callOperation(operation);
            cpu.setRegisterMemLocation(cpu.getRegisterMemLocation()+1);
        }
    }

    private boolean callOperation(int operation) //checks what operation is being called, and executes it. Returning a boolean tells the system to proceed
    {
        switch(operation)
        {
            case Instructions.READ:
                cpu.Read();
                return true;
            case Instructions.WRITE:
                cpu.Write();
                return true;
            case Instructions.LOAD:
                cpu.Load();
                return true;
            case Instructions.STORE:
                cpu.Store();
                return true;
            case Instructions.ADD:
                cpu.Add();
                return true;
            case Instructions.SUB:
                cpu.Sub();
                return true;
            case Instructions.DIV:
                return cpu.Div();
            case Instructions.MUL:
                cpu.Mul();
                return true;
            case Instructions.BRANCH:
                cpu.Branch();
                return true;
            case Instructions.BRANCHNEG:
                cpu.BranchNegative();
                return true;
            case Instructions.BRANCHZERO:
                cpu.BranchZero();
                return true;
            case Instructions.HALT:
                cpu.HALT();
                return true;
            case Instructions.BARK:
                cpu.BARK();
                return true;
        }
        return false;
    }
}
