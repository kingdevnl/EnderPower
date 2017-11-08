package nl.kingdev.enderpower.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.kingdev.enderpower.Reference;
import nl.kingdev.enderpower.items.ItemEnder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ModItems {


    private static List<Item> items = new ArrayList<Item>();

    public static Item itemEnder = new ItemEnder();

    public static void register() {

        for(Field field : ModItems.class.getFields()) {
            try {
                Item item = (Item) field.get(Item.class);
                registerItem(item);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    private static void registerItem(Item i) {
        items.add(i);
        GameRegistry.register(i);
        System.out.println("[EnderPower] Registered Item " + i.getUnlocalizedName().substring(5));
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        for (Item item : items) {
            if (!item.getHasSubtypes()) {
                registerRender(item);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item i) {
        ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, i.getUnlocalizedName().substring(5)), "inventory"));
        System.out.println("[EnderPower] Registered Render " + i.getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Item item, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, fileName), "inventory"));
        System.out.println("[EnderPower] Registered Render " + item.getRegistryName());
    }
}
