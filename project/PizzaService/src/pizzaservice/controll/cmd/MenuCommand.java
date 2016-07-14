/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import pizzaservice.ihm.MenuPizzaView;

/**
 *
 * @author user
 */
public class MenuCommand implements Command
{
    public MenuCommand()
    {
    
    }
    
    public void execute(Line line)
    {
        System.out.println("menu");
        new MenuPizzaView().activate();
    }

    @Override
    public String getHelp() {
        return "Menu: donne le menu";
    }
    
}
