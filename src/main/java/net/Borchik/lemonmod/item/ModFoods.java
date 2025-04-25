package net.Borchik.lemonmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties LEMON = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.5f)
            .effect(()-> new MobEffectInstance(MobEffects.LUCK, 40, 1), 1)
            .build();

    public static final FoodProperties LEMON_SLICE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.2f)
            .fast()
            .effect(()-> new MobEffectInstance(MobEffects.LUCK, 20, 1), 0.5f)
            .build();

    public static final FoodProperties ICE_CUBE = new FoodProperties.Builder()
            .nutrition(0)
            .saturationMod(0f)
            .build();
}
