package mrnavastar.syncapi.events;

import net.minecraft.nbt.NbtCompound;

import java.util.HashMap;
import java.util.function.Consumer;

public class SimpleSyncEvent {
    private final HashMap<String, Consumer<NbtCompound>> listeners = new HashMap<>();

    public void register(String id, Consumer<NbtCompound> listener) throws NullPointerException {
        if (listener == null) throw new NullPointerException("You can not pass a null listener");
        listeners.put(id, listener);
    }

    public void invoke(NbtCompound compound) {
        listeners.forEach((id, listener) -> {
            NbtCompound c = compound.getCompound(id);
            listener.accept(c);
            if (!c.isEmpty()) compound.put(id, c);
        });
    }
}
