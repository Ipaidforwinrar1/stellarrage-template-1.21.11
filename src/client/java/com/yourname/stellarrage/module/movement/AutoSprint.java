package com.yourname.stellarrage.module.movement;

import com.yourname.stellarrage.module.Module;
import com.yourname.stellarrage.module.Category;
import net.minecraft.client.MinecraftClient;

public class AutoSprint extends Module{

    public AutoSprint() {
        super("AutoSprint", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.player.setSprinting(true);
        }
    }

    public void onEnable() {
        // Code to execute when the module is enabled
        System.out.println("AutoSprint enabled");
    }
}
