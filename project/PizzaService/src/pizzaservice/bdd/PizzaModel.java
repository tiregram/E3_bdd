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
public class PizzaModel extends Model{
    
    public String name;
    public int price;
    public int id;
    public String listIngedient;
    
    public PizzaModel(int id,String name, int price, String listInedient)
    {
        this.id = id;
        this.name = new String(name);
        this.price = price;
        this.listIngedient = new String(listInedient);
    
        
    }
    
    
    
    
    
    public static ArrayList<Model> all(){
        
        ArrayList<Model> a = new ArrayList<Model>();
       
        Statement statement;
        ResultSet resultat;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery( 
                    "SELECT "
                    + "product.id, "
                    + "product.Name, "
                    + "product.Price, "
                    + "GROUP_CONCAT(ingredient.Name,\"\") as ingr "
                    + "FROM "
                    + "constitute "
                        + "INNER JOIN ingredient ON constitute.Id = ingredient.Id "
                        + "INNER JOIN product ON constitute.Id_Product = product.Id "
                    + "GROUP BY product.Name;" );
            
            while(resultat.next())
            {
                a.add(new PizzaModel(  
                        resultat.getInt("Id"),
                                resultat.getString("Name"),
                                       resultat.getInt("Price"),
                        resultat.getString("ingr")
                        ));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        

        return a;
    
    }
    
    
    
     public static PizzaModel get(int id){
        
        PizzaModel a = null;
       
        Statement statement;
        ResultSet resultat;
        try{
            statement = BDDAcess.GetBDD().coon.createStatement();
            resultat = statement.executeQuery(
                    "SELECT "
                    + "product.id, "
                    + "product.Name, "
                    + "product.Price, "
                    + "GROUP_CONCAT(ingredient.Name,\"\") as ingr "
                    + "FROM "
                    + "constitute "
                        + "INNER JOIN ingredient ON constitute.Id = ingredient.Id "
                        + "INNER JOIN product ON constitute.Id_Product = product.Id "
                    +"where product.Id="+id
                    + " GROUP BY product.Name;" );
            
            resultat.next();
            
            a =  new PizzaModel(id,
                    resultat.getString("Name"),
                             resultat.getInt("Price"),
                    resultat.getString("ingr")
                            );
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return a;
    
    }
    
    
}
