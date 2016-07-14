/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import java.util.ArrayList;
import pizzaservice.bdd.ClientModel;
import pizzaservice.bdd.Model;
import pizzaservice.bdd.VehiculeModel;
import pizzaservice.ihm.MoreView;

/**
 *
 * @author user
 */
public class ComByClientCommand implements Command{

    @Override
    public void execute(Line line) {

         ArrayList<String> a = new ArrayList<String>();
        
     for(Model one : ClientModel.getCommandByClent())
     {
         ClientModel oneCast= (ClientModel) one;
         a.add(oneCast.name +" a commandé " + oneCast.nbDeCommand+" fois");
     }
         

      new MoreView().showText(a);
    
    }

    @Override
    public String getHelp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
