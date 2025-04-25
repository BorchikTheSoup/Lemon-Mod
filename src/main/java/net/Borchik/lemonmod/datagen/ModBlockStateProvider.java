package net.Borchik.lemonmod.datagen;

import net.Borchik.lemonmod.LemonMod;
import net.Borchik.lemonmod.block.ModBlocks;
import net.Borchik.lemonmod.block.custom.LemonCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LemonMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeLemonCrop((CropBlock) ModBlocks.LEMON_CROP.get(), "lemon_stage", "lemon_stage");
    }

    public void makeLemonCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lemonStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);

    }
    private ConfiguredModel[] lemonStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LemonCropBlock) block).getAgeProperty()),
                new ResourceLocation(LemonMod.MOD_ID, "block/" + textureName + state.getValue(((LemonCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models; }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}