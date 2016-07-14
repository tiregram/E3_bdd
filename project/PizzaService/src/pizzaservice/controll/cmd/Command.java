/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.controll.cmd;

/**
 *
 * @author user
 */
public interface Command {
    public void execute(Line line);
    public String getHelp();
    
}
