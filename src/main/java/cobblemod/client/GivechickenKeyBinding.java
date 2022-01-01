
package cobblemod.client;

import org.lwjgl.glfw.GLFW;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.option.KeyBinding;

import java.util.Map;
import java.util.HashMap;

import cobblemod.procedures.Givechicken2Procedure;

public class GivechickenKeyBinding extends KeyBinding {
	public GivechickenKeyBinding() {
		super("key.mcreator.givechicken", GLFW.GLFW_KEY_J, "key.categories.gameplay");
	}

	public void keyPressed(PlayerEntity entity) {
		World world = entity.world;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			Givechicken2Procedure.executeProcedure($_dependencies);
		}
	}

	public void keyReleased(PlayerEntity entity) {
		World world = entity.world;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
	}
}
