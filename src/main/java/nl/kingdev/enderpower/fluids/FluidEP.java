package nl.kingdev.enderpower.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import nl.kingdev.enderpower.Reference;

public class FluidEP extends Fluid {

    public FluidEP(String fluidName, String textureName){
        super(fluidName, new ResourceLocation(Reference.MOD_ID, "blocks/"+textureName+"_still"), new ResourceLocation(Reference.MOD_ID, "blocks/"+textureName+"_flowing"));
    }

    @Override
    public String getUnlocalizedName(){
        return "fluid."+ Reference.MOD_ID+"."+this.unlocalizedName;
    }
}
