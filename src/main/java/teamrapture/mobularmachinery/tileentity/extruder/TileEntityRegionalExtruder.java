package teamrapture.mobularmachinery.tileentity.extruder;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import teamrapture.mobularmachinery.blocks.extruder.OreList;
import teamrapture.mobularmachinery.registry.ModResources;
import teamrapture.mobularmachinery.tileentity.TileEntityInventory;
import teamrapture.mobularmachinery.utils.CustomEnergyStorage;

import javax.annotation.Nullable;

public class TileEntityRegionalExtruder extends TileEntityInventory {

    public CustomEnergyStorage storage = new CustomEnergyStorage(100000);
    public int workTime = 0;
    public boolean isMultiblock = false;
    public OreList oreList;
    public int i = 1;
    public ItemStack randomStack;

    public TileEntityRegionalExtruder() {
        super(10);
        oreList = new OreList();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        workTime = nbt.getInteger("WorkTime");
        isMultiblock = nbt.getBoolean("IsMultiblock");
        storage.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setInteger("WorkTime", workTime);
        nbt.setBoolean("IsMultiblock", isMultiblock);
        storage.writeToNBT(nbt);
        return super.writeToNBT(nbt);
    }

    @Override
    public void update() {
        super.update();
        randomStack = oreList.generateRandomOre();

        if (!world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
        }

        this.checkMultiblock();

        if(isMultiblock && canRun()) {
            if (storage.getEnergyStored() >= 800) {
                workTime++;
                if (workTime >= 50) {
                    workTime = 0;
                    if(!inventory.getStackInSlot(slotWithOre()).isEmpty() && inventory.getStackInSlot(slotWithOre()).getCount() < 64) {
                        inventory.getStackInSlot(slotWithOre()).grow(1);
                    }else if(inventory.getStackInSlot(slotWithOre()).isEmpty()) {
                        inventory.setStackInSlot(slotWithOre(), randomStack);
                    }
                    storage.extractEnergy(800, false);
                }
            } else if (workTime > 0) {
                workTime = 0;
            }
        }
    }

    public boolean canRun() {
        if (inventory.getStackInSlot(0).getItem() == ModResources.itemBossHeart) {
            if(slotWithOre() != 0) {
                return true;
            }
        }
        return false;
    }

    public int slotWithOre() {
        for (int i = 0; i < inventory.getSlots(); i++) {
            if (i != 0) {
                if(inventory.getStackInSlot(i) == randomStack && inventory.getStackInSlot(i).getCount() < 64) {
                    return  i;
                } else if(inventory.getStackInSlot(i) != randomStack && inventory.getStackInSlot(i).isEmpty()) {
                    return i;
                }
            }
        }

        return 0;
    }

    public boolean checkMultiblock() {
        BlockPos pos1 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        BlockPos pos2 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        BlockPos pos3 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        BlockPos pos4 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
        BlockPos pos5 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        BlockPos pos6 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());

        if(world.getBlockState(pos1).getBlock() == ModResources.blockExtruderFrame) {
            if(world.getBlockState(pos2).getBlock() == ModResources.blockExtruderFrame) {
                if(world.getBlockState(pos3).getBlock() == ModResources.blockExtruderFrame) {
                    if(world.getBlockState(pos4).getBlock() == ModResources.blockExtruderFrame) {
                        if(world.getBlockState(pos5).getBlock() == ModResources.blockExtruderTap || world.getBlockState(pos5).getBlock() == ModResources.blockExtruderInventory) {
                            if(world.getBlockState(pos6).getBlock() == ModResources.blockExtruderInventory || world.getBlockState(pos6).getBlock() == ModResources.blockExtruderTap) {
                                if (!isMultiblock) {
                                    isMultiblock = true;
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }

        if(isMultiblock) {
            isMultiblock = false;
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack) {
        return slot != 0 ? true : false;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY) {
            return (T) storage;
        }
        return super.getCapability(capability, facing);
    }
}
