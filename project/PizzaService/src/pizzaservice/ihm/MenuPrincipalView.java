/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.ihm;

import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author user
 */
public class MenuPrincipalView {

    public MenuPrincipalView() {
    
    }
    
    public void activate()
    {
        
        IhmMain.fen.getContentPane().removeAll();
        
        IhmMain.fen.setLayout(new GridLayout(4,1));
        
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionCommandListener("menu"));
        IhmMain.fen.add(menuButton);
        
        
        JButton ficheButton = new JButton("Fiche Livraison");
        ficheButton.addActionListener(new ActionCommandListener("fiche"));
        IhmMain.fen.add(ficheButton);
        
        JButton moreInfo = new JButton("moreInfo");
        moreInfo.addActionListener(new ActionCommandListener("more"));
        IhmMain.fen.add(moreInfo);
        
        JButton exitButton= new JButton("Exit");
        exitButton.addActionListener(new ActionCommandListener("exit"));
        IhmMain.fen.add(exitButton);
        
        IhmMain.fen.invalidate();
        IhmMain.fen.validate();
        IhmMain.fen.repaint();
        
        
    }
    
    
}

