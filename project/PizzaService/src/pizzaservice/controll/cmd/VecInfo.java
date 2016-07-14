/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import java.util.ArrayList;
import pizzaservice.bdd.Model;
import pizzaservice.bdd.VehiculeModel;
import pizzaservice.ihm.MoreView;

/**
 *
 * @author user
 */
public class VecInfo  implements  Command{

    @Override
    public void execute(Line line) {
        
     ArrayList<String> a = new ArrayList<String>();
        
     for(Model one :VehiculeModel.getUnused())
     {
         VehiculeModel oneCast= (VehiculeModel) one;
         a.add(oneCast.id +" " + oneCast.name);
     }
         

      new MoreView().showText(a);

    }

    @Override
    public String getHelp() {
        return "vehicule qui ne serve pas";
    }
    
}
