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

import net.minecraft.client.option.KeyBinding;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

import cobblemod.client.GivechickenKeyBinding;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {
	public static final KeyBinding Givechicken_KEY = KeyBindingHelper.registerKeyBinding(new GivechickenKeyBinding());

	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
		});
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			if (((GivechickenKeyBinding) Givechicken_KEY).isPressed() && !((GivechickenKeyBinding) Givechicken_KEY).wasPressed()) {
				((GivechickenKeyBinding) Givechicken_KEY).keyPressed(client.player);
			}
			if (!((GivechickenKeyBinding) Givechicken_KEY).isPressed() && ((GivechickenKeyBinding) Givechicken_KEY).wasPressed()) {
				((GivechickenKeyBinding) Givechicken_KEY).keyReleased(client.player);
			} ;
		});
	}
}
