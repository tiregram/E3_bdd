/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import java.util.HashMap;

/**
 *
 * @author user
 */
public class HelpCommand implements Command
{
    public HelpCommand()
    {
        
    }
    
    public void execute(Line line)
    {
        System.out.println("Help");
        
        HashMap<String,Command> commands = InvokerCommand.getInstanceSingleton().getAllCommand();
        if( line.getWordN(1) == null)
        {
            for(String a : commands.keySet())
            {
       
                System.out.println(commands.get(a).getHelp());
            } 
        }
        else
        {
            String helpAbout = line.getWordN(1);
            if(commands.containsKey(helpAbout))
            {

                System.out.println(commands.get(helpAbout).getHelp());
            }
       
        }
        
    }
    
     @Override
    public String getHelp() {
        return "Help > done la liste des commandes possibles\n"
                + "Help [command] : donne l'aide pour cette commande";
        }
}