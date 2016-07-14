/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import pizzaservice.ihm.MenuPrincipalView;

/**
 *
 * @author user
 */
public class MenuAppCommand implements Command {
    
    public MenuAppCommand()
    {
        super();
    
    }

    @Override
    public void execute(Line line) {
       new MenuPrincipalView().activate(); 
    }

    @Override
    public String getHelp() {
        return "help";
    }
    
}
