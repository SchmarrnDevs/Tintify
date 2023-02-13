package dev.schmarrn.tintify.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.RecipesProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonFactory;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCategory;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.recipe.api.RecipeManagerHelper;

import java.awt.*;
import java.util.function.Consumer;

import static dev.schmarrn.tintify.common.TintedBlocks.TINTED_BLOCKS;
import static net.minecraft.item.Items.TINTED_GLASS;

public class TintifyRecipeProvider extends FabricRecipeProvider {
		public TintifyRecipeProvider(FabricDataOutput output) {
			super(output);
		}
		@Override
		public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

			TINTED_BLOCKS.forEach((dyeColor, block) ->{
						//String color = "Items+" dyeColor.getName().toUpperCase() + "_DYE"
						 //id = new Identifier("tintify", dyeColor.getName() + "_tinted_glass");
						ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, block, 8)
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
