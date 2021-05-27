/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.*;
/**
 *
 * @author schel
 */
public class OhmLogger
{
    private static Logger lg = null;
    private OhmLogger()
    {
    }
    public static Logger getLogger()
    {
        if(lg == null)
        {
            lg = Logger.getLogger("OhmLogger");
            initLogger();
        }
        return lg;
    }
    private static void initLogger()
    {
        try
        {
           Properties props = new Properties();
           InputStream is = OhmLogger.class.getResourceAsStream("newproperties.properties");
           props.load(is);
           var path = Paths.get(props.getProperty("LOG_FILE")).toString();
           
           FileHandler fileHandler = new FileHandler(path);
           fileHandler.setFormatter(new OhmFormatter());
           lg.addHandler(fileHandler);
           
           ConsoleHandler consoleHandler = new ConsoleHandler();
           consoleHandler.setFormatter(new OhmFormatter());
           lg.addHandler(consoleHandler);
           lg.setUseParentHandlers(false);
           lg.setLevel(Level.parse(props.getProperty("LOG_LEVEL")));
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
    }
}
class OhmFormatter extends SimpleFormatter
{  
    public String format(LogRecord record)
    {
        
        String logLine = "";
        logLine+= new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(new Date(record.getMillis()));//String.format("dd MMM yyyy HH:mm:ss",new Date(record.getMillis()));// hier iso format verwenden
        logLine+= ";"+record.getLevel();
        logLine+= ";"+record.getSourceClassName();
        logLine+= ";"+record.getMessage();
        logLine+= "\n";
        return logLine;
    }
}
