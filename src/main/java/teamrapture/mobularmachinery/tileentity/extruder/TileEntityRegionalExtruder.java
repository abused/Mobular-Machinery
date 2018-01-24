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
import net.minecraftforge.oredict.OreDictionary;
import teamrapture.mobularmachinery.blocks.extruder.OreList;
import teamrapture.mobularmachinery.registry.ModResources;
import teamrapture.mobularmachinery.tileentity.TileEntityInventory;
import teamrapture.mobularmachinery.utils.CustomEnergyStorage;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileEntityRegionalExtruder extends TileEntityInventory {

    public CustomEnergyStorage storage = new CustomEnergyStorage(100000);
    public int workTime = 0;
    public boolean isMultiblock = false;
    public OreList oreList;

    public TileEntityRegionalExtruder() {
        super(1);
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

        if (!world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
        }

        this.checkMultiblock();

        if(isMultiblock && canRun()) {
            if (storage.getEnergyStored() >= 800) {
                workTime++;
                if (workTime >= 60) {
                    workTime = 0;
                    if(!world.isRemote) {
                        world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY() + 2, pos.getZ(), oreList.generateRandomOre()));
                    }
                    storage.extractEnergy(800, false);
                }
            } else if (workTime > 0) {
                workTime = 0;
            }
        }
    }

    public boolean canRun() {
        if(inventory.getStackInSlot(0).getItem() == Items.DIAMOND) {
            return true;
        }
        return false;
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
                        if(world.getBlockState(pos5).getBlock() == ModResources.blockExtruderFrame) {
                            if(world.getBlockState(pos6).getBlock() == ModResources.blockExtruderTap) {
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
