package teamrapture.mobularmachinery.entity;

import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.entity.friendly.EntityMechanicalChicken;

public class ModEntities {

	public static void init() {
		// Mech Chicken
		EntityRegistry.registerModEntity(getEntityResource("MechanicalChicken"), EntityMechanicalChicken.class,
				"MechanicalChicken", 0, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechanicalChicken.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalChicken.class, SpawnPlacementType.ON_GROUND);
		// Mech Cow
		// EntityRegistry.registerModEntity(getEntityResource("MechanicalCow"),
		// EntityMechanicalCow.class, "MechanicalCow", 1,
		// MobularMachinery.instance,
		// 80, 3, false, 0xffffff, 0xd9d9d9);

		// EntityRegistry.addSpawn(EntityMechanicalCow.class, 2, 1, 1,
		// EnumCreatureType.CREATURE, Biomes.SKY);

		// EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalCow.class,
		// SpawnPlacementType.ON_GROUND);

	}

	private static ResourceLocation getEntityResource(String entityName) {
		return new ResourceLocation(Info.MODID, entityName);
	}
}