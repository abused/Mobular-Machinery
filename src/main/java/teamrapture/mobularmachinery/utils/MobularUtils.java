package teamrapture.mobularmachinery.utils;

import net.minecraft.util.EnumFacing;

public class MobularUtils {

    public static final int MASK_ORIENTATION_HORIZONTAL = 0x3;

    public static EnumFacing getOrientationHoriz(int metadata) {
        return EnumFacing.VALUES[(metadata & MASK_ORIENTATION_HORIZONTAL)+2];
    }
}
