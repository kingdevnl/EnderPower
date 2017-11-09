package nl.kingdev.enderpower;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nl.kingdev.enderpower.init.ModBlocks;
import nl.kingdev.enderpower.init.ModFluids;
import nl.kingdev.enderpower.init.ModItems;
import nl.kingdev.enderpower.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VER)
public class EnderPower {


    @SidedProxy(clientSide = "nl.kingdev.enderpower.proxy.ClientProxy", serverSide = "nl.kingdev.enderpower.proxy.ServerProxy")
    public static CommonProxy proxy;

    static{

        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e) {
        System.out.println("EnderPower.onPreInit");
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();

        proxy.onPreInit(e);
    }
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e) {
        System.out.println("EnderPower.init");
        proxy.onInit(e);
    }
    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent e) {
        System.out.println("EnderPower.postInit");
        proxy.onPostInit(e);
    }
}
