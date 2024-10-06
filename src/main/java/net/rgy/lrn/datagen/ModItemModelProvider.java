package net.rgy.lrn.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rgy.lrn.Learning;
import net.rgy.lrn.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, Learning.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_BISMUTH.get());
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.BISMUTH_SUBSALICYLATE.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.RADISH.get());
    }
}
