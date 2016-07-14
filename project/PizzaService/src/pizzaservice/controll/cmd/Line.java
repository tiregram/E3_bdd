/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Line {
    private ArrayList<String> words;
    
    public Line()
    {
        this(new Scanner(System.in).nextLine());
        
    }
    
     public Line(String inputLine)
    {
        this.words =  new ArrayList<String>();
        
        
        for (String oneWord : inputLine.split(" "))
            this.words.add(oneWord);
    }
    
    public String getWordN(int n)
    {
        if(this.words.size() > n)
            return this.words.get(n);
        else
            return null;
    }
            
            
            
    
}
