package dev.schmarrn.tintify.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TintifyDatagenEntry implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TintifyBlockStateProvider::new);
		pack.addProvider(TintifyEnglishLangProvider::new);
		pack.addProvider(TintifyRecipeProvider::new);
		//pack.addProvider(new TintifyBlockstateProvider(pack.));

	}
}
