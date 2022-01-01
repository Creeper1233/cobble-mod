
package cobblemod.item;

import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.entity.EquipmentSlot;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

public class Cobble_ArmorArmorArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[]{2, 7, 9, 2};
	public static final Item HELMET = new ArmorItem(new Cobble_ArmorArmorArmorMaterial(), EquipmentSlot.HEAD,
			new Item.Settings().group(CobbletabItemGroup.get()));
	public static final Item CHESTPLATE = new ArmorItem(new Cobble_ArmorArmorArmorMaterial(), EquipmentSlot.CHEST,
			new Item.Settings().group(CobbletabItemGroup.get()));
	public static final Item LEGGINGS = new ArmorItem(new Cobble_ArmorArmorArmorMaterial(), EquipmentSlot.LEGS,
			new Item.Settings().group(CobbletabItemGroup.get()));
	public static final Item BOOTS = new ArmorItem(new Cobble_ArmorArmorArmorMaterial(), EquipmentSlot.FEET,
			new Item.Settings().group(CobbletabItemGroup.get()));

	public int getDurability(EquipmentSlot equipmentSlot_1) {
		return BASE_DURABILITY[equipmentSlot_1.getEntitySlotId()] * 30;
	}

	public int getProtectionAmount(EquipmentSlot equipmentSlot_1) {
		return PROTECTION_VALUES[equipmentSlot_1.getEntitySlotId()];
	}

	public int getEnchantability() {
		return 18;
	}

	public SoundEvent getEquipSound() {
		return new SoundEvent(new Identifier("block.glass.break"));
	}

	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.COBBLESTONE);
	}

	@Environment(EnvType.CLIENT)
	public String getName() {
		return "cobble_armor";
	}

	public float getToughness() {
		return 3F;
	}

	public float getKnockbackResistance() {
		return 0.3f;
	}
}
