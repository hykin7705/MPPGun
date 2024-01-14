package com.mpp.bluecitizen.core.registry;

import com.mpp.bluecitizen.Mppgun;
import com.mpp.bluecitizen.common.item.Mppgunitem;
import com.mpp.bluecitizen.common.item.BulletCasingitem;
import com.mrcrayfish.guns.common.GunModifiers;
import com.mrcrayfish.guns.item.*;
import com.mrcrayfish.guns.item.attachment.impl.Barrel;
import com.mrcrayfish.guns.item.attachment.impl.Scope;
import com.mrcrayfish.guns.item.attachment.impl.Stock;
import com.mrcrayfish.guns.item.attachment.impl.UnderBarrel;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mppgun.ID);
	public static final Item.Properties genericProperties = new Item.Properties().stacksTo(1).tab(Mppgun.GROUP);
	
	public static final RegistryObject<Item> TESTGUN = registerGun("testgun", false);
	
	private static RegistryObject<Item> registerGun(String name, boolean canColor) {
		return ITEMS.register(name, () -> new Mppgunitem(genericProperties, canColor));
	}
	
    /* Scope Attachments */
    public static final RegistryObject<Item> HOLO_SCOPE = ITEMS.register("holo_scope", () -> new ScopeItem(Scope.builder().additionalZoom(0.25F).reticleOffset(1.6F).viewFinderOffset(0.4).modifiers(GunModifiers.SLOW_ADS).build(), genericProperties, false));
    public static final RegistryObject<Item> ZERKALO_SCOPE = ITEMS.register("zerkalo_scope", () -> new ScopeItem(Scope.builder().additionalZoom(0.025F).reticleOffset(1.25F).viewFinderOffset(0.3).modifiers(GunModifiers.SLOWER_ADS).build(), genericProperties, false));
    public static final RegistryObject<Item> KOBRA_SCOPE = ITEMS.register("kobra", () -> new ScopeItem(Scope.builder().additionalZoom(0.15F).reticleOffset(1.75F).viewFinderOffset(0.4).modifiers(GunModifiers.SLOW_ADS).build(), genericProperties));
    // Removed until fixed!
    //public static final RegistryObject<Item> ULTRA_LONG_SCOPE = ITEMS.register("extra_long_scope", () -> new ScopeItem(Scope.create(0.45F, 1.25D, GunModifiers.SLOWER_ADS).viewFinderOffset(0.5), genericProperties));

    /* Stock Attachments */
    public static final RegistryObject<Item> BASIC_STOCK = ITEMS.register("basic_stock", () -> new StockItem(Stock.create(GunModifiers.STABILISED), genericProperties, false));
    public static final RegistryObject<Item> VINTOREZ_STOCK = ITEMS.register("vintorez_stock", () -> new StockItem(Stock.create(GunModifiers.BETTER_CONTROL), genericProperties, false));

    /* Barrel Attachments */
    public static final RegistryObject<Item> MUZZLE_BRAKE = ITEMS.register("muzzle_brake", () -> new BarrelItem(Barrel.create(9.5f, GunModifiers.REDUCED_RECOIL), genericProperties, false));
    public static final RegistryObject<Item> TACTICAL_SILENCER = ITEMS.register("tactical_silencer", () -> new BarrelItem(Barrel.create(16.0f, GunModifiers.SILENCED), genericProperties));
    public static final RegistryObject<Item> SNIPER_MUZZLE_BRAKE = ITEMS.register("sniper_muzzle_brake", () -> new BarrelItem(Barrel.create(6.0f, GunModifiers.BETTER_CONTROL), genericProperties));
    public static final RegistryObject<Item> TACTICAL_MUZZLE_BRAKE = ITEMS.register("tactical_muzzle_brake", () -> new BarrelItem(Barrel.create(7.5f, GunModifiers.REDUCED_RECOIL), genericProperties, false));

    /* Under Barrel Attachments */
    public static final RegistryObject<Item> ANGLED_GRIP = ITEMS.register("angled_grip", () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.LIGHT_RECOIL), genericProperties));

    /* Ammunition */
    public static final RegistryObject<Item> BULLET_HEAVY = registerAmmo("bullet_heavy");
    public static final RegistryObject<Item> BULLET_LONG = registerAmmo("bullet_long");
    public static final RegistryObject<Item> BULLET_MEDIUM = registerAmmo("bullet_medium");
    public static final RegistryObject<Item> BULLET_SHORT = registerAmmo("bullet_short");
    public static final RegistryObject<Item> BULLET_SMALL = registerAmmo("bullet_small");
    public static final RegistryObject<Item> BULLET_SPECIAL = registerAmmo("bullet_special");

    /* Bullet casings */
    public static final RegistryObject<Item> CASING_HEAVY = registerCasing("casing_heavy");
    public static final RegistryObject<Item> CASING_LONG = registerCasing("casing_long");
    public static final RegistryObject<Item> CASING_MEDIUM = registerCasing("casing_medium");
    public static final RegistryObject<Item> CASING_SHORT = registerCasing("casing_short");
    public static final RegistryObject<Item> CASING_SMALL = registerCasing("casing_small");
    public static final RegistryObject<Item> CASING_SPECIAL = registerCasing("casing_special");

    private static RegistryObject<Item> registerAmmo(String name) {
        return ITEMS.register(name, () -> new AmmoItem(new Item.Properties().tab(Mppgun.GROUP)));
    }

    private static RegistryObject<Item> registerCasing(String name) {
        return ITEMS.register(name, () -> new BulletCasingitem(new Item.Properties().tab(Mppgun.GROUP)));
    }
}
