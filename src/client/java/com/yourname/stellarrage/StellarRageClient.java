package com.yourname.stellarrage;

import com.yourname.stellarrage.module.ModuleManager;
import com.yourname.stellarrage.module.movement.AutoSprint;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class StellarRageClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		AutoSprint sprint = new AutoSprint();
		sprint.setEnabled(true);
		ModuleManager.register(sprint);
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			// Call the ModuleManager's onTick method each tick
			ModuleManager.onKey();
			ModuleManager.onTick();
		});
	}
}