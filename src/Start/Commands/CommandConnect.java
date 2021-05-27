/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Commands;


import Start.Model.ChatModel;
import Start.Model.TransmitterModel;
import Start.Util.OhmLogger;
import Start.View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author schel
 */
public class CommandConnect implements ActionListener
{

    private static final java.util.logging.Logger lg = OhmLogger.getLogger();

    private View view;
    private ChatModel chatModel;
    
    public CommandConnect(View view, ChatModel chatModel)
    {
        this.view = view;
        this.chatModel = chatModel;
    }

    public void registerEvents()
    {
        view.getBtnClient().addActionListener(this);
        view.getBtnServer().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== view.getBtnClient())
        {
            this.chatModel.getTransmitterModel().setClient();
            view.getLblState().setText("Client");
            view.getBtnServer().setEnabled(false);
        }
        else if(e.getSource()== view.getBtnServer())
        {
            this.chatModel.getTransmitterModel().setServer();
            view.getLblState().setText("Server");
            view.getBtnClient().setEnabled(false);

        }
    }


    
}
