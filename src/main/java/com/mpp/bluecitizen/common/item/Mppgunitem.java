package com.mpp.bluecitizen.common.item;

import com.mpp.bluecitizen.config.Config;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.world.item.ItemStack;

public class Mppgunitem extends GunItem {

	private final boolean canColor;
	
	public Mppgunitem(Properties properties, boolean canColor) {
		super(properties);
		this.canColor = canColor;
	}
	
	public boolean canColor(ItemStack stack) {
		return this.canColor;
	}
	
	@Override
	public boolean isFoil(ItemStack stack) {
		if (stack.isEnchanted()) {
			return Config.Client.enableGunEnchantmentGlint.get();
		}
		else {
			return false;
		}
	}
}
