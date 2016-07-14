/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import pizzaservice.ihm.LivraisonView;

/**
 *
 * @author user
 */
public class FicheCommand implements Command{

    @Override
    public void execute(Line line) {
    
        new LivraisonView().activate();
    }

    @Override
    public String getHelp() {
        return "fiche client";
    }
    
    
}
