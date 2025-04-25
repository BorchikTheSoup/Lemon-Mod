package net.Borchik.lemonmod.item;

import net.Borchik.lemonmod.LemonMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LemonMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LEMON_TAB = CREATIVE_MODE_TABS.register("lemon_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.LEMON.get()))
                    .title(Component.translatable("creativetab.lemon_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.LEMON.get());
                        output.accept(Moditems.LEMON_SLICE.get());
                        output.accept(Moditems.ICE_CUBE.get());
                        output.accept(Moditems.LEMON_SEEDS.get());
                        output.accept(Moditems.EMPTY_CUP.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
