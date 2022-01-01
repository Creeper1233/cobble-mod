
package cobblemod.item;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import java.util.Map;
import java.util.HashMap;

import cobblemod.procedures.Diamond1in100Procedure;

public class CobbleShovelTool {
	public static final ToolMaterial COBBLESHOVEL_TOOL_MATERIAL = new ToolMaterial() {
		@Override
		public int getDurability() {
			return 4096;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 166F;
		}

		@Override
		public float getAttackDamage() {
			return 1F;
		}

		@Override
		public int getMiningLevel() {
			return 5;
		}

		@Override
		public int getEnchantability() {
			return 26;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(Items.COOKED_CHICKEN);
		}
	};
	public static final Item INSTANCE = new ShovelItem(COBBLESHOVEL_TOOL_MATERIAL, 0, (float) -2.4000000000000001,
			(new FabricItemSettings().group(CobbletabItemGroup.get()))) {
		@Override
		public boolean postMine(ItemStack itemstack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
			boolean retval = super.postMine(itemstack, world, blockstate, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				Diamond1in100Procedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	};
}
