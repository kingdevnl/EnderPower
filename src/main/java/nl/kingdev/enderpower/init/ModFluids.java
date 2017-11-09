package nl.kingdev.enderpower.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.kingdev.enderpower.fluids.BlockFluidFlowing;
import nl.kingdev.enderpower.fluids.FluidEP;

import java.util.Locale;

public class ModFluids {

    public static Fluid enderFluid;

    public static void register() {
        enderFluid = registerFluid("enderfluid", "block_enderfluid", EnumRarity.COMMON);
    }

    private static Fluid registerFluid(String fluidName, String fluidTextureName, EnumRarity rarity){
        Fluid fluid = new FluidEP(fluidName.toLowerCase(Locale.ROOT), fluidTextureName).setRarity(rarity);
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
        Block b = registerFluidBlock(fluid, Material.WATER, "block_enderfluid");
        fluid.setBlock(b);
        

        System.out.println("FluidBlock " + b.getUnlocalizedName());

        System.out.println("[EnderPower] registered fluid: " + fluid.getName());

        return FluidRegistry.getFluid(fluid.getName());
    }

    private static Block registerFluidBlock(Fluid fluid, Material material, String name){
        return new BlockFluidFlowing(fluid, material, name);
    }


}

