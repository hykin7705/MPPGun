package com.mpp.bluecitizen;

import com.mpp.bluecitizen.client.ClientHandler;
import com.mpp.bluecitizen.config.Config;
import com.mpp.bluecitizen.datagen.ModRecipeGenerator;
import com.mpp.bluecitizen.core.registry.ItemRegistry;
import com.mpp.bluecitizen.core.registry.SoundRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod(Mppgun.ID)
public class Mppgun {
	public static final String ID = "bcgunmod";
	public static final CreativeModeTab GROUP = new MppgunTab(ID);
	
	public Mppgun() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientConfig);
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.register(this);
		
		ItemRegistry.ITEMS.register(bus);
		SoundRegistry.SOUNDS.register(bus);
		
		bus.addListener(this::clientSetup);
        bus.addListener(this::gatherData);
	}
	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(ClientHandler::registerModelOverrides);
	}
	
	private void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		generator.addProvider(new ModRecipeGenerator(generator));
	}
}
