/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;
import pizzaservice.controll.cmd.MenuCommand;
import java.util.HashMap;


/**
 *
 * @author user
 */
public class InvokerCommand {
    
    private static InvokerCommand currentInstance;
    private HashMap<String,Command> hcommand;
    
    
    public HashMap<String,Command> getAllCommand()
    {
        return this.hcommand;
    }
    
    public static InvokerCommand getInstanceSingleton()
    {
        if(InvokerCommand.currentInstance ==  null)
        {
         InvokerCommand.currentInstance = new InvokerCommand();
        }
        return InvokerCommand.currentInstance; 
    }
    
    private InvokerCommand()
    {
        this.hcommand = new HashMap<String, Command>();
        hcommand.put("menu",new MenuCommand());
        hcommand.put("exit",new ExitCommand());
        hcommand.put("help",new HelpCommand());
        hcommand.put("menuApp",new MenuAppCommand());
        hcommand.put("pizzaInfo",new MenuShowPizzaCommand());
        hcommand.put("fiche",new FicheCommand());
        hcommand.put("ficheInfo",new FicheInfoCommand());
        hcommand.put("more",new MoreCommand());
        hcommand.put("vecInfo",new VecInfo());
        hcommand.put("comByClient",new ComByClientCommand());
        hcommand.put("comInfo",new ComInfoCommand());
        hcommand.put("moyenInfo",new ComInfoMoyenCommand());
                
        
    }
    
    public void interpret(Line line)
    {
        if(this.hcommand.containsKey(line.getWordN(0)))
            this.hcommand.get(line.getWordN(0)).execute(line);
        else 
            System.out.println("cette command n'existe pas");
    }
    
    
    

}
