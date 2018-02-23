package teamrapture.mobularmachinery.capabilities;

import net.minecraft.nbt.NBTTagCompound;

public interface IWeaponHolder {

	long getStoredSteam();

	long getCapacity();

	void deserializeNBT(NBTTagCompound nbt);

	long giveSteam(long power, boolean simulated);

	long takeSteam(long power, boolean simulated);

	NBTTagCompound serializeNBT();
}
