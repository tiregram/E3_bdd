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
public class CommandModel extends Model {
    
    
    
      public static double  getMoyenCommand()
    {
     
       
        Statement statement;
        ResultSet resultat;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery(
            "SELECT AVG(pipe.nb) as 'Moyenne du nombre de Commandes' "
                    + "FROM "
                    + "(select count(command.Id_Customer) as nb "
                    + "FROM command "
                    + "GROUP BY command.Id_Customer) pipe ");
            
             resultat.next();
            return resultat.getDouble("Moyenne du nombre de Commandes");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         
        
        return 0;
    }
    

    
}
