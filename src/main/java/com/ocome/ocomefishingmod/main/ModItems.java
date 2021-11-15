package com.ocome.ocomefishingmod.main;


import com.ocome.ocomefishingmod.item.Netherite_Rod;
import com.ocome.ocomefishingmod.item.Strawberry;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@ObjectHolder(OcomeFishingMod.MOD_ID)
@Mod.EventBusSubscriber(modid= OcomeFishingMod.MOD_ID,bus =Mod.EventBusSubscriber.Bus.MOD)

public class ModItems {
   public static final Item NETHERITE_ROD = new Netherite_Rod();

    @SubscribeEvent
    public static void  registerItem(RegistryEvent.Register<Item> event){
        //event.getRegistry().register(TUTORIAL_T.setRegistryName("tutorial_t"));
        event.getRegistry().register(new Strawberry());
        event.getRegistry().register(new Netherite_Rod());
    }
}

