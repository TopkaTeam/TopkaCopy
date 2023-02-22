package ru.topka.copy;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;

public class JoinMessageThread extends Thread {
    public JoinMessageThread() {
        super();
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (Minecraft.getInstance().player == null) sleep(5000);

                sleep(5000);
                Minecraft.getInstance().player.sendMessage(ITextComponent.getTextComponentOrEmpty(
                                "§e Спасибо за использование мода TopkaCopy!\n" +
                                " Разработан командой Topka специально для вас :]"
                        ),
                Minecraft.getInstance().player.getUniqueID());

                while (Minecraft.getInstance().player != null) sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
