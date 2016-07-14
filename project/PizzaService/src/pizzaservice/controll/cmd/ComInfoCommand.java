/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import java.util.ArrayList;
import pizzaservice.bdd.CommandModel;
import pizzaservice.ihm.MoreView;

/**
 *
 * @author user
 */
public class ComInfoCommand  implements Command{

    @Override
    public void execute(Line line) {
       
        ArrayList<String> a = new ArrayList<String>();
        a.add("La moyenne est de " + CommandModel.getMoyenCommand());
        
        new MoreView().showText(a);
    }

    @Override
    public String getHelp() {
      
    return "done des info sur les command";
    }
    
}
