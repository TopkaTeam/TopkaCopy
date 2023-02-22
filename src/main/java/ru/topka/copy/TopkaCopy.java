package ru.topka.copy;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(TopkaCopy.MOD_ID)
public class TopkaCopy {
    public static final String MOD_ID = "topkacopy";

    public TopkaCopy() {
        MinecraftForge.EVENT_BUS.register(this);
        new JoinMessageThread().start();
    }


    @Mod.EventBusSubscriber(modid = TopkaCopy.MOD_ID, value = Dist.CLIENT)
    public static class EventsHandler {
        @SubscribeEvent
        public static void event(ClientChatReceivedEvent event) {
            ITextComponent component = event.getMessage();
            if (component instanceof StringTextComponent) {
                StringTextComponent sComponent = (StringTextComponent) component;
                Style style = sComponent.getStyle().setClickEvent
                        (new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, sComponent.getString()));
                sComponent.setStyle(style);
                event.setMessage(sComponent);
            }
        }
    }
}