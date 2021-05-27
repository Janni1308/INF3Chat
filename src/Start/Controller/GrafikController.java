/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Controller;

import Start.Model.ChatModel;
import Start.Model.Figure;
import Start.View.View;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;



/**
 *
 * @author schel
 */
public class GrafikController extends MouseAdapter implements MouseMotionListener
{
    private ChatModel chatModel;
    private View view;

    public GrafikController(View view,ChatModel model)          
    {
        this.chatModel = model;
        this.view = view;
    }

    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            try
            {
                this.chatModel.getTransmitterModel().send(this.chatModel.getGrafikModel().getCurrentFigure());
            } catch (IOException ex)
            {
                Logger.getLogger(GrafikController.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.chatModel.getGrafikModel().createNewFigure();
        }
    }
    public void registerEvents()
    {
        view.addMouseMotionListener(this);
        view.addMouseListener(this);
    }
    @Override
    public void mouseDragged(MouseEvent e)// bewegung mit gedrückter Maustaste
    {
        Point p = e.getPoint();
        
        this.chatModel.getGrafikModel().addPointToFigure(p);
        this.view.getGrafikView().drawPoint(p);
        this.view.getGrafikView().drawFigure(chatModel.getGrafikModel().getCurrentFigure()); 
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }


    
}
