package com.yourname.stellarrage.event.impl;

import com.yourname.stellarrage.event.Event;
import net.minecraft.client.MinecraftClient;

public class TickEvent extends Event {
    public final MinecraftClient mc;

    public TickEvent(MinecraftClient mc) {
        this.mc = mc;
    }
}
