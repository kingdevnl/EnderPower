package nl.kingdev.enderpower.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.kingdev.enderpower.fluids.FluidEP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ModFluids {


    private static List<Fluid> fluids = new ArrayList<Fluid>();
    private static List<IFluidBlock> fluidBlocks = new ArrayList<IFluidBlock>();
    private static HashMap<Fluid, Block> fluidBlockList = new HashMap<Fluid, Block>();

    public static Fluid enderFluid;

    public static void register() {
        enderFluid = registerFluid("enderfluid", "block_enderfluid", EnumRarity.COMMON);
    }

    private static Fluid registerFluid(String fluidName, String fluidTextureName, EnumRarity rarity){
        Fluid fluid = new FluidEP(fluidName.toLowerCase(Locale.ROOT), fluidTextureName).setRarity(rarity);
        FluidRegistry.registerFluid(fluid);

        FluidRegistry.addBucketForFluid(fluid);

        Block b = registerFluidBlock(fluid, Material.WATER, fluidName);
        fluidBlockList.put(fluid, b);
        System.out.println("[EnderPower] registered fluid: " + fluid.getName());

        return FluidRegistry.getFluid(fluid.getName());
    }

    private static Block registerFluidBlock(Fluid fluid, Material material, String name){
        return new BlockFluidClassic(fluid, material);
    }


}

