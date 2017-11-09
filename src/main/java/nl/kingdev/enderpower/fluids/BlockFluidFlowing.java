package nl.kingdev.enderpower.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.kingdev.enderpower.Reference;
import nl.kingdev.enderpower.init.ItemBlockBase;

public class BlockFluidFlowing extends BlockFluidClassic {

    private final String name;

    public BlockFluidFlowing(Fluid fluid, Material material, String unlocalizedName){
        super(fluid, material);
        this.name = unlocalizedName;
        this.displacements.put(this, false);

        this.register();
    }
    private void register(){
        setUnlocalizedName(Reference.MOD_ID+"."+name);

        setRegistryName(Reference.MOD_ID, name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(this.getRegistryName()));

    }
    protected ItemBlockBase getItemBlock(){
        return new ItemBlockBase(this);
    }

}
