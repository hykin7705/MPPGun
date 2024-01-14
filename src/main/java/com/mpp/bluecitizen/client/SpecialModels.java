package com.mpp.bluecitizen.client;

import com.mpp.bluecitizen.Mppgun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mppgun.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public enum SpecialModels {
	TESTGUN("gun/testgun");
	
	private final ResourceLocation modelLoc;
	private BakedModel cachedModel;
	
	SpecialModels(String modelName) {
		this.modelLoc = new ResourceLocation(Mppgun.ID, "special/" + modelName);
	}
	
	public BakedModel getModel() {
		if (this.cachedModel == null) {
			this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLoc);
		}
		return this.cachedModel;
	}
	
	@SubscribeEvent
	public static void onRegisterAdditionalModelEvent(final ModelRegistryEvent event) {
		for (SpecialModels specialModel : values()) {
			ForgeModelBakery.addSpecialModel(specialModel.modelLoc);
		}
	}
    @SubscribeEvent
    public static void onBakingCompletedEvent(final ModelBakeEvent event) {
        for (SpecialModels specialModel : values()) {
            specialModel.cachedModel = null;
        }
    }
}
