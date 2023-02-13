package dev.schmarrn.tintify;

import dev.schmarrn.tintify.common.TintedBlocks;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tintify implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Tintify");

	@Override
	public void onInitialize(ModContainer mod) {TintedBlocks.loadClass();
	}
}
