/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.bdd;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ClientModel extends Model{
    
    public String name;
    public int nbDeCommand;
    
    public ClientModel(String name, int nbDeCommand)
    {
        this.name =  name;
        this.nbDeCommand = nbDeCommand;
    }
    
    public static ArrayList<Model> getCommandByClent()
    {
      ArrayList<Model> a = new ArrayList<Model>();
       
        Statement statement;
        ResultSet resultat;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery(
              "SELECT customer.Firstname as 'Nom Client', customer.Lastname as 'Prenom Client', count(command.Id_Customer) as 'Nombre de Commandes' "
                    + "FROM command "
                    + "INNER JOIN customer ON  command.Id_Customer = customer.Id "
                    + "GROUP BY command.Id_Customer"
        );
            
            while(resultat.next())
            {
                a.add(
                        new ClientModel(
                        resultat.getString("Nom Client")+" "+resultat.getString("Prenom Client"),
                        resultat.getInt("Nombre de Commandes")
                        ));
                        
                        
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         
        return a;
    
    }
    
       public static ArrayList<Model> getClientMoyen()
    {
      ArrayList<Model> a = new ArrayList<Model>();
       
        Statement statement;
        ResultSet resultat;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery(
                    " SELECT customer.FirstName as 'Nom Client', customer.Lastname as 'Prenom Client', count(command.Id_customer) as 'Nombre de Commandes' "
                    + "FROM command "
                    + "INNER JOIN customer ON command.Id_Customer = customer.Id "
                    + "GROUP BY command.Id_Customer "
                    + "HAVING count(command.Id_Customer) >=  "
                    + "("
                    + " SELECT AVG(pipe.nb) as 'Moyenne_Commande'"
                    + " FROM "
                    + " (select count(command.Id_Customer) as nb "
                    + " FROM command "
                    + "GROUP BY command.Id_Customer) pipe"
                    + ");"
        );
            
            while(resultat.next())
            {
                a.add(
                        new ClientModel(
                        resultat.getString("Nom Client")+" "+resultat.getString("Prenom Client"),
                        resultat.getInt("Nombre de Commandes")
                        ));
                        
                        
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         
        return a;
    
    }
    
    
    
    
}

