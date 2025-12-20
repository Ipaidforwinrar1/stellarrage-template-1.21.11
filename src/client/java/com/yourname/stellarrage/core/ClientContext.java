package com.yourname.stellarrage.core;

import com.yourname.stellarrage.event.EventBus;
import com.yourname.stellarrage.hud.HudRenderer;
import com.yourname.stellarrage.input.KeybindManager;
import com.yourname.stellarrage.module.ModuleManager;

public final class ClientContext {
    public final EventBus eventBus;
    public final ModuleManager moduleManager;
    public final KeybindManager keybinds;
    public final HudRenderer hud;

    public ClientContext() {
        this.eventBus = new EventBus();
        this.moduleManager = new ModuleManager();
        this.keybinds = new KeybindManager();
        this.hud = new HudRenderer();
    }
}
