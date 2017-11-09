package nl.kingdev.enderpower.init;

import com.sun.org.apache.regexp.internal.RE;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.kingdev.enderpower.Reference;
import nl.kingdev.enderpower.block.BlockEnderGenerator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    private static List<Block> blocks = new ArrayList();

    //TODO: Blocks
    public static Block blockEnderGenerator = new BlockEnderGenerator();

    public static void register() {

        for(Field field : ModBlocks.class.getFields()) {
            try {
                Block block = (Block) field.get(Block.class);
                registerBlock(block);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    public static void registerBlock(Block block) {
        block.setCreativeTab(Reference.enderTab);
        blocks.add(block);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        System.out.println("[EnderPower] Registered Block " + block.getUnlocalizedName().substring(5));
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        for (Block b : blocks) {
            registerRender(b);
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, block.getUnlocalizedName().substring(5)), "inventory"));
        System.out.println("[EnderPower] Registered Render " + block.getUnlocalizedName().substring(5));
    }
}
