/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

import pizzaservice.controll.cmd.Command;
import pizzaservice.controll.cmd.Line;
import pizzaservice.ihm.LivraisonView;
/**
 *
 * @author user
 */
public class FicheInfoCommand implements Command{

    @Override
    public void execute(Line line) {
         new LivraisonView().activateOne(new Integer(line.getWordN(1)));
    }

    @Override
    public String getHelp() {
        return "info sur une fiche";
    }
    
}
