package nl.kingdev.enderpower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nl.kingdev.enderpower.init.ModItems;

public class Reference {
    public static final String MOD_NAME = "EnderPower";
    public static final String MOD_ID = "enderpower";
    public static final String MOD_VER = "1.0";


    public static CreativeTabs enderTab = new CreativeTabs("EnderPower") {
        @Override
        public Item getTabIconItem() {
            return ModItems.itemEnder;
        }
    };

}
