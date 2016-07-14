/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.bdd;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class FicheModel extends Model{
    
    public int id;
    public String nameLivreur;
    public String typeLivreur;
    public String nameClient;
    public Date date;
    public int retard;
    public String namePizza;
    public double prix;
    
    public FicheModel(
            int id,
            String nameLivreur,
            String typeLivreur,
            String nameClient,
            Date date,
            int retard,
            String namePiza,
            double prix)
    {
        this.id = id;
        this.nameLivreur = nameLivreur;
        this.typeLivreur = typeLivreur;
        this.nameClient = nameClient;
        this.date = date;
        this.retard = retard;
        this.namePizza = namePiza;
        this.prix = prix ;
    }
    
    public static ArrayList<Model> all()
    {
          
        ArrayList<Model> a = new ArrayList<Model>();
       
        Statement statement;
        ResultSet resultat;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery(
                    "SELECT "
                    + "command.id as id,"
                    + "deliveryman.Name as 'Livreur',"
                    + "vehicletype.Name as 'Vehicule',"
                    + "customer.Firstname 'Nom Client',"
                    + "customer.Lastname as 'Prenom Client',"
                    + "DATE(command.TimeOderer) as 'Date',"
                    + "TIMESTAMPDIFF(MINUTE, command.TimeOderer, command.TimeDeliver) as 'Temps de Livraison',"
                    + "product.Name as 'Pizza',"
                    + "product.Price as 'Prix' "
                    + "FROM command "
                    + "INNER JOIN customer ON command.Id_Customer = customer.Id "
                    + "INNER JOIN deliveryman ON command.Id_DeliveryMan = deliveryman.Id "
                    + "INNER JOIN product ON command.Id_Product = product.Id "
                    + "INNER JOIN vehicle ON command.Id_Vehicle = vehicle.Id "
                    + "INNER JOIN vehicletype ON vehicle.Id_VehicleType = vehicletype.Id;"
                                         );
            
            while(resultat.next())
            {
                a.add(
                        new FicheModel(
                        resultat.getInt("id"),
                        resultat.getString("Livreur"),
                        resultat.getString("Vehicule"),
                        resultat.getString("Nom Client")+" "+resultat.getString("Prenom Client"),
                        resultat.getDate("Date"),
                        resultat.getInt("Temps de Livraison"),
                        resultat.getString("Pizza"),
                        resultat.getDouble("Prix")
                        ));
                        
                        
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         
        return a;
    }
    
    public static FicheModel get(int id)
    {
        Statement statement;
        ResultSet resultat;
        FicheModel ret = null;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery(
                    "SELECT "
                    + "command.id as id,"
                    + "deliveryman.Name as 'Livreur',"
                    + "vehicletype.Name as 'Vehicule',"
                    + "customer.Firstname 'Nom Client',"
                    + "customer.Lastname as 'Prenom Client',"
                    + "DATE(command.TimeOderer) as 'Date',"
                    + "TIMESTAMPDIFF(MINUTE, command.TimeOderer, command.TimeDeliver) as 'Temps de Livraison',"
                    + "product.Name as 'Pizza',"
                    + "product.Price as 'Prix' "
                    + "FROM command "
                    + "INNER JOIN customer ON command.Id_Customer = customer.Id "
                    + "INNER JOIN deliveryman ON command.Id_DeliveryMan = deliveryman.Id "
                    + "INNER JOIN product ON command.Id_Product = product.Id "
                    + "INNER JOIN vehicle ON command.Id_Vehicle = vehicle.Id "
                    + "INNER JOIN vehicletype ON vehicle.Id_VehicleType = vehicletype.Id "
                    + "where command.id="+id+";"
                                         );
            
            resultat.next();
            
            ret = new FicheModel(
                    resultat.getInt("id"),
                    resultat.getString("Livreur"),
                    resultat.getString("Vehicule"),
                    resultat.getString("Nom Client")+" "+resultat.getString("Prenom Client"),
                    resultat.getDate("Date"),
                    resultat.getInt("Temps de Livraison"),
                    resultat.getString("Pizza"),
                    resultat.getDouble("Prix")
                );
                       
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         
        return ret ;
    }
}
