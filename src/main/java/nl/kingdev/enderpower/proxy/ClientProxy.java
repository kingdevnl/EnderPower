package nl.kingdev.enderpower.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nl.kingdev.enderpower.init.ModBlocks;
import nl.kingdev.enderpower.init.ModFluids;
import nl.kingdev.enderpower.init.ModItems;
import nl.kingdev.enderpower.util.FluidStateMapper;

public class ClientProxy extends CommonProxy {

    private void registerCustomFluidBlockRenderer(Fluid fluid){
        Block block = fluid.getBlock();
        System.out.println("FluidBlock " + block.getUnlocalizedName());

        Item item = Item.getItemFromBlock(block);
        FluidStateMapper mapper = new FluidStateMapper(fluid);
        ModelLoader.registerItemVariants(item);

        if(item == null) {
            System.out.println("Item = null!");
        }

        ModelLoader.setCustomMeshDefinition(item, mapper);
        ModelLoader.setCustomStateMapper(block, mapper);
    }

    @Override
    public void onPreInit(FMLPreInitializationEvent e) {

        ModItems.registerRenders();
        ModBlocks.registerRenders();

        this.registerCustomFluidBlockRenderer(ModFluids.enderFluid);
    }

    @Override
    public void onInit(FMLInitializationEvent e) {

    }

    @Override
    public void onPostInit(FMLPostInitializationEvent e) {

    }
}
