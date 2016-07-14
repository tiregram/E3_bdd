/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice;

import pizzaservice.bdd.BDDAcess;
import pizzaservice.controll.cmd.Line;
import pizzaservice.controll.cmd.InvokerCommand;
import pizzaservice.ihm.IhmMain;
import pizzaservice.ihm.MenuPrincipalView;

/**
 *
 * @author user
 */
public class PizzaService {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Bienvenue sur Service Pizza");
        new IhmMain();
        
        InvokerCommand.getInstanceSingleton().interpret(new Line("menuApp"));
        BDDAcess.GetBDD();
        
        while(true){
                
        System.out.print(">");
        Line l = new Line();
        InvokerCommand.getInstanceSingleton().interpret(l);

            }
        
        
        
       
    }
}
