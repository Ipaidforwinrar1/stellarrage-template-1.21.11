package com.yourname.stellarrage.event;

import java.util.*;

public final class EventBus {

    /**
     * Dispatch table:
     * EventClass -> listeners that should receive EXACTLY this event
     */
    private final Map<
            Class<? extends Event>,
            List<EventListener<? extends Event>>
            > listeners = new HashMap<>();

    /**
     * Cache of class hierarchies to avoid recomputing them.
     */
    private final Map<
            Class<? extends Event>,
            List<Class<? extends Event>>
            > hierarchyCache = new HashMap<>();

    /* ========================= REGISTRATION ========================= */

    public <T extends Event> void register(
            Class<T> type,
            EventListener<T> listener
    ) {
        for (Class<? extends Event> cls : getHierarchy(type)) {
            listeners
                    .computeIfAbsent(cls, k -> new ArrayList<>())
                    .add(listener);
        }
    }

    public <T extends Event> void unregister(
            Class<T> type,
            EventListener<T> listener
    ) {
        for (Class<? extends Event> cls : getHierarchy(type)) {
            List<EventListener<? extends Event>> list = listeners.get(cls);
            if (list != null) {
                list.remove(listener);
                if (list.isEmpty()) {
                    listeners.remove(cls);
                }
            }
        }
    }

    /* ========================= POSTING ========================= */

    @SuppressWarnings("unchecked")
    public <T extends Event> void post(T event) {
        List<EventListener<? extends Event>> list = listeners.get(event.getClass());
        if (list == null) return;

        // Copy to avoid ConcurrentModificationException
        for (EventListener<? extends Event> listener : List.copyOf(list)) {
            ((EventListener<T>) listener).onEvent(event);
            if (event.isCancelled()) {
                return;
            }
        }
    }

    /* ========================= INTERNAL ========================= */

    private List<Class<? extends Event>> getHierarchy(Class<? extends Event> type) {
        return hierarchyCache.computeIfAbsent(type, cls -> {
            List<Class<? extends Event>> result = new ArrayList<>();
            Class<?> current = cls;

            while (current != null && Event.class.isAssignableFrom(current)) {
                result.add((Class<? extends Event>) current);
                current = current.getSuperclass();
            }

            return result;
        });
    }
}
