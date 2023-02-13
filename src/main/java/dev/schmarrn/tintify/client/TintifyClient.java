package dev.schmarrn.tintify.client;

import dev.schmarrn.tintify.common.TintedBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

import static dev.schmarrn.tintify.common.TintedBlocks.TINTED_BLOCKS;

public class TintifyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockRenderLayerMap.put(RenderLayer.getTranslucent(), TINTED_BLOCKS.values().toArray(new Block[0]));

		TINTED_BLOCKS.forEach((dyeColor, block) -> {
			ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> dyeColor.getColor(), block);
			ColorProviderRegistry.ITEM.register((stack, index) -> dyeColor.getSignColor(), block);
		});
	}
}
