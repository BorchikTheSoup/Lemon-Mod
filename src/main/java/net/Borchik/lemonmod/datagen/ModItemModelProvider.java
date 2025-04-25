package net.Borchik.lemonmod.datagen;

import net.Borchik.lemonmod.LemonMod;
import net.Borchik.lemonmod.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LemonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(Moditems.LEMON);
        simpleItem(Moditems.LEMON_SEEDS);
        simpleItem(Moditems.LEMON_SLICE);
        simpleItem(Moditems.ICE_CUBE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {

        return withExistingParent(item.getId().getPath(),

                ResourceLocation.tryParse("item/generated")).texture("layer0",

                ResourceLocation.tryBuild(LemonMod.MOD_ID, "item/" + item.getId().getPath()));


    }
}