package teamrapture.mobularmachinery.registry;

import net.minecraftforge.common.config.Config;
import teamrapture.mobularmachinery.Info;

@Config(modid = Info.MODID, category = "options")
@Config.LangKey(Info.MODID + ".config.title")
public class ConfigHandler {

	@Config.Comment("Max Amount of Steam in Tank")
	public static int steamMaxAmount = 30000;
	

}
