package com.mpp.bluecitizen.core.registry;

import com.mpp.bluecitizen.Mppgun;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Mppgun.ID);
	
	/* Sounds */
	public static final RegistryObject<SoundEvent> TESTGUN = register("item.test.fire");
	
	private static RegistryObject<SoundEvent> register(String name) {
		return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(Mppgun.ID, name)));
	}
}
