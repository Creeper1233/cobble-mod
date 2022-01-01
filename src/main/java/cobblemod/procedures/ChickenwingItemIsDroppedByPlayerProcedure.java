package cobblemod.procedures;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;

public class ChickenwingItemIsDroppedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ChickenwingItemIsDroppedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.damage(DamageSource.GENERIC, (float) 4F);
	}
}
