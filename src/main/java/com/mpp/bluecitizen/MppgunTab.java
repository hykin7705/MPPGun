package com.mpp.bluecitizen;

import com.mpp.bluecitizen.common.item.Mppgunitem;
import com.mpp.bluecitizen.core.registry.ItemRegistry;
import com.mrcrayfish.guns.client.CustomGunManager;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;

public class MppgunTab extends CreativeModeTab {
	public MppgunTab(String label) {
		super(label);
	}

	public ItemStack makeIcon() {
		Mppgunitem gunItem = (Mppgunitem) ItemRegistry.TESTGUN.get();
		ItemStack stack = gunItem.getDefaultInstance();
		stack.getOrCreateTag().putInt("AmmoCount", gunItem.getGun().getGeneral().getMaxAmmo());
		return stack;
	}
	
	public void fillItemList(NonNullList<ItemStack> items) {
		super.fillItemList(items);
		CustomGunManager.fill(items);
	}
}
