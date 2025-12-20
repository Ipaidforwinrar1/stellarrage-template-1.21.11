package com.yourname.stellarrage.input;

import com.yourname.stellarrage.module.Module;
import com.yourname.stellarrage.StellarRageClient;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import java.util.HashSet;
import java.util.Set;

public class KeybindManager {

    // Set of keys currently considered "pressed" by our manager.
    // We track keys here to detect rising edges (key down events that weren't down last tick),
    // which prevents repeatedly toggling modules while a key is held.
    private final Set<Integer> pressedKeys = new HashSet<>();

    public void tick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        // Get the native window handle required by GLFW to query key states.
        long window = mc.getWindow().getHandle();

        for (Module module : StellarRageClient.CONTEXT.moduleManager.getModules()) {
            int key = module.getKey();
            // Skip modules without a bound key.
            if (key == GLFW.GLFW_KEY_UNKNOWN) continue;

            // Query whether the key is currently down according to GLFW.
            boolean down = GLFW.glfwGetKey(window, key) == GLFW.GLFW_PRESS;

            // Rising edge detection:
            // - If the key is down now, but we didn't mark it pressed last tick,
            //   this is a new key press -> toggle the module and mark the key pressed.
            if (down && !pressedKeys.contains(key)) {
                module.toggle();
                pressedKeys.add(key);
            }

            // If the key is not down, make sure we clear it from our pressed set
            // so a future press can be detected as a rising edge.
            if (!down) {
                pressedKeys.remove(key);
            }
        }
    }
}
