package ru.topka.copy.thread;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class JoinMessageThread extends Thread {
    public JoinMessageThread() {
        super();
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (MinecraftClient.getInstance().player == null)
                    sleep(5000);

                sleep(5000);
                MinecraftClient.getInstance().player.sendSystemMessage(
                        Text.of("§e Спасибо за использование мода TopkaCopy!\n" +
                                " Разработан командой Topka специально для вас :]"),
                        MinecraftClient.getInstance().player.getUuid()
                );

                while (MinecraftClient.getInstance().player != null)
                    sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
