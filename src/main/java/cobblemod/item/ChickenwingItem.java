
package cobblemod.item;

import net.minecraft.util.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.FoodComponent;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ChickenwingItem extends Item {
	public ChickenwingItem() {
		super(new FabricItemSettings().group(CobbletabItemGroup.get()).maxCount(16)
				.food((new FoodComponent.Builder()).hunger(10).saturationModifier(0.3f)

						.meat().build()));
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 40;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}
}
