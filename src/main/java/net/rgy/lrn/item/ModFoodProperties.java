package net.rgy.lrn.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder().nutrition(3).saturationModifier(2.5f).alwaysEdible().fast().effect(()-> new MobEffectInstance(MobEffects.DARKNESS,200), 0.1f).build();
    public static final FoodProperties BISMUTH_SUBSALICYLATE = new FoodProperties.Builder().nutrition(4).saturationModifier(3.5f).alwaysEdible().effect(()-> new MobEffectInstance(MobEffects.SATURATION,150), 0.857f).build();
}
