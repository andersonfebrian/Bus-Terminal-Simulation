package CCP_Assignment;

import java.util.Random;

public class BusTerminalThread extends Thread{
    public BusTerminalThread(String busTerminal){
        setName(busTerminal);
    }

    @Override
    public void run(){
        System.out.println("WELCOME TO " + getName() + " WE ARE OPEN FOR SERVICE!");

        BusTerminal busTerminal = new BusTerminal("APBT");
        TicketCounter counterOne = new TicketCounter("Counter 1");
        TicketCounter counterTwo = new TicketCounter("Counter 2");

        Customer[] customers = new Customer[10];
        for(int i = 0; i < customers.length; i++){
            int randomCounterGenerator = new Random().nextInt(2);
            switch (randomCounterGenerator){
                case 0:
                    customers[i] = new Customer(Integer.toString(i), busTerminal, counterOne);
                    break;
                case 1:
                    customers[i] = new Customer(Integer.toString(i), busTerminal,counterTwo);
                    break;
            }
        }
        for(int i = 0; i < customers.length; i++){
            customers[i].start();
        }
    }
}
