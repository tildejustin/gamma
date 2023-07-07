package xyz.tildejustin.gamma;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class EarlyRiser implements Runnable {
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String GameOptions$Option = remapper.mapClassName("intermediary", "net.minecraft.class_347$class_350");
        ClassTinkerers.enumBuilder(GameOptions$Option, String.class, boolean.class, boolean.class, float.class, float.class, float.class)
                .addEnum("BRIGHTNESS", "options.gamma", true, false, .0F, 5.0F, 0.1F)
                .build();
    }
}
