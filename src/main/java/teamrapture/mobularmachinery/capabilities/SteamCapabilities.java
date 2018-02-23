package teamrapture.mobularmachinery.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class SteamCapabilities {

	@CapabilityInject(IWeaponHolder.class)
	public static Capability<IWeaponHolder> STEAM = null;

	public static class CapabilitySteamHolder<T extends IWeaponHolder> implements IStorage<IWeaponHolder> {
		@Override
		public NBTBase writeNBT(Capability<IWeaponHolder> capability, IWeaponHolder instance, EnumFacing side) {
			return instance.serializeNBT();
		}

		@Override
		public void readNBT(Capability<IWeaponHolder> capability, IWeaponHolder instance, EnumFacing side,
				NBTBase nbt) {
			instance.deserializeNBT((NBTTagCompound) nbt);
		}
	}
}
