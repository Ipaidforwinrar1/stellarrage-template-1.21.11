package com.yourname.stellarrage;

import com.yourname.stellarrage.event.EventBus;
import com.yourname.stellarrage.event.impl.TickEvent;
import com.yourname.stellarrage.input.KeybindManager;
import com.yourname.stellarrage.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import com.yourname.stellarrage.hud.HudRenderer;

public class StellarRageClient implements ClientModInitializer {

	public static  EventBus EVENT_BUS;
	public static ModuleManager MODULE_MANAGER;
	public static KeybindManager KEYBIND_MANAGER;

	@Override
	public void onInitializeClient() {

		EVENT_BUS = new EventBus();
		MODULE_MANAGER = new ModuleManager(EVENT_BUS);
		MODULE_MANAGER.init();
		HudRenderer.init();

		KEYBIND_MANAGER = new KeybindManager();

		ClientTickEvents.END_CLIENT_TICK.register(mc -> {
			if (mc.player == null || mc.world == null) return;

			KEYBIND_MANAGER.tick();
			MODULE_MANAGER.post(new TickEvent(mc));
		});
	}
}
