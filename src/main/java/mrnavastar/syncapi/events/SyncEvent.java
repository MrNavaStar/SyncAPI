package mrnavastar.syncapi.events;

import net.minecraft.nbt.NbtCompound;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class SyncEvent<T> {
    private final HashMap<String, BiConsumer<T, NbtCompound>> listeners = new HashMap<>();

    public void register(String id, BiConsumer<T, NbtCompound> listener) throws NullPointerException {
        if (listener == null) throw new NullPointerException("You can not pass a null listener");
        listeners.put(id, listener);
    }

    public void invoke(T t, NbtCompound compound) {
        listeners.forEach((id, listener) -> {
            NbtCompound c = compound.getCompound(id);
            listener.accept(t, c);
            if (!c.isEmpty()) compound.put(id, c);
        });
    }
}