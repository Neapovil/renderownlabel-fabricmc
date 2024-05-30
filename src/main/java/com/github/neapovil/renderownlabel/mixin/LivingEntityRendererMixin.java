package com.github.neapovil.renderownlabel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin
{
    @Inject(at = @At("HEAD"), method = "hasLabel", cancellable = true)
    protected void hasLabel(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir)
    {
        if (livingEntity instanceof ClientPlayerEntity)
        {
            cir.setReturnValue(true);
        }
    }
}
