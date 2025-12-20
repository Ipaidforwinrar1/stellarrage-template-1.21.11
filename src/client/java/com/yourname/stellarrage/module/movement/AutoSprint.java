package com.yourname.stellarrage.module.movement;

import com.yourname.stellarrage.StellarRageClient;
import com.yourname.stellarrage.event.EventListener;
import com.yourname.stellarrage.event.impl.TickEvent;
import com.yourname.stellarrage.module.Category;
import com.yourname.stellarrage.module.Module;
import org.lwjgl.glfw.GLFW;

public final class AutoSprint extends Module implements EventListener<TickEvent> {

    public AutoSprint() {
        super("AutoSprint", Category.MOVEMENT);
        setKey(GLFW.GLFW_KEY_V);
    }

    @Override
    protected void onEnable() {
        StellarRageClient.CONTEXT.eventBus.register(TickEvent.class, this);
        System.out.println("AutoSprint enabled");
    }

    @Override
    protected void onDisable() {
        StellarRageClient.CONTEXT.eventBus.unregister(TickEvent.class, this);

        if (mc.player != null) {
            mc.player.setSprinting(false);
        }

        System.out.println("AutoSprint disabled");

    }

    @Override
    public void onEvent(TickEvent event) {
        if (mc.player == null) return;
        System.out.println(Thread.currentThread().getName());

        mc.player.setSprinting(true);
        }
    }


