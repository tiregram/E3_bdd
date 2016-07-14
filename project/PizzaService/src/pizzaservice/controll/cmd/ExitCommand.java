/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import pizzaservice.bdd.BDDAcess;

/**
 *
 * @author user
 */
public class ExitCommand implements Command{
    public ExitCommand()
    {
    }
    
   
    
     public void execute(Line line)
    {
        BDDAcess.GetBDD().closeConnection();
        System.out.println("exit");
        System.out.println("Merci d'avoir utilisé Pizza Service");
        
        System.exit(1);
        
    }

    @Override
    public String getHelp() {
        return "Exit the Program";
        }
    
}
