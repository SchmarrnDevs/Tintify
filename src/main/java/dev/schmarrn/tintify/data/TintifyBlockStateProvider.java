package dev.schmarrn.tintify.data;

import dev.schmarrn.tintify.common.TintedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.ModelIds;
import net.minecraft.data.client.model.Models;
import net.minecraft.data.client.model.Texture;
import net.minecraft.util.Identifier;


public class TintifyBlockStateProvider extends FabricModelProvider {

	public TintifyBlockStateProvider(FabricDataGenerator generator) {
		super(generator);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		for (Block block: TintedBlocks.TINTED_BLOCKS.values()) {
			//blockStateModelGenerator.registerSimpleCubeAll(block);
			Models.LEAVES.upload(block, Texture.all(new Identifier("tintify:block/tinted_glass")), blockStateModelGenerator.modelCollector);
			blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, ModelIds.getBlockModelId(block)));
		}

	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
	}
}
