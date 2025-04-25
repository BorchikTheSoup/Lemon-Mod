package net.Borchik.lemonmod.item;

import net.Borchik.lemonmod.LemonMod;
import net.Borchik.lemonmod.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LemonMod.MOD_ID);

    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            ()-> new Item(new Item.Properties().food(ModFoods.LEMON)));

    public static final RegistryObject<Item> LEMON_SEEDS = ITEMS.register("lemon_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.LEMON_CROP.get() ,new Item.Properties()));

    public static final RegistryObject<Item> LEMON_SLICE = ITEMS.register("lemon_slice",
            ()-> new Item(new Item.Properties().food(ModFoods.LEMON_SLICE)));

    public static final RegistryObject<Item> EMPTY_CUP = ITEMS.register("empty_cup",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ICE_CUBE = ITEMS.register("ice_cube",
            ()-> new Item(new Item.Properties().food(ModFoods.ICE_CUBE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

