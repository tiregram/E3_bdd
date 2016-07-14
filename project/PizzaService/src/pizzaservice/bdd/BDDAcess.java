/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class BDDAcess {
    
    private static BDDAcess instanceUnique=null;
            
    public static BDDAcess GetBDD()
    {
        if(instanceUnique == null)
        {
           instanceUnique = new BDDAcess();
        }
        return instanceUnique;
    }
    
    public     Connection coon = null; 

    public void closeConnection()
    {
        try{
            this.coon.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    
    
    private BDDAcess()
    {
        
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            System.out.println("erreur driver");
        }
    
        try {


            String url = "jdbc:mysql://localhost:3306/projetDB";
            String user = "root";
            String passwd = "root";

            this.coon = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");         

          } catch (Exception e) {
            e.printStackTrace();
          }      
        }
            
        
    
}
    
    
    

