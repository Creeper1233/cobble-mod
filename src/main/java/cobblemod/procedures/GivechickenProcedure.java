package cobblemod.procedures;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class GivechickenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Givechicken!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Items.COOKED_CHICKEN);
			_setstack.setCount((int) 16);
			if (entity.world.isClient()) {
				if (((PlayerEntity) entity).inventory.getEmptySlot() != -1) {
					((PlayerEntity) entity).inventory.main.add(((PlayerEntity) entity).inventory.getEmptySlot(), _setstack);
					((PlayerEntity) entity).inventory.markDirty();
				}
			}
		}
	}
}
