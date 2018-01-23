package teamrapture.mobularmachinery.entity;

import net.minecraft.util.ResourceLocation;

public class ModEntities {
	public static void init() {
		/*
		EntityRegistry.registerModEntity(getEntityResource("MechanicalChicken"), EntityFallenAngel.class, "MechanicalChicken", 0,
				MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechanicalChicken.class, 2, 1, 1, EnumCreatureType.CREATURE, Biomes.SKY);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalChicken.class, SpawnPlacementType.ON_GROUND);
		// Demon
		EntityRegistry.registerModEntity(getEntityResource("MechanicalCow"), EntityDemon.class, "MechanicalCow", 1, MobularMachinery.instance,
				80, 3, false, 0xffffff, 0xd9d9d9);

	//	EntityRegistry.addSpawn(EntityMechanicalCow.class, 2, 1, 1, EnumCreatureType.CREATURE, Biomes.SKY);

		//EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalCow.class, SpawnPlacementType.ON_GROUND);

	
*/}
	
	private static ResourceLocation getEntityResource(String entityName) {
		return new ResourceLocation("mobularmachinery", entityName);
	}


}