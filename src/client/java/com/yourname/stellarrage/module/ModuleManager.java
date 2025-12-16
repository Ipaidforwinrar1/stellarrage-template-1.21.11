package com.yourname.stellarrage.module;

import com.yourname.stellarrage.event.Event;
import com.yourname.stellarrage.event.EventBus;
import com.yourname.stellarrage.module.movement.AutoSprint;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages all modules and forwards events to them.
 */
public class ModuleManager {

    private final List<Module> modules = new ArrayList<>();
    private final EventBus eventBus;

    public ModuleManager(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    /**
     * Register all modules here.
     */
    public void init() {
        add(new AutoSprint());
    }

    public void add(Module module) {
        modules.add(module);
        eventBus.register(module);
    }

    public List<Module> getModules() {
        return modules;
    }

    /**
     * Forward events into the EventBus.
     */
    public void post(Event event) {
        eventBus.post(event);
    }
}
