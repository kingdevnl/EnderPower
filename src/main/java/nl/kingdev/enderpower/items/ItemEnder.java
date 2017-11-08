package nl.kingdev.enderpower.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import nl.kingdev.enderpower.Reference;

public class ItemEnder extends Item {

    public ItemEnder() {
        this.setUnlocalizedName("ender");
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "ender"));
        this.setMaxStackSize(16);
    }

}
