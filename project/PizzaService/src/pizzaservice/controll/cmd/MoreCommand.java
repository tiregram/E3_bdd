/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import pizzaservice.ihm.MoreView;

/**
 *
 * @author user
 */
public class MoreCommand implements Command{

    @Override
    public void execute(Line line) {
        new MoreView().activate();
    }

    @Override
    public String getHelp() {
        return "more info";
    }
    
}
