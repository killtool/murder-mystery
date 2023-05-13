
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.murdermystery.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.murdermystery.item.DaggerItem;
import net.mcreator.murdermystery.MurderMysteryMod;

public class MurderMysteryModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MurderMysteryMod.MODID);
	public static final RegistryObject<Item> DAGGER = REGISTRY.register("dagger", () -> new DaggerItem());
}
