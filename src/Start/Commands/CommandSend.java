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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author schel
 */
public class CommandSend implements KeyListener
{

    private static final java.util.logging.Logger lg = OhmLogger.getLogger();

    private View view;
    private ChatModel chatModel;
    public CommandSend(View view, ChatModel chatmodel)
    {
        this.view = view;
        this.chatModel = chatmodel;
    }
    public void registerEvents()
    {
        this.view.getTfInput().addKeyListener(this);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            try
            {
                this.chatModel.getTransmitterModel().send(view.getTfInput().getText());
            } 
            catch (IOException ex)
            {
                Logger.getLogger(CommandSend.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.getTaHistory().setText(view.getTaHistory().getText()+view.getTfInput().getText()+System.getProperty("line.separator"));
            view.getTfInput().setText("");
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
    }



}


