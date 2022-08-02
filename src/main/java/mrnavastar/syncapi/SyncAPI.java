package mrnavastar.syncapi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.atomic.AtomicBoolean;

public class SyncAPI implements ModInitializer {

    private static final String MODID = "SyncAPI";

    @Override
    public void onInitialize() {
        FabricLoader.getInstance().getModContainer(MODID).ifPresent(modContainer -> {
            AtomicBoolean validBackend = new AtomicBoolean();
            modContainer.getMetadata().getCustomValue("supportedBackends").getAsArray().forEach(id -> validBackend.set(FabricLoader.getInstance().isModLoaded(id.getAsString())));

            //Get angry at mods that include this api incorrectly
            if (!validBackend.get()) modContainer.getContainingMod().ifPresent(badMod -> {
                log(Level.ERROR, "No backend mod found. This is probably because \"" + badMod.getMetadata().getName() + "\" included this api rather than only depending on it.\n Some things may not function as intended. Please reach out to the author of this mod on their issue page.");
            });
        });
    }

    public static void log(Level level, String message) {
        LogManager.getLogger().log(level, "[" + MODID + "] " + message);
    }
}
