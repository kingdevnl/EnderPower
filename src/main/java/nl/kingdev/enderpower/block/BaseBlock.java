package nl.kingdev.enderpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import nl.kingdev.enderpower.Reference;

public class BaseBlock extends Block {

    public BaseBlock(String unlocalizedName) {
        super(Material.IRON);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
        this.setCreativeTab(Reference.enderTab);
        this.setHardness(3);
        this.isBlockContainer = true;
    }
}
