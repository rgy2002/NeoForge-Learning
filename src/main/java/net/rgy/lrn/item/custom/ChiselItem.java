package net.rgy.lrn.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.rgy.lrn.block.ModBlocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.NETHERITE_BLOCK, Blocks.REINFORCED_DEEPSLATE,
                    Blocks.COAL_BLOCK, ModBlocks.BISMUTH_BLOCK.get()
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.lrn.chisel_shift_down"));
        }else{
            tooltipComponents.add(Component.translatable("tooltip.lrn.chisel"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block block = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(block)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(),CHISEL_MAP.get(block).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1,(ServerLevel) level,context.getPlayer(),item -> {
                    context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                });

                level.playSound(null,context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
