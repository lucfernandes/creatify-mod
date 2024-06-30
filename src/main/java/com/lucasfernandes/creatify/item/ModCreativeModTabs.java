package com.lucasfernandes.creatify.item;

import com.lucasfernandes.creatify.Creatify;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Creatify.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIFY_TAB = CREATIVE_MOD_TABS.register("creatify_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MUD.get()))
                    .title(Component.translatable("creative_tab.creatify_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MUD.get());
                        pOutput.accept(ModItems.DRY_CLAY.get());
                        pOutput.accept(ModItems.WATERING_CAN.get());
                        pOutput.accept(ModItems.GOLDEN_WATERING_CAN.get());
                        pOutput.accept(ModItems.DIAMOND_WATERING_CAN.get());
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MOD_TABS.register(modEventBus);
    }
}
