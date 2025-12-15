package com.yourname.stellarrage.module;

public abstract class Module {
    private final String name;
    private boolean enabled;

    public Module(String name) {
        this.name = name;
        this.enabled = false;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void toggle() {
        enabled = !enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void setEnabled(boolean value) {
        if (enabled != value) {
            toggle();
        }
    }

    // Lifecycle hooks
    protected void onEnable() {}
    protected void onDisable() {}

    // Called every client tick when enabled
    public void onTick() {}
}
