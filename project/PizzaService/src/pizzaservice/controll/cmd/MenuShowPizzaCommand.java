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
public class MenuShowPizzaCommand implements Command {
    
    public MenuShowPizzaCommand()
    {
    
    }

    @Override
    public void execute(Line line) {
        
        new  MenuPizzaView().activatePizzaInfo(new Integer(line.getWordN(1)));
    }

    @Override
    public String getHelp(){
        return "Show One pizza";
    }
    
    
}
