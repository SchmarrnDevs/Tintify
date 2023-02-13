package dev.schmarrn.tintify.data;

import dev.schmarrn.tintify.common.TintedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.ModelIds;
import net.minecraft.data.client.model.Models;
import net.minecraft.data.client.model.Texture;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class TintifyBlockStateProvider extends FabricModelProvider {

	public TintifyBlockStateProvider(FabricDataOutput output) {
		super(output);
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
