package com.p1nero.tcrcore.dialog;

import com.p1nero.dialog_lib.events.ServerCustomInteractEvent;
import com.p1nero.dialog_lib.events.ServerNpcEntityInteractEvent;
import com.p1nero.fast_tpa.network.PacketRelay;
import com.p1nero.tcrcore.TCRCoreMod;
import com.p1nero.tcrcore.capability.TCRCapabilityProvider;
import com.p1nero.tcrcore.network.TCRPacketHandler;
import com.p1nero.tcrcore.network.packet.clientbound.PlayTitlePacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = TCRCoreMod.MOD_ID)
public class CustomDialogHandler {

    public static final int ON_START_SCREEN = 1;
    public static final int ON_RESET_GAME_PROGRESS = 2;

    @SubscribeEvent
    public static void onLivingDialog(ServerNpcEntityInteractEvent event) {
        if (event.getSelf() instanceof Villager) {
            TCRCapabilityProvider.getTCRPlayer(event.getServerPlayer()).setCurrentTalkingEntity(null);
        }
    }

    @SubscribeEvent
    public static void onCustomDialog(ServerCustomInteractEvent event) {
        if(Objects.equals(event.getModId(), TCRCoreMod.MOD_ID)) {
            ServerPlayer serverPlayer = event.getServerPlayer();
            if(event.getInteractId() == ON_START_SCREEN) {
                PacketRelay.sendToPlayer(TCRPacketHandler.INSTANCE, new PlayTitlePacket(PlayTitlePacket.OPEN_BACKPACK_TUTORIAL), serverPlayer);
            }
            if(event.getInteractId() == ON_RESET_GAME_PROGRESS) {

            }
        }
    }

}
