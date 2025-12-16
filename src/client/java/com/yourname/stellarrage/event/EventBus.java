package com.yourname.stellarrage.event;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private final List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unregister(EventListener listener) {
        listeners.remove(listener);
    }

    public void post(Event event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
