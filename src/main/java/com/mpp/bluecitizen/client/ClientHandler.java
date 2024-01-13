package com.mpp.bluecitizen.client;

import com.mrcrayfish.guns.client.render.gun.model.SimpleModel;
import com.mpp.bluecitizen.core.registry.ItemRegistry;
import com.mrcrayfish.guns.client.render.gun.ModelOverrides;

public class ClientHandler {
	public static void registerModelOverrides() {
		ModelOverrides.register(ItemRegistry.TESTGUN.get(), new SimpleModel(SpecialModels.TESTGUN::getModel));
	}
}
