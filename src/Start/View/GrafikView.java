/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.View;

import Start.Model.ChatModel;
import Start.Model.Figure;
import Start.Model.GrafikModel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



/**
 *
 * @author schel
 */
public class GrafikView extends JComponent implements Printable
{
    private final static Dimension DIM_ONE = new Dimension(1,1);
    private Rectangle2D.Float pixel;
    private ChatModel model;    // Reference ist erlaubt
    private Line2D.Float line;    
    
    public GrafikView()// keine Parameter deshalb setModel
    {
        this.pixel = new Rectangle2D.Float();
        line = new Line2D.Float();
    }
    public void setModel(ChatModel model )
    {
        this.model = model;
    }


    public void drawPoint(Point p)
    {
        Graphics2D g2 = (Graphics2D)this.getGraphics(); // Grafik laden
        

        g2.setStroke(new BasicStroke(15));

        pixel.setFrame(p,DIM_ONE);
        g2.draw(pixel);
        
        g2.dispose();//SEEEHR WICHTIG SONST LAUFT GRAFIKSPEICHER VOLL
    }

    public void drawFigure(Figure f)
    {
        Graphics2D g2 = (Graphics2D)this.getGraphics(); // Grafik laden
        //Graphics2D g2 = (Graphics2D)SwingUtilities.getWindowAncestor(this).getGraphics();
        List<Point> points = f.getPoints();
        g2.setStroke(new BasicStroke(10));
        Point pointBefore = null;
        for(Point point: points)
        {
            if(pointBefore != null)
            {
                line.setLine(pointBefore.x, pointBefore.y, point.x, point.y);
                g2.draw(line);
            }
            pointBefore = point;
        }
        g2.dispose();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Graphics2D g2 = (Graphics2D)SwingUtilities.getWindowAncestor(this).getGraphics();

        if(model != null)
        {
            for(Figure f : model.getGrafikModel().getFigures())
            {
                List<Point> points = f.getPoints();
                g2.setStroke(new BasicStroke(10));
                
                Point pointBefore = null;
                for(Point point: points)
                {
                    if(pointBefore != null)
                    {
                        line.setLine(pointBefore.x, pointBefore.y, point.x, point.y);
                        g2.draw(line);
                    }
                    pointBefore = point;
                }

            }
        }
        g2.dispose();
    }
    
    
    
    public void doPrint()
    {
        HashPrintRequestAttributeSet printSet = new HashPrintRequestAttributeSet();
        printSet.add(DialogTypeSelection.NATIVE); // Plattformabhängigkeiten...
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(this);
        if(pj.printDialog(printSet))
        {
            try
            {
                pj.print(printSet);
                
            } catch (PrinterException ex)
            {
                JOptionPane.showConfirmDialog(this, ex.toString());
            }
        }
    }
    @Override
    public int print(Graphics gp, PageFormat pf, int pageIndex) throws PrinterException
    {
        Graphics2D g2p = (Graphics2D)gp;
        if(pageIndex == 0)// Hier wird verhindert das ständig gedruckt wird
        {
            g2p.translate(pf.getImageableX(), pf.getImageableY());
            g2p.scale(pf.getImageableWidth()/this.getWidth(),pf.getImageableHeight()/this.getHeight());
            super.print(g2p);
            return Printable.PAGE_EXISTS;
        }
        else
        {
            return Printable.NO_SUCH_PAGE;
        }
    }

  
}
