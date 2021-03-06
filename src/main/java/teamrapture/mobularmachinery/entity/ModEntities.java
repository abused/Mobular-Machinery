package teamrapture.mobularmachinery.entity;

import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.entity.boss.EntityMechOctopusBoss;
import teamrapture.mobularmachinery.entity.boss.EntityMechSpiderBoss;
import teamrapture.mobularmachinery.entity.friendly.EntityMechanicalChicken;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalBlaze;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalCreeper;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalGhast;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalZombie;
import teamrapture.mobularmachinery.entity.monster.EntitySquiddyAttacker;
import teamrapture.mobularmachinery.entity.monster.EntitySquiddyAttackers;
import teamrapture.mobularmachinery.entity.nonliving.EntitySteamStream;
import teamrapture.mobularmachinery.entity.nonliving.EntityStringShot;

public class ModEntities {

	public static void init() {
		// Mech Chicken
		EntityRegistry.registerModEntity(getEntityResource("MechanicalChicken"), EntityMechanicalChicken.class,
				"MechanicalChicken", 0, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechanicalChicken.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalChicken.class, SpawnPlacementType.ON_GROUND);

		// OCTO Boss
		EntityRegistry.registerModEntity(getEntityResource("MechanicalOctopus"), EntityMechOctopusBoss.class,
				"MechanicalOctopus", 1, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechOctopusBoss.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechOctopusBoss.class, SpawnPlacementType.ON_GROUND);

		// Octo Minis
		EntityRegistry.registerModEntity(getEntityResource("MechanicalOctopusSquiddy"), EntitySquiddyAttackers.class,
				"MechanicalOctopusSquiddy", 3, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntitySquiddyAttackers.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntitySquiddyAttackers.class, SpawnPlacementType.ON_GROUND);

		// Mech Zombie
		EntityRegistry.registerModEntity(getEntityResource("MechanicalZombie"), EntityMechanicalZombie.class,
				"MechanicalZombie", 5, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechanicalZombie.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalZombie.class, SpawnPlacementType.ON_GROUND);
		// Mech Ghast
		EntityRegistry.registerModEntity(getEntityResource("MechanicalGhast"), EntityMechanicalGhast.class,
				"MechanicalGhast", 6, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechanicalGhast.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.HELL);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalGhast.class, SpawnPlacementType.ON_GROUND);
		// Spidy Boss
		EntityRegistry.registerModEntity(getEntityResource("MechanicalSpider"), EntityMechSpiderBoss.class,
				"MechanicalSpider", 9, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechSpiderBoss.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechSpiderBoss.class, SpawnPlacementType.ON_GROUND);
		// Creeper
		EntityRegistry.registerModEntity(getEntityResource("MechanicalCreeper"), EntityMechanicalCreeper.class,
				"MechanicalCreeper", 10, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechanicalCreeper.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalCreeper.class, SpawnPlacementType.ON_GROUND);
		// Blaze
		EntityRegistry.registerModEntity(getEntityResource("MechanicalBlaze"), EntityMechanicalBlaze.class,
				"MechanicalBlaze", 11, MobularMachinery.instance, 80, 3, false, 0xffffff, 0xd9d9d9);

		EntityRegistry.addSpawn(EntityMechanicalBlaze.class, 2, 1, 1, EnumCreatureType.AMBIENT, Biomes.PLAINS);

		EntitySpawnPlacementRegistry.setPlacementType(EntityMechanicalBlaze.class, SpawnPlacementType.ON_GROUND);

		// Mob Entity END
		// ---------------------------------------------------------------------------------------

		// Item Entities START
		// -----------------------------------------------------------------------------
		EntityRegistry.registerModEntity(getEntityResource("squiddyAttacker"), EntitySquiddyAttacker.class,
				"squiddyAttacker", 2, MobularMachinery.instance, 64, 2, true);

		EntityRegistry.registerModEntity(getEntityResource("steamStream"), EntitySteamStream.class, "steamStream", 4,
				MobularMachinery.instance, 64, 2, true);

		EntityRegistry.registerModEntity(getEntityResource("MechEgg"), EntitySteamStream.class, "MechEgg", 7,
				MobularMachinery.instance, 64, 2, true);
		EntityRegistry.registerModEntity(getEntityResource("StringShot"), EntityStringShot.class, "StringShot", 8,
				MobularMachinery.instance, 64, 2, true);
	}

	private static ResourceLocation getEntityResource(String entityName) {
		return new ResourceLocation(Info.MODID, entityName);
	}
}