/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Adapter;

import Start.Model.ChatModel;
import Start.Model.Figure;
import Start.Util.OhmLogger;
import Start.View.View;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;


/**
 *
 * @author schel
 */
public class ReceiveAdapter implements Subscriber<Object>
{
    private static final java.util.logging.Logger lg = OhmLogger.getLogger();

    private View view;
    private ChatModel model;
    private Subscription subscription;
    
    public ReceiveAdapter(View view, ChatModel chatModel)
    {
        this.view = view;
        this.model = chatModel;
    }
    public void doSubscribe()
    {
        model.addSubscriber(this);
    }
    @Override
    public void onSubscribe(Subscription subscription)
    {
        this.subscription = subscription;
        lg.info("onsubscribe");
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item)
    {
        lg.info("onNext");
        
        if(item instanceof Figure)
        {
            lg.info("is Figure instanz");
            this.view.getGrafikView().drawFigure((Figure)item);
        }
        else if (item instanceof String)
        {
            view.getTaHistory().setText(view.getTaHistory().getText()+(String)item+System.getProperty("line.separator"));
        }
        this.subscription.request(1);
    }
    
    @Override
    public void onError(Throwable thrwbl)
    {
    }

    @Override
    public void onComplete()
    {
    }

}
