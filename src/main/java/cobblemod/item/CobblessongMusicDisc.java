
package cobblemod.item;

import net.minecraft.util.Rarity;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

public class CobblessongMusicDisc extends MusicDiscItem {
	public CobblessongMusicDisc() {
		super(0, new SoundEvent(new Identifier("ambient.cave")),
				new FabricItemSettings().group(CobbletabItemGroup.get()).maxCount(1).rarity(Rarity.RARE));
	}

	@Environment(EnvType.CLIENT)
	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}
}
