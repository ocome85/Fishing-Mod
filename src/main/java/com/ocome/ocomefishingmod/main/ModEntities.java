package com.ocome.ocomefishingmod.main;

import com.ocome.ocomefishingmod.item.CustomFishingHook;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OcomeFishingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
public static final EntityType<CustomFishingHook> MODFISHING_BOBBER = EntityType.Builder.<CustomFishingHook>of(CustomFishingHook::new, MobCategory.MISC).noSave().noSummon().sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(5).build("mod_fishing_bobber");


    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().register(MODFISHING_BOBBER.setRegistryName("mod_fishing_bobber"));
        //event.getRegistry().register(WOOLY_COW.setRegistryName("wooly_cow"));


        //Raid.RaiderType.create("viler_witch", VILER_WITCH, new int[]{0, 0, 1, 0, 1, 1, 2, 1});

        //SpawnPlacements.register(CLUCK_SHROOM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CluckShroom::checkCluckShroomSpawnRules);
  }

    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
        //event.put(CLUCK_SHROOM, Chicken.createAttributes().build());


    }
}