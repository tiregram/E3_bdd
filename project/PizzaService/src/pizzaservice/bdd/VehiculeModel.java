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
public class VehiculeModel extends Model {
    
    public int id;
    public String name;
    
    public VehiculeModel(int id,String name)
    {
        this.id= id;
        this.name = name;
    
    }
    
    public static ArrayList<Model> getUnused()
    {
        
         ArrayList<Model> a = new ArrayList<Model>();
       
        Statement statement;
        ResultSet resultat;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery(
            "SELECT DISTINCT vehicle.Id as 'id',"
                    + " vehicle.Name as 'Vehicule'"
                    + " FROM vehicle "
                    + "WHERE vehicle.Id NOT IN "
                    + "(SELECT DISTINCT Id_Vehicle FROM command);");
            
            while(resultat.next())
            {
                a.add(new VehiculeModel(
                        resultat.getInt("Id"),
                        resultat.getString("Vehicule")
                        ));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return a;
    
    
    }
    
    
}
