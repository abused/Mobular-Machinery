package teamrapture.mobularmachinery.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.capabilities.IWeaponHolder;
import teamrapture.mobularmachinery.capabilities.SteamCapabilities;
import teamrapture.mobularmachinery.utils.Utils;

public class ItemSteamGun extends ItemBase {
	EntityPlayer shooter;

	public ItemSteamGun(String name) {
		super(name);

	}

	public ItemSteamGun(String name, EntityPlayer shooter1) {
		super(name);
		shooter1 = shooter;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (worldIn.isRemote) {
			spawnLotsOparticles(playerIn);
			
			if (shooter instanceof EntityPlayer) {
				playerIn.motionX = 100;
				playerIn.motionY = 100;
				playerIn.motionZ = 100;
			}
		}

		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			IWeaponHolder holder = playerIn.getCapability(SteamCapabilities.STEAM, null);
			if (holder.getStoredSteam() >= 50) {

				pos = pos.offset(facing);

				if (!playerIn.canPlayerEdit(pos, facing, playerIn.getHeldItem(hand))) {
					return EnumActionResult.FAIL;
				} else {
					if (worldIn.isAirBlock(pos)) {
						spawnLotsOparticles(playerIn);
						worldIn.playSound(playerIn, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS,
								0.6F + itemRand.nextFloat() * 0.4F, itemRand.nextFloat() * 0.4F + 0.8F);
						worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState(), 11);
						holder.takeSteam(5, false);
					}
				}

			}
		}
		return EnumActionResult.SUCCESS;
	}
public void spawnLotsOparticles (EntityPlayer player){
	Utils.spawnParticles(player, EnumParticleTypes.CLOUD, 10, player.posX, player.posY, player.posZ, -2, -2, -2, 0.2);
}
	public boolean hasContainerItem(ItemStack itemStack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack stack = itemStack.copy();
		stack.setItemDamage(stack.getItemDamage() + 1);
		stack.setCount(1);
		return stack;
	}

}
