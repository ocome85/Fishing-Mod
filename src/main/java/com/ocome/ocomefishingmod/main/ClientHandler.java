package com.ocome.ocomefishingmod.main;

import com.ocome.ocomefishingmod.Render.ModFishingHookRenderer;
import com.ocome.ocomefishingmod.item.CustomFishingHook;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = OcomeFishingMod.MOD_ID,
        value = {Dist.CLIENT},
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class ClientHandler {
    //public static ModelLayerLocation PENGUIN_LAYER = new ModelLayerLocation(new ResourceLocation(OcomeNiji.MOD_ID, "penguin"), "penguin");
    //public static ModelLayerLocation SHIBA_LAYER = new ModelLayerLocation(new ResourceLocation(OcomeNiji.MOD_ID, "shiba"), "shiba");

    public static void init() {
    }
    //registry list
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.MODFISHING_BOBBER, ModFishingHookRenderer::new);

    }
    //renderer list
    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        //event.registerLayerDefinition(PENGUIN_LAYER, PenguinModel::createBodyLayer);


    }
}
