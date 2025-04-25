package net.Borchik.lemonmod.datagen.loot;

import net.Borchik.lemonmod.block.ModBlocks;
import net.Borchik.lemonmod.block.custom.LemonCropBlock;
import net.Borchik.lemonmod.item.Moditems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }



    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LEMON_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemonCropBlock.AGE, 5));

        this.add(ModBlocks.LEMON_CROP.get(), createCropDrops(ModBlocks.LEMON_CROP.get(), Moditems.LEMON.get(),
                Moditems.LEMON_SEEDS.get(), lootitemcondition$builder));
    }

    protected LootTable.Builder createLapisLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
