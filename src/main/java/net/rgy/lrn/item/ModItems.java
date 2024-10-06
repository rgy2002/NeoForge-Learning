package net.rgy.lrn.item;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rgy.lrn.Learning;
import net.rgy.lrn.item.custom.ChiselItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Learning.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(256)));

    public static final DeferredItem<Item> BISMUTH_SUBSALICYLATE = ITEMS.register("bismuth_subsalicylate",
            () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(ModFoodProperties.BISMUTH_SUBSALICYLATE).stacksTo(16)){

                private static final int DRINK_DURATION = 50;

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.lrn.bismuth_subsalicylate"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }

                @Override
                public UseAnim getUseAnimation(ItemStack stack) {
                    return UseAnim.DRINK;
                }

                @Override
                public SoundEvent getDrinkingSound() {
                    return SoundEvents.HONEY_DRINK;
                }

                @Override
                public int getUseDuration(ItemStack stack, LivingEntity entity) {
                    return DRINK_DURATION;
                }

                @Override
                public SoundEvent getEatingSound() {
                    return SoundEvents.HONEY_DRINK;
                }
                @Override
                public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
                    super.finishUsingItem(stack, level, entityLiving);
                    if (stack.isEmpty()) {
                        return new ItemStack(Items.GLASS_BOTTLE);
                    } else {
                        if (entityLiving instanceof Player player && !player.hasInfiniteMaterials()) {
                            ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                            if (!player.getInventory().add(itemstack)) {
                                player.drop(itemstack, false);
                            }
                        }

                        return stack;
                    }
                }
            });

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
