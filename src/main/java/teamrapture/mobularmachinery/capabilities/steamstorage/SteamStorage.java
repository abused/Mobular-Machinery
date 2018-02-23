package teamrapture.mobularmachinery.capabilities.steamstorage;

import net.minecraft.nbt.NBTTagCompound;
import teamrapture.mobularmachinery.capabilities.IWeaponHolder;

public class SteamStorage implements IWeaponHolder {

	private long stored;

	private long capacity;

	private long inputRate;

	private long outputRate;

	public SteamStorage() {
		this(30000, 300, 300);
	}

	private SteamStorage(long capacity, long input, long output) {
		this.capacity = capacity;
		this.inputRate = input;
		this.outputRate = output;
	}

	public static SteamStorage create(long capacity, long input, long output) {
		return new SteamStorage(capacity, input, output);
	}

	public static SteamStorage createFromNBT(NBTTagCompound tagCompound) {
		return new SteamStorage(tagCompound);
	}

	private SteamStorage(NBTTagCompound dataTag) {
		this();
		this.deserializeNBT(dataTag);
	}

	@Override
	public long getStoredSteam() {

		return this.stored;
	}

	@Override
	public long giveSteam(long steam, boolean simulated) {

		final long acceptedSteam = Math.min(this.getCapacity() - this.stored, Math.min(this.getInputRate(), steam));

		if (!simulated) this.stored += acceptedSteam;

		return acceptedSteam;
	}

	@Override
	public long takeSteam(long eve, boolean simulated) {

		final long removedPower = Math.min(this.stored, Math.min(this.getOutputRate(), eve));

		if (!simulated) this.stored -= removedPower;

		return removedPower;
	}

	@Override
	public long getCapacity() {

		return this.capacity;
	}

	@Override
	public NBTTagCompound serializeNBT() {

		final NBTTagCompound dataTag = new NBTTagCompound();
		dataTag.setLong("SteamPower", this.stored);
		dataTag.setLong("SteamInput", this.inputRate);
		dataTag.setLong("SteamOutput", this.outputRate);

		return dataTag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {

		this.stored = nbt.getLong("SteamPower");

		if (nbt.hasKey("SteamInput")) this.inputRate = nbt.getLong("SteamInput");

		if (nbt.hasKey("SteamOutput")) this.outputRate = nbt.getLong("SteamOutput");

		if (this.stored > this.getCapacity()) this.stored = this.getCapacity();
	}

	public SteamStorage setCapacity(long capacity) {

		this.capacity = capacity;

		if (this.stored > capacity) this.stored = capacity;

		return this;
	}

	public long getInputRate() {

		return this.inputRate;
	}

	public SteamStorage setInputRate(long rate) {

		this.inputRate = rate;
		return this;
	}

	public long getOutputRate() {

		return this.outputRate;
	}

	public SteamStorage setOutputRate(long rate) {
		this.outputRate = rate;
		return this;
	}

	public SteamStorage setTransferRate(long rate) {

		this.setInputRate(rate);
		this.setOutputRate(rate);
		return this;
	}
}
