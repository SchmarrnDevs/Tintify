package dev.schmarrn.tintify.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.Arrays;

import static dev.schmarrn.tintify.common.TintedBlocks.TINTED_BLOCKS;

public class TintifyEnglishLangProvider extends FabricLanguageProvider {
	public TintifyEnglishLangProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator, "en_us");
	}
	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		TINTED_BLOCKS.forEach((dyeColor, block) -> {
			translationBuilder.add(block, (TintifyLangFormatter.capitalizedWords(dyeColor.getName()) + " Tinted Glass"));

			});
	}
}
