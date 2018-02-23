package teamrapture.mobularmachinery.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.capabilities.IWeaponHolder;
import teamrapture.mobularmachinery.capabilities.SteamCapabilities;

public class ItemSteamCreative extends ItemBase {

	public ItemSteamCreative(String name) {
		super(name);
		this.setMaxStackSize(1);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BLOCK;

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (!worldIn.isRemote) {
			IWeaponHolder steamTank = playerIn.getCapability(SteamCapabilities.STEAM, null);
			if (steamTank != null){
				steamTank.giveSteam(5000, false);
				playerIn.sendStatusMessage(new TextComponentTranslation("message.mobularmachinery.steam_tank_checker",
						steamTank.getCapacity(), steamTank.getStoredSteam()), true);
			
			}else
				return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(hand));
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			IWeaponHolder holder = player.getCapability(SteamCapabilities.STEAM, null);
			holder.giveSteam(5000, false);
			//stack.shrink(1);

		}
		return stack;
	}
}
