package dev.schmarrn.tintify.common;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
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
			Registry.register(Registry.BLOCK, id, block);

			Item item = new BlockItem(block, new QuiltItemSettings().group(ItemGroup.BUILDING_BLOCKS).group(ItemGroup.DECORATIONS));
			Registry.register(Registry.ITEM, id, item);

			/* ItemGroupExtensions.modifyEntriesEvent(ItemGroup.BUILDING_BLOCKS).register(content -> {
				content.(Blocks.TINTED_GLASS, item);
			});

			ItemGroupEvents.modifyEntriesEvent(ItemGroup.DECORATIONS).register(listener -> {
				listener.addAfter(Blocks.TINTED_GLASS, item);
			});*/

		}
		return tempMap;
	}

	public static void loadClass() {
		//ClassLoading
	}
}
