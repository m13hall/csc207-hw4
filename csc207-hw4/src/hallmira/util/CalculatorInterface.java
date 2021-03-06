package hallmira.util;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Andrew Kelley
 * @author Mira Hall 
 *
 */
public class CalculatorInterface {

    public static void main (String[] args) throws Exception{

        FractionCalculator calc = new FractionCalculator();
        
        PrintWriter pen = new PrintWriter(System.out, true);
        InputStreamReader istream = new InputStreamReader(System.in);
        BufferedReader eyes = new BufferedReader(istream);

        pen.println("Welcome to the Caluclatador!");
        boolean cont = true;
        while (cont){
            pen.println("Press Q to quit");
            pen.println("Please type your input and hit enter");


            String line = eyes.readLine();
            pen.println("Your entry:" + line);

            //try{
                String output = calc.evaluate(line).toString();
                if (output.equals(new String("Q"))){
                    cont = false;
                    pen.println("Quitting!");
                }else{
                    pen.println("=  "+ output);

                }
            //}//try
            //catch(badEntry e) {
            //    pen.println(e);
        //    }//catch


        }//while
    }
}
