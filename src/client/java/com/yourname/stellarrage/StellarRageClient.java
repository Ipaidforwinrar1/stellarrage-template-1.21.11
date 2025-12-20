package com.yourname.stellarrage;

import com.yourname.stellarrage.core.ClientContext;
import com.yourname.stellarrage.event.EventBus;
import com.yourname.stellarrage.event.impl.TickEvent;
import com.yourname.stellarrage.hud.HudRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public final class StellarRageClient implements ClientModInitializer {

	public static ClientContext CONTEXT;
	public static EventBus EVENT_BUS;

	@Override
	public void onInitializeClient() {
		EVENT_BUS = new EventBus();
		CONTEXT = new ClientContext();

		CONTEXT.moduleManager.init();
		HudRenderer.init();

		ClientTickEvents.END_CLIENT_TICK.register(mc -> {
			if (mc.player == null || mc.world == null) return;

			CONTEXT.keybinds.tick();

			// 🔥 THIS is the new correct dispatch
			CONTEXT.eventBus.post(new TickEvent(mc));
		});
	}
}
