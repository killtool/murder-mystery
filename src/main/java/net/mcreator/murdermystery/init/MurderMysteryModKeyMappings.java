
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.murdermystery.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.murdermystery.network.InvisMessage;
import net.mcreator.murdermystery.MurderMysteryMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MurderMysteryModKeyMappings {
	public static final KeyMapping INVIS = new KeyMapping("key.murder_mystery.invis", GLFW.GLFW_KEY_I, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MurderMysteryMod.PACKET_HANDLER.sendToServer(new InvisMessage(0, 0));
				InvisMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				INVIS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - INVIS_LASTPRESS);
				MurderMysteryMod.PACKET_HANDLER.sendToServer(new InvisMessage(1, dt));
				InvisMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long INVIS_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(INVIS);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				INVIS.consumeClick();
			}
		}
	}
}
