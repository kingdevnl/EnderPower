package nl.kingdev.enderpower.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nl.kingdev.enderpower.init.ModFluids;
import nl.kingdev.enderpower.init.ModItems;
import nl.kingdev.enderpower.util.FluidStateMapper;

public class ClientProxy extends CommonProxy {

    private void registerCustomFluidBlockRenderer(Fluid fluid){
        Block block = fluid.getBlock();
        Item item = Item.getItemFromBlock(block);
        FluidStateMapper mapper = new FluidStateMapper(fluid);
        ModelLoader.registerItemVariants(item);
        ModelLoader.setCustomMeshDefinition(item, mapper);
        ModelLoader.setCustomStateMapper(block, mapper);
    }

    @Override
    public void onPreInit(FMLPreInitializationEvent e) {
        ModItems.registerRenders();
        this.registerCustomFluidBlockRenderer(ModFluids.enderFluid);
    }

    @Override
    public void onInit(FMLInitializationEvent e) {

    }

    @Override
    public void onPostInit(FMLPostInitializationEvent e) {

    }
}
