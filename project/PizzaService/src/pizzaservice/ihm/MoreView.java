/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.ihm;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import pizzaservice.bdd.Model;
import pizzaservice.bdd.PizzaModel;
import static pizzaservice.ihm.MenuPizzaView.infoPizza;

/**
 *
 * @author user
 */
public class MoreView {
    
    public MoreView()
    {
    
    }
    
    public static JPanel panelRight;
    
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
        
        JButton a = new JButton("Vehicule Info");  
        a.addActionListener(new ActionCommandListener("vecInfo"));
        g.add(a);
        
        JButton b = new JButton("commad par Client ");  
        b.addActionListener(new ActionCommandListener("comByClient"));
        g.add(b);
        
        JButton c = new JButton("Command Info");  
        c.addActionListener(new ActionCommandListener("comInfo"));
        g.add(c);
        
        JButton d = new JButton("Moyenne Info");  
        d.addActionListener(new ActionCommandListener("moyenInfo"));
        g.add(d);
        
        
        JPanel r= new JPanel();
        r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
        panelRight = r;
        

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
    
    
    public void showText(ArrayList<String> arrayStr)
    {
        
        this.panelRight.removeAll();
        
        for(String one : arrayStr)
        {
            panelRight.add(new JLabel(one));
        }

        this.panelRight.invalidate();
        this.panelRight.validate();
        this.panelRight.repaint();
    } 
}
