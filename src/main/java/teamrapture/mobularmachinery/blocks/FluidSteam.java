package teamrapture.mobularmachinery.blocks;

import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.utils.FluidBase;

public class FluidSteam extends FluidBase {

    public FluidSteam() {
        super("fluid_steam", Info.MODID);
        this.setGaseous(true);
        this.setLuminosity(1);
        this.setViscosity(600);
        this.setTemperature(900);
        this.setDensity(-1000);
    }
}
