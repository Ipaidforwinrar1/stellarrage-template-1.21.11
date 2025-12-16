package com.yourname.stellarrage.mixin.client;

import com.yourname.stellarrage.StellarRage;
import com.yourname.stellarrage.StellarRageClient;
import com.yourname.stellarrage.event.impl.TickEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ExampleClientMixin {
	@Inject(method = "tick", at = @At("TAIL"))
	private void onTick(CallbackInfo ci) {
		// This method will be called at the end of the MinecraftClient tick method.
		MinecraftClient mc = (MinecraftClient) ((Object) this);
		// You can add your custom logic here.
		if (mc.player == null) return;

		StellarRageClient.EVENT_BUS.post(new TickEvent(mc));
		System.out.println("Client tick event posted");
	}
}