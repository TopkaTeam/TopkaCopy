package ru.topka.copy;

import net.fabricmc.api.ModInitializer;
import ru.topka.copy.thread.JoinMessageThread;

public class TopkaCopy implements ModInitializer {
    @Override
    public void onInitialize() {
        new JoinMessageThread().start();
    }
}
