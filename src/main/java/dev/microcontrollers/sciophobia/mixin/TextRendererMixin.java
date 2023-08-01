package dev.microcontrollers.sciophobia.mixin;

import dev.microcontrollers.sciophobia.config.SciophobiaConfig;
import net.minecraft.client.font.TextRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/*
    The following methods were taken from Easeify under LGPLV3
    https://github.com/Polyfrost/Easeify/blob/main/LICENSE
    The code has been updated to 1.20 and with slight changes to variables
 */
@Mixin(TextRenderer.class)
public class TextRendererMixin {
    @ModifyVariable(method = "drawInternal(Lnet/minecraft/text/OrderedText;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)I", at = @At("HEAD"), index = 5, argsOnly = true)
    private boolean disableShadow(boolean textShadow) {
        return (!SciophobiaConfig.INSTANCE.getConfig().removeShadows && textShadow);
    }

    @ModifyVariable(method = "drawInternal(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;IIZ)I", at = @At("HEAD"), index = 5, argsOnly = true)
    private boolean disableShadow2(boolean textShadow) {
        return (!SciophobiaConfig.INSTANCE.getConfig().removeShadows && textShadow);
    }
}
