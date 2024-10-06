package net.rgy.lrn.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rgy.lrn.Learning;
import net.rgy.lrn.item.ModItems;
import net.rgy.lrn.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Learning.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
            tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                    .add(ModItems.RAW_BISMUTH.get())
                    .add(ModItems.BISMUTH.get())
                    .addTag(ItemTags.COALS)
                    .addTag(ItemTags.LOGS)
                    .addTag(ItemTags.PLANKS);
    }
}
