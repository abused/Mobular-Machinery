package teamrapture.mobularmachinery.capabilities.steamstorage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import teamrapture.mobularmachinery.capabilities.SteamCapabilities;

public class SteamStorageProvider implements ICapabilitySerializable<NBTTagCompound> {

	private final SteamStorage container;

	public SteamStorageProvider(SteamStorage container) {

		this.container = container;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		return capability == SteamCapabilities.STEAM;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

		if (capability == SteamCapabilities.STEAM) return (T) this.container;

		return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {

		return this.container.serializeNBT();
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {

		this.container.deserializeNBT(nbt);
	}
}
