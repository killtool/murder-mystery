package net.mcreator.murdermystery.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class DaggerLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.SPECTATOR);
	}
}
