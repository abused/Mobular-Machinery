package teamrapture.mobularmachinery.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.registry.ModResources;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLinker extends Item {

    public ItemLinker() {
        super();
        this.setRegistryName("item_linker");
        this.setUnlocalizedName("item_linker");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        IBlockState state = world.getBlockState(pos);
        NBTTagCompound tag = stack.getTagCompound();
        if(!world.isRemote) {

            if (tag == null) {
                tag = new NBTTagCompound();
            }

            if (player.isSneaking()) {
                if (tag != null) {
                    if (state.getBlock() == ModResources.blockWaterVaporizer) {
                        tag.setInteger("x", pos.getX());
                        tag.setInteger("y", pos.getY());
                        tag.setInteger("z", pos.getZ());
                        tag.setBoolean("hasCoords", true);
                        player.sendMessage(new TextComponentString("Saved tile position!"));
                    } else {
                        if (tag.hasKey("x") && tag.hasKey("y") && tag.hasKey("z")) {
                            tag.removeTag("x");
                            tag.removeTag("y");
                            tag.removeTag("z");
                            tag.setBoolean("hasCoords", false);
                            player.sendMessage(new TextComponentString("Removed tile position!"));
                        }
                        return EnumActionResult.FAIL;
                    }
                }
            }
        }

        stack.setTagCompound(tag);
        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag != null) {
            if (tag.hasKey("x") && tag.hasKey("y") && tag.hasKey("z")) {
                tooltip.add("The following coords have been saved:");
                tooltip.add("X: " + tag.getInteger("x"));
                tooltip.add("Y: " + tag.getInteger("y"));
                tooltip.add("Z: " + tag.getInteger("z"));
            } else {
                tooltip.add("The following coords have been saved:");
                tooltip.add("X: Not yet set");
                tooltip.add("Y: Not yet set");
                tooltip.add("Z: Not yet set");
            }
        }
    }
}
