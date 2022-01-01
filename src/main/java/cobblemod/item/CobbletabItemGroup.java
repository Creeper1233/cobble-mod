
package cobblemod.item;

import net.minecraft.util.Identifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import cobblemod.CobblemodMod;

public final class CobbletabItemGroup {
	public static ItemGroup get() {
		return ITEM_GROUP;
	}

	private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("cobblemod", "cobbletab")).icon(() -> {
		return new ItemStack(CobblemodMod.Cobblessong_ITEM);
	}).build();
}
