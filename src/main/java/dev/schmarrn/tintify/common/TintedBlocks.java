package dev.schmarrn.tintify.common;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.EnumMap;
import java.util.Map;

public class TintedBlocks {
	public static final Map<DyeColor, Block> TINTED_BLOCKS = createTintedBlocks();

	private static Map<DyeColor, Block> createTintedBlocks() {
		Map<DyeColor, Block> tempMap = new EnumMap<>(DyeColor.class);
		for (DyeColor dyeColor: DyeColor.values()) {
			TintedGlassBlock block = new TintedGlassBlock(QuiltBlockSettings.copyOf(Blocks.TINTED_GLASS));
			tempMap.put(dyeColor, block);

			Identifier id = new Identifier("tintify", dyeColor.getName() + "_tinted_glass");
			Registry.register(Registries.BLOCK, id, block);

			Item item = new BlockItem(block, new QuiltItemSettings());
			Registry.register(Registries.ITEM, id, item);

			ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(listener -> {
				listener.addAfter(Blocks.TINTED_GLASS, item);
			});

			ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(listener -> {
				listener.addAfter(Blocks.TINTED_GLASS, item);
			});

		}
		return tempMap;
	}

	public static void loadClass() {
		//ClassLoading
	}
}
