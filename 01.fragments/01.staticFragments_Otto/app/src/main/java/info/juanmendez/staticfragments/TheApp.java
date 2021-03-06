package info.juanmendez.staticfragments;

import android.app.Application;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.ThreadEnforcer;

import info.juanmendez.staticfragments.models.ValueChangedEvent;

public class TheApp extends Application
{
    private Bus bus  = new Bus( ThreadEnforcer.MAIN);
    private ValueChangedEvent event;

    public void register( Object o )
    {
        bus.register( o );
    }

    public void unregister( Object o )
    {
        bus.unregister( o );
    }

    public void requestValueChanged(ValueChangedEvent e)
    {
        event = e;
        bus.post( event );
    }

    @Produce
    public ValueChangedEvent produceValueEvent()
    {
        return event;
    }
}
