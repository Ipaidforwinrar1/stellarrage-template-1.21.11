package com.yourname.stellarrage.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages module lifecycle only.
 *
 * Responsibilities:
 * - Hold modules
 * - Enable / disable modules
 * - Expose module list (HUD, keybinds)
 *
 * NON-responsibilities:
 * - Event dispatch
 * - Event registration
 * - Knowledge of event types
 */
public final class ModuleManager {

    private final List<Module> modules = new ArrayList<>();

    /**
     * Register all built-in modules here.
     * This is the ONLY place that knows concrete module classes.
     */
    public void init() {
        modules.add(new com.yourname.stellarrage.module.movement.AutoSprint());
        // modules.add(new Fly());
        // modules.add(new KillAura());
    }

    /**
     * Enable a module.
     * Module handles its own event registration.
     */
    public void enable(Module module) {
        if (module.isEnabled()) return;
        module.onEnable();
    }

    /**
     * Disable a module.
     * Module handles its own event unregistration.
     */
    public void disable(Module module) {
        if (!module.isEnabled()) return;
        module.onDisable();
    }

    /**
     * Toggle a module.
     */
    public void toggle(Module module) {
        if (module.isEnabled()) {
            disable(module);
        } else {
            enable(module);
        }
    }

    /**
     * Immutable view for HUD / input systems.
     */
    public List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    /**
     * Find a module by class.
     */
    public <T extends Module> T get(Class<T> type) {
        for (Module module : modules) {
            if (type.isInstance(module)) {
                return type.cast(module);
            }
        }
        return null;
    }
}
