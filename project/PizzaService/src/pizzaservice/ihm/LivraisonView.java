/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.ihm;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import pizzaservice.bdd.FicheModel;
import pizzaservice.bdd.Model;

/**
 *
 * @author user
 */
public class LivraisonView {

    public static  JPanel infoCommand = null;
    
    public LivraisonView()
    {
        
    }
    
    public void activateOne(int id)
    {
        FicheModel fiche = FicheModel.get(id);
        this.infoCommand.removeAll();
        
        
        this.infoCommand.add(new JLabel("name client: "+fiche.nameClient));
        this.infoCommand.add(new JLabel("name Livreur: "+fiche.nameLivreur));
        this.infoCommand.add(new JLabel("piza: "+ fiche.namePizza));
        this.infoCommand.add(new JLabel("prix: "+fiche.prix));
        this.infoCommand.add(new JLabel("date: "+fiche.date));
        this.infoCommand.add(new JLabel("retard: "+fiche.retard));
        
        
        this.infoCommand.invalidate();
        this.infoCommand.validate();
        this.infoCommand.repaint();
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
        for(Model one : FicheModel.all())
        {
            JButton a = new JButton(((FicheModel)one).nameClient 
                    +"=>"
                    +((FicheModel)one).nameLivreur+" "+
                    ((FicheModel)one).namePizza);
            
            a.addActionListener(new ActionCommandListener("ficheInfo "+((FicheModel)one).id));
            g.add(a) ;
        }
        
        JPanel r= new JPanel();
        r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
        infoCommand = r;
        
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


