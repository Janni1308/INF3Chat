/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Model;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

/**
 *BESITZT KEINE REFERENZEN UND KEINE GRAFIKELEMENTE - Hier nur mathematische Daten!!!
 * Serializeable muss hier nicht vererbt werden wegen ArrayList (ist serializierbar)
 * @author schel
 */
public class GrafikModel
{
    //private SubmissionPublisher<Figure> iPublisher;
    private ArrayList<Figure> figures;
    // besser ref und aufnehmen
    private Figure currentFigure;
    public GrafikModel()
    {
        figures = new ArrayList<>();
        createNewFigure();
    }
    public void clear()
    {
        figures.clear();
        createNewFigure();
    }
    public Figure getCurrentFigure()
    {
        return currentFigure;
    }
    public void add(Figure f)
    {
        this.figures.add(f);
    }
    public void createNewFigure()
    {
//        if (currentFigure != null)
//        {
//            this.iPublisher.submit(currentFigure);
//        }
        currentFigure = new Figure();
        // add here to figures
        figures.add(currentFigure);
    }
    public void addPointToFigure(Point p)
    {
        currentFigure.addPoint(p);
    }
//    public void addSubscriber(Subscriber<Figure> sub)
//    {
//        iPublisher.subscribe(sub);
//    }

    public List<Figure> getFigures()
    {
        return Collections.unmodifiableList(figures);
    }
//    public void savePoints(String filename) throws FileNotFoundException, IOException
//    {
//        FileOutputStream fos = new FileOutputStream(filename);
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(figures);
//        oos.flush();// wichtig um von Arbeitsspeicher auf Festplatte zu schreiben - leert und schreibt buffer auf Festplatte
//        oos.close();// führt implizit flush aus - flush könnte hier also auch weggelassen werden
//    }
//    public void loadPoints(String filename) throws IOException
//    {
//        FileInputStream fis = new FileInputStream(filename);
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        
//        Object obj= null;
//        try
//        {
//            obj = ois.readObject();
//        }
//        catch(Exception e)
//        {
//            
//        }
//        
//        if(obj instanceof ArrayList)
//        {
//            figures = (ArrayList<Figure>)obj;
//        }
//         ois.close();
//    }
}
