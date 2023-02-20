package dev.schmarrn.tintify.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TintifyDatagenEntry implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(TintifyBlockStateProvider::new);
		fabricDataGenerator.addProvider(TintifyEnglishLangProvider::new);
		fabricDataGenerator.addProvider(TintifyRecipeProvider::new);
		//pack.addProvider(new TintifyBlockstateProvider(pack.));

	}
}
