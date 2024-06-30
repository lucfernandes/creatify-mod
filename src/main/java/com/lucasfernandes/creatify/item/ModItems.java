package com.lucasfernandes.creatify.item;

import com.lucasfernandes.creatify.Creatify;
import com.lucasfernandes.creatify.item.custom.WateringCanItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        Creatify.MOD_ID);

        public static final RegistryObject<Item> MUD = ITEMS.register("mud",
                        () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON)));

        public static final RegistryObject<Item> DRY_CLAY = ITEMS.register("dry_clay",
                        () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

        public static final RegistryObject<Item> WATERING_CAN = ITEMS.register("watering_can",
                        () -> new WateringCanItem(
                                        new Item.Properties().stacksTo(1).durability(50).defaultDurability(50)
                                                        .rarity(Rarity.UNCOMMON),
                                        3,
                                        0.25));

        public static final RegistryObject<Item> GOLDEN_WATERING_CAN = ITEMS.register("golden_watering_can",
                        () -> new WateringCanItem(new Item.Properties().stacksTo(1).durability(20).defaultDurability(20)
                                        .rarity(Rarity.RARE), 15, 0.9));

        public static final RegistryObject<Item> DIAMOND_WATERING_CAN = ITEMS.register("diamond_watering_can",
                        () -> new WateringCanItem(new Item.Properties().stacksTo(1).durability(100)
                                        .defaultDurability(100).rarity(Rarity.EPIC), 10, 0.75));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }

}
