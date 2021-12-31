
package cobblemod.item;

import net.minecraft.util.Identifier;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

public final class CobbletabItemGroup {
	public static ItemGroup get() {
		return ITEM_GROUP;
	}

	private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("cobblecultmod", "cobbletab")).icon(() -> {
		return new ItemStack(Items.COOKED_CHICKEN);
	}).build();
}
