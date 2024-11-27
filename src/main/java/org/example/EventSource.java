package org.example;

/**
 *
 * @author zhangwei_david
 * @version $Id: EventSource.java, v 0.1 2014年11月3日 上午9:38:40 zhangwei_david Exp $
 */
public class EventSource {

    public void registerListener(EventListener listener) {
        listener.onEvent(null);
    }

}
