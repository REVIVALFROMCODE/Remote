package org.example;
import java.awt.Event;
import io.netty.channel.ChannelFactory;
/**
 * @author zhangwei_david
 * @version $Id: ThisEscape.java, v 0.1 2014年11月3日 上午9:37:54 zhangwei_david Exp $
 */
public class ThisEscape {
    private String name = null;
    final static public String test = "1";
    NioServerSocketChannelFactory
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {

            public void onEvent(Event event) {
                doSomething(event);
            }

        });
        name = "TEST";
    }

    /**
     * @param event
     */
    protected void doSomething(Event event) {
        System.out.println(name.toString());
    }
}


