package com.mpp.bluecitizen.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {

	public static final ForgeConfigSpec clientConfig;
	public static final Config.Client CLIENT;
	
	static {
		final Pair<Client, ForgeConfigSpec> clientConfigPair = new ForgeConfigSpec.Builder().configure(Client::new);
		clientConfig = clientConfigPair.getRight();
		CLIENT = clientConfigPair.getLeft();
	}
	
	public static class Client {
		public static ForgeConfigSpec.BooleanValue enableGunEnchantmentGlint;
		
		public Client(ForgeConfigSpec.Builder builder) {
			builder.push("client");
			{
				enableGunEnchantmentGlint = builder
						.comment("If true, renders enchanted guns from Mpp gun with the enchantment glint. true by default.")
						.translation("config.Mppgun.client.enable_gun_enchantment_glint")
						.define("enableGunEnchantmentGlint", true);
			}
			builder.pop();
		}
	}
}
