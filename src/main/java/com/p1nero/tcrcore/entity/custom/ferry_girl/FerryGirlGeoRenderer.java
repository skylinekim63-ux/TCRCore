package com.p1nero.tcrcore.entity.custom.ferry_girl;

import com.mojang.blaze3d.vertex.PoseStack;
import com.p1nero.tcrcore.TCRCoreMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class FerryGirlGeoRenderer extends GeoEntityRenderer<FerryGirlEntity> {
    public FerryGirlGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(TCRCoreMod.MOD_ID, "girl")) {
            @Override
            public void setCustomAnimations(FerryGirlEntity animatable, long instanceId, AnimationState<FerryGirlEntity> animationState) {
                CoreGeoBone head = getAnimationProcessor().getBone("Head");

                if (head != null) {
                    EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

                    head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
                    head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
                }
            }
        });
    }

    @Override
    public void render(@NotNull FerryGirlEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(0.66f, 0.66f, 0.66f);
        poseStack.translate(0, 0.5, 0);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }
}
