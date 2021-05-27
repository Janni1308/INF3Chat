/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Model;

import Start.Util.OhmLogger;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author schel
 */
public class ChatModel implements Subscriber<Object>
{
    private static final java.util.logging.Logger lg = OhmLogger.getLogger();
    // pubisher und subsc.
    private TransmitterModel transmitter;
    private GrafikModel grafikModel;
    
    private Subscription subscription;
    private SubmissionPublisher<Object> iPublisher;
    
    public ChatModel()
    {
        this.transmitter = new TransmitterModel();
        this.grafikModel = new GrafikModel();
        this.iPublisher = new SubmissionPublisher<Object>();
    }
    public TransmitterModel getTransmitterModel()
    {
        return this.transmitter;
    }
    public GrafikModel getGrafikModel()
    {
        return this.grafikModel;
    }

    public void doSubscribe()
    {
        this.transmitter.addValueSubscription(this);
        //this.grafikModel.addSubscriber(this);
    }
    public void addSubscriber(Subscriber<Object> subscriper)
    {
        iPublisher.subscribe(subscriper);
    }
    @Override
    public synchronized void onSubscribe(Flow.Subscription subscription)
    {
        this.subscription = subscription;

        this.subscription.request(1);

        lg.info("OnSubscribe");
    }

    @Override
    public synchronized void onNext(Object item)
    {

        lg.info("ChatModel OnNext");

        if(item instanceof Figure)
        {
            this.grafikModel.add((Figure)item);
        }
        iPublisher.submit(item);
        this.subscription.request(1);
        lg.info("ChatModel published");

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
