package com.ocome.ocomefishingmod.item;

import com.ocome.ocomefishingmod.main.OcomeFishingMod;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nonnull;
import java.util.List;
//public static final Item FISHING_ROD = registerItem("fishing_rod", new FishingRodItem((new Item.Properties()).durability(64).tab(CreativeModeTab.TAB_TOOLS)));

public class Netherite_Rod extends FishingRodItem {
    public Netherite_Rod() {
        super(new Properties().tab(OcomeFishingMod.MOD_TAB).durability(256).fireResistant()
                );
        this.setRegistryName("netherite_rod");
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flags){
        tooltip.add(new TranslatableComponent(this.getDescriptionId()+".desc"));
    }

    @Override
    @Nonnull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack currentstack = player.getItemInHand(hand);
        int lurespeed;
        //if player is fishing
        if (player.fishing != null) {
            if (!level.isClientSide) {
                lurespeed = player.fishing.retrieve(currentstack);
                currentstack.hurtAndBreak(lurespeed, player, (p) -> {
                    p.broadcastBreakEvent(hand);
                });
            }

            level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL, 1.0F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
            level.gameEvent(player, GameEvent.FISHING_ROD_REEL_IN, player);
        }
        else //if player is not fishing
        {

            if (!level.isClientSide)
            {

                lurespeed = EnchantmentHelper.getFishingSpeedBonus(currentstack);
                int luck = EnchantmentHelper.getFishingLuckBonus(currentstack);
                level.addFreshEntity(new CustomFishingHook(player, level, luck, lurespeed));
                //level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            level.gameEvent(player, GameEvent.FISHING_ROD_CAST, player);
        }

        return InteractionResultHolder.sidedSuccess(currentstack, level.isClientSide());
    }


}