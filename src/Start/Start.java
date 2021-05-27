/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import Start.Adapter.ReceiveAdapter;
import Start.Commands.CommandConnect;
import Start.Commands.CommandSend;
import Start.Controller.GrafikController;
import Start.Model.ChatModel;
import Start.View.View;

/**
 *
 * @author schel
 */
public class Start
{

    
     public Start()
    {
        View view = new View();
        view.getTaHistory().setEnabled(false);
        
        ChatModel chatModel = new ChatModel();
        chatModel.doSubscribe();
        view.getGrafikView().setModel(chatModel);
        
        GrafikController grafikController = new GrafikController(view, chatModel);
        grafikController.registerEvents();
        
        CommandConnect cmdConnect = new CommandConnect(view,chatModel);
        cmdConnect.registerEvents();
        
        ReceiveAdapter adapter = new ReceiveAdapter(view,chatModel);
        adapter.doSubscribe();
        
        CommandSend cmdSend = new CommandSend(view,chatModel);
        cmdSend.registerEvents();
        
        
        view.setVisible(true);
              
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new Start();
        new Start();
    }
    
}
