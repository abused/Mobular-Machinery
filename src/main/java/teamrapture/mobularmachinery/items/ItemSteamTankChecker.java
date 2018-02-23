package teamrapture.mobularmachinery.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.capabilities.IWeaponHolder;
import teamrapture.mobularmachinery.capabilities.SteamCapabilities;

public class ItemSteamTankChecker extends ItemBase {

	public ItemSteamTankChecker(String name) {
		super(name);
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (!worldIn.isRemote) {
			//playerIn.attackEntityFrom(DamageSource.GENERIC, 0.1F);
			IWeaponHolder steamTank = playerIn.getCapability(SteamCapabilities.STEAM, null);
			if (steamTank != null)
				playerIn.sendStatusMessage(new TextComponentTranslation("message.mobularmachinery.steam_tank_checker",
						steamTank.getCapacity(), steamTank.getStoredSteam()), true);
			else
				return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(hand));
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}
}
