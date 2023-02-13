package dev.schmarrn.tintify.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import static dev.schmarrn.tintify.common.TintedBlocks.TINTED_BLOCKS;

public class TintifyEnglishLangProvider extends FabricLanguageProvider {
	public TintifyEnglishLangProvider(FabricDataOutput dataOutput) {
		super(dataOutput, "en_us");
	}
	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		TINTED_BLOCKS.forEach((dyeColor, block) -> {
			translationBuilder.add(block, (dyeColor.getName().substring(0,1).toUpperCase()+dyeColor.getName().substring(1) + " Tinted Glass"));
		});
	}
}
