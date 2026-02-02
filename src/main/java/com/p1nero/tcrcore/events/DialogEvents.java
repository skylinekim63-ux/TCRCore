package com.p1nero.tcrcore.events;

import com.p1nero.dialog_lib.events.ServerCustomInteractEvent;
import com.p1nero.dialog_lib.events.ServerNpcEntityInteractEvent;
import com.p1nero.tcrcore.TCRCoreMod;
import com.p1nero.tcrcore.capability.TCRCapabilityProvider;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TCRCoreMod.MOD_ID)
public class DialogEvents {

    @SubscribeEvent
    public static void onLivingDialog(ServerNpcEntityInteractEvent event) {
        if (event.getSelf() instanceof Villager) {
            TCRCapabilityProvider.getTCRPlayer(event.getServerPlayer()).setCurrentTalkingEntity(null);
        }
    }

    @SubscribeEvent
    public static void onCustomDialog(ServerCustomInteractEvent event) {

    }

}
