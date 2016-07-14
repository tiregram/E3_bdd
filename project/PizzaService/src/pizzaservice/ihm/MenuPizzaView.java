/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Locale;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import pizzaservice.bdd.Model;
import pizzaservice.bdd.PizzaModel;


/**
 *
 * @author user
 */
public class MenuPizzaView {
    
    public MenuPizzaView() {
    
    }
    
    public static  JPanel infoPizza = null;
    
    
    public void activatePizzaInfo(int n)
    {
        PizzaModel pz = PizzaModel.get(n);
        this.infoPizza.removeAll();
        
        
        this.infoPizza.add(new JLabel("name: "+pz.name));
        this.infoPizza.add(new JLabel("prix: "+pz.price));
        this.infoPizza.add(new JLabel("ingredient: "+pz.listIngedient));    
        
        this.infoPizza.invalidate();
        this.infoPizza.validate();
        this.infoPizza.repaint();
        
    }
    
    public void activate()
    {
        IhmMain.fen.getContentPane().removeAll();
        IhmMain.fen.setLayout(new BoxLayout(IhmMain.fen.getContentPane(), BoxLayout.Y_AXIS));
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        JButton but = new JButton("back");
        but.addActionListener(new ActionCommandListener("menuApp"));
        p.add(but);
        
        JPanel menuChose = new JPanel();
        menuChose.setLayout(new GridLayout(1,2));
        
        JPanel g= new JPanel();
        g.setLayout(new BoxLayout(g,BoxLayout.Y_AXIS));
        for(Model one : PizzaModel.all())
        {
            JButton a = new JButton(((PizzaModel)one).name);
            
            a.addActionListener(new ActionCommandListener("pizzaInfo "+((PizzaModel)one).id));
            g.add(a) ;
        }
       

        
        JPanel r= new JPanel();
        r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
        infoPizza = r;
        

        JScrollPane rs = new JScrollPane(r);
        rs.setAutoscrolls(true);
        JScrollPane gs = new JScrollPane(g);
        gs.setAutoscrolls(true);
        
        menuChose.add(gs);
        menuChose.add(rs);
        
        IhmMain.fen.add(p);
        IhmMain.fen.add(menuChose);
        
        
        IhmMain.fen.invalidate();
        IhmMain.fen.validate();
        IhmMain.fen.repaint();

    }
    
}
