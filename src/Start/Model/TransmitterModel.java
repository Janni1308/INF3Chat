/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Model;


import Start.Util.OhmLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author schel
 */
public class TransmitterModel implements Runnable
{

    private volatile SubmissionPublisher<Object> iPublisher;

    private ExecutorService eService;
    private volatile boolean IsServer;
    private static final java.util.logging.Logger lg = OhmLogger.getLogger();
    private static final int PORT = 35000; // Port über 2^15 verwenden
    private static final String IP = "127.0.0.1";

    //private BufferedReader in = null;
    private ObjectInputStream in = null;
    //private PrintWriter out = null;
    private ObjectOutputStream out = null;
            
    public TransmitterModel()
    {
        iPublisher = new SubmissionPublisher<Object>();
        eService = Executors.newSingleThreadExecutor();
    }
    public void addValueSubscription(Subscriber<Object> subscriberFigure)
    {
        //this.iPublisherString.subscribe(subscriberString);// Veroeffentliche an diesen Teilnehmer
        this.iPublisher.subscribe(subscriberFigure);
        lg.info("Subscribtion added");
    }
    public void setServer()
    {
        IsServer = true;
        eService.execute(this);
        lg.info("Setted as Server and executed");
    }

    public void setClient()
    {
        IsServer = false;
        eService.execute(this);
        lg.info("Setted as Client and executed");
    }
    public synchronized void send(Object obj) throws IOException
    {
        out.writeObject( obj instanceof String ? this.getName()+(String)obj:obj);
        out.flush();
        lg.info("Object sendet");
        eService.execute(this);
    }
    private String getName()
    {
        return this.IsServer ?"Server: ":"Client: ";
    }
    @Override
    public void run()
    {
        lg.info("Reached run");
        for (int i = 0; i < 10; i++)
        {
            try
            {
                Socket socket = IsServer? new ServerSocket(PORT).accept():new Socket(IP,PORT);
                OutputStream oStream = socket.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(oStream);
                out = new ObjectOutputStream(bos);
                //OutputStreamWriter osr = new OutputStreamWriter(oStream,"UTF-8");
                //out = new PrintWriter(osr);
                lg.info("outputstream initialized");
                InputStream iStream = socket.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(iStream);
                in = new ObjectInputStream(bis);
                //InputStreamReader isr = new InputStreamReader(iStream,"UTF-8");
                //in = new BufferedReader(isr);
                lg.info("inputstream inizialied");
                
                break;
            } 
            catch (IOException ex)
            {
                System.err.println(ex.toString());
            }
            try
            {
                Thread.sleep(500);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(TransmitterModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(true)
        {
            Object obj = null;
            try
            {
                obj = in.readObject();
                lg.info("Received");
            }
            catch (Exception ex)
            {
                System.err.println(ex.toString());
            }
            if(obj != null)
            {
                this.iPublisher.submit(obj);
                lg.info("Published");
            }
        }
        
    }
    
}
