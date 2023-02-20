package ru.topka.copy.mixin;

import net.minecraft.client.gui.hud.ChatHudListener;
import net.minecraft.network.MessageType;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(ChatHudListener.class)
public class ChatMixin {
    @Inject(method = "onChatMessage(Lnet/minecraft/network/MessageType;Lnet/minecraft/text/Text;Ljava/util/UUID;)V", at = @At("HEAD"))
    void onChatMessage(MessageType messageType, Text message, UUID sender, CallbackInfo info) {
        if (message instanceof TranslatableText) {
            TranslatableText text = (TranslatableText) message;
            Style style = text.getStyle().withClickEvent(
                    new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, text.getString())
            );
            ((TranslatableText) message).setStyle(style);
        }
    }
}
