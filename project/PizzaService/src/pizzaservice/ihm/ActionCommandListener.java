/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservice.ihm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pizzaservice.controll.cmd.InvokerCommand;
import pizzaservice.controll.cmd.Line;
/**
 *
 * @author user
 */
public class ActionCommandListener implements ActionListener
{
    private Line line;
    
    public ActionCommandListener(String pCommand)
    {
        this.line = new Line(pCommand);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InvokerCommand.getInstanceSingleton().interpret(this.line);
    }
    
}
