/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and the proxy files
 *    and they won't get overwritten. If you change your mod package or modid, you
 *    need to apply these changes to this file MANUALLY.
 *
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package cobblemod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.api.ModInitializer;

import cobblemod.procedures.Diamond1in100Procedure;

import cobblemod.item.CobbletabItemGroup;
import cobblemod.item.CobblessongMusicDisc;
import cobblemod.item.Cobble_ArmorArmorArmorMaterial;
import cobblemod.item.CobbleSwordTool;
import cobblemod.item.CobbleShovelTool;
import cobblemod.item.CobblePickaxeTool;
import cobblemod.item.CobbleHoeTool;
import cobblemod.item.CobbleAxeTool;

public class CobblemodMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Item Cobblessong_ITEM = Registry.register(Registry.ITEM, id("cobblessong"), new CobblessongMusicDisc());
	public static final ItemGroup Cobbletab = CobbletabItemGroup.get();
	public static final Item Cobble_ArmorArmor_HELMET = Registry.register(Registry.ITEM, id("cobble_armor_armor_helmet"),
			Cobble_ArmorArmorArmorMaterial.HELMET);
	public static final Item Cobble_ArmorArmor_CHESTPLATE = Registry.register(Registry.ITEM, id("cobble_armor_armor_chestplate"),
			Cobble_ArmorArmorArmorMaterial.CHESTPLATE);
	public static final Item Cobble_ArmorArmor_LEGGINGS = Registry.register(Registry.ITEM, id("cobble_armor_armor_leggings"),
			Cobble_ArmorArmorArmorMaterial.LEGGINGS);
	public static final Item Cobble_ArmorArmor_BOOTS = Registry.register(Registry.ITEM, id("cobble_armor_armor_boots"),
			Cobble_ArmorArmorArmorMaterial.BOOTS);
	public static final Item CobblePickaxe_ITEM = Registry.register(Registry.ITEM, id("cobble_pickaxe"), CobblePickaxeTool.INSTANCE);
	public static final Item CobbleAxe_ITEM = Registry.register(Registry.ITEM, id("cobble_axe"), CobbleAxeTool.INSTANCE);
	public static final Item CobbleSword_ITEM = Registry.register(Registry.ITEM, id("cobble_sword"), CobbleSwordTool.INSTANCE);
	public static final Item CobbleShovel_ITEM = Registry.register(Registry.ITEM, id("cobble_shovel"), CobbleShovelTool.INSTANCE);
	public static final Item CobbleHoe_ITEM = Registry.register(Registry.ITEM, id("cobble_hoe"), CobbleHoeTool.INSTANCE);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing CobblemodMod");
		new Diamond1in100Procedure();
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
		});
	}

	public static final Identifier id(String s) {
		return new Identifier("cobblemod", s);
	}
}
