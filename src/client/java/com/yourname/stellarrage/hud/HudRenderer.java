package com.yourname.stellarrage.hud;

import com.yourname.stellarrage.StellarRageClient;
import com.yourname.stellarrage.module.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public class HudRenderer {

    public static void init() {
        HudRenderCallback.EVENT.register(HudRenderer::render);
    }

    private static void render(DrawContext context, RenderTickCounter tickCounter ) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        int x = 5;
        int y = 5;
        int lineHeight = 10;

        for (Module module : StellarRageClient.MODULE_MANAGER.getModules()) {
            if (!module.isEnabled()) continue;

            context.drawText(
                    mc.textRenderer,
                    module.getName(),
                    x,
                    y,
                    0xFFFFFFFF,
                    true
            );

            y += lineHeight;
        }
    }
}
