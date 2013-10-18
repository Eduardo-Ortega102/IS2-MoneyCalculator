package moneycalculator.control;

import java.io.IOException;
import moneycalculator.model.Number;
import moneycalculator.userinterface.MoneyDialog;

public class Main {

    public static void main(String[] args) throws IOException {
        //numberTest()
        MoneyDialog mon = new MoneyDialog();
        mon.execute();
        System.out.println(mon.getMoney());

    }
    
    private static void numberTest(){
         Number number1 = new Number(2,6);
         Number number2 = new Number(1,3);
         Number number3 = new Number(5,2);
         Number number4 = new Number(25,100);
         Number number5 = new Number(number4);
         Number number6= new Number(0.5); 
         Number number7= new Number(2.5); 
         Number number8 = Number.valueOf("200.15");
         System.out.println(number1);
         System.out.println(number2);
         System.out.println(number3);
         System.out.println(number4);
         System.out.println(number5);
         System.out.println(number5.equals(number4));
         System.out.println(number6);
         System.out.println(number7);
         System.out.println(number8.equals(number7));
    }
}
