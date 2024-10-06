package net.rgy.lrn.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.rgy.lrn.Learning;
import net.rgy.lrn.block.ModBlocks;
import net.rgy.lrn.item.ModItems;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output, String locale) {
        super(output, Learning.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        //! Items
        add(ModItems.BISMUTH.asItem(), "Bismuth");
        add(ModItems.RAW_BISMUTH.asItem(), "Raw Bismuth");
        add(ModItems.CHISEL.asItem(), "Chisel");
        add(ModItems.RADISH.asItem(), "Radish");
        add(ModItems.BISMUTH_SUBSALICYLATE.asItem(), "Bismuth Subsalicylate");
        add(ModItems.FROSTFIRE_ICE.asItem(), "Frostfire Ice");
        add(ModItems.STARLIGHT_ASHES.asItem(), "Starlight Ashes");

        //! Blocks
        add(ModBlocks.BISMUTH_BLOCK.asItem(),"Bismuth Block");
        add(ModBlocks.MAGIC_BLOCK.asItem(),"Magic Block");
        add(ModBlocks.BISMUTH_ORE.asItem(),"Bismuth Ore");
        add(ModBlocks.DEEPSLATE_BISMUTH_ORE.asItem(),"Deepslate Bismuth Ore");

        //! Strings
        add("tooltip.lrn.chisel", "§9§l§oShift§r§r§r for more");
        add("tooltip.lrn.chisel_shift_down", "§6§lChisels§r§r §4§ostuff§r§r §d:))§r");
        add("tooltip.lrn.bismuth_subsalicylate", "§5§lAka §r§r§9§lPepto-Bismol§r§r");
        add("creativetab.lrn.bismuth_items","Bismuth Items Creative Tab");
        add("creativetab.lrn.bismuth_blocks","Bismuth Blocks Creative Tab");
    }
}
