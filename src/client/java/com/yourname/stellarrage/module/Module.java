package com.yourname.stellarrage.module;

import org.lwjgl.glfw.GLFW;
import com.yourname.stellarrage.event.Event;
import com.yourname.stellarrage.event.EventListener;

/**
 * Base class for all modules.
 * Modules react to events via the EventBus.
 */
public abstract class Module implements EventListener {

    protected final String name;
    protected final Category category;
    private boolean enabled;
    private int key = GLFW.GLFW_KEY_UNKNOWN;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable();
         else onDisable();
    }

    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Called once when the module is enabled.
     */
    protected void onEnable() {}

    /**
     * Called once when the module is disabled.
     */
    protected void onDisable() {}

    /**
     * Called for every event posted to the EventBus
     * while this module is registered.
     */
    @Override
    public void onEvent(Event event) {
        // overridden by subclasses
    }
}
