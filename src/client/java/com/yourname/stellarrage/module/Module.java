package com.yourname.stellarrage.module;

import net.minecraft.client.option.KeyBinding;

/**
 * Abstract base class for modules in the Stellar Rage system.
 * Modules can be enabled or disabled and provide lifecycle hooks for activation and deactivation.
 */
public abstract class Module {
    /** The name of the module. */
    private final String name;
    /** The category this module belongs to. */
    private final Category category;
    protected KeyBinding keybind;
    /** Whether the module is currently enabled. */
    private boolean enabled;

    /**
     * Constructs a new Module with the given name and category.
     * The module starts in a disabled state.
     *
     * @param name     the name of the module
     * @param category the category of the module
     */
    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        this.enabled = false;
    }

    /**
     * Gets the name of the module.
     *
     * @return the module name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the category of the module.
     *
     * @return the module category
     */
    public Category getCategory() {
        return category;
    }

    public KeyBinding getKeybind() {
        return keybind;
    }

    /**
     * Checks if the module is enabled.
     *
     * @return true if enabled, false otherwise
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Toggles the enabled state of the module.
     * Calls onEnable() if enabling, or onDisable() if disabling.
     */
    public void toggle() {
        enabled = !enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    /**
     * Sets the enabled state of the module.
     * If the state changes, it toggles the module accordingly.
     *
     * @param value the desired enabled state
     */
    public void setEnabled(boolean value) {
        if (enabled != value) {
            toggle();
        }
    }

    // Lifecycle hooks

    /**
     * Called when the module is enabled.
     * Subclasses can override to perform initialization.
     */
    protected void onEnable() {}

    /**
     * Called when the module is disabled.
     * Subclasses can override to perform cleanup.
     */
    protected void onDisable() {}

    /**
     * Called every client tick when the module is enabled.
     * Subclasses can override to implement per-tick logic.
     */
    public void onTick() {}
}
