package dev.schmarrn.tintify.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.item.DyeItem;
import java.util.function.Consumer;

import static dev.schmarrn.tintify.common.TintedBlocks.TINTED_BLOCKS;
import static net.minecraft.item.Items.TINTED_GLASS;

public class TintifyRecipeProvider extends FabricRecipeProvider {
		public TintifyRecipeProvider(FabricDataGenerator generator) {
			super(generator);
		}
		@Override
		public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

			TINTED_BLOCKS.forEach((dyeColor, block) ->{
						ShapedRecipeJsonFactory.create(block, 8)
						.input('#', Blocks.TINTED_GLASS)
						.input('X', DyeItem.byColor(dyeColor))
						.pattern("###")
						.pattern("#X#")
						.pattern("###")
						.group("stained_glass")
						.criterion("has_glass", conditionsFromItem(Blocks.GLASS))
						.offerTo(exporter);
			});
		}
}
