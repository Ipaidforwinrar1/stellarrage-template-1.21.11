package com.yourname.stellarrage.module.movement;

import com.yourname.stellarrage.event.Event;
import com.yourname.stellarrage.event.impl.TickEvent;
import com.yourname.stellarrage.module.Category;
import com.yourname.stellarrage.module.Module;
import org.lwjgl.glfw.GLFW;

public class AutoSprint extends Module {

    public AutoSprint() {
        super("AutoSprint", Category.MOVEMENT);
        setKey(GLFW.GLFW_KEY_V);
    }

    @Override
    public void onEvent(Event event) {
        System.out.println("AutoSprint tick event received");
        if (!isEnabled()) return;
        if (!(event instanceof TickEvent tick)) return;
        // Implement auto-sprint logic here using tick.mc
        var mc = tick.mc;
        if (mc.player == null) return;
        // Example logic: Automatically start sprinting when moving forward
        if (mc.options.forwardKey.isPressed()
            && !mc.player.isSneaking()
            && !mc.player.isUsingItem()
            && mc.player.getHungerManager().getFoodLevel() > 6) {

            mc.player.setSprinting(true);
        }
    }

    @Override
    protected void onEnable() {
        System.out.println("AutoSprint enabled");
    }

    @Override
    protected void onDisable() {
        System.out.println("AutoSprint disabled");
    }
}
