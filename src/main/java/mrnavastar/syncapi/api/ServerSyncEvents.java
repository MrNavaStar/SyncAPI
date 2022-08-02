package mrnavastar.syncapi.api;

import mrnavastar.syncapi.events.SimpleSyncEvent;
import mrnavastar.syncapi.events.SyncEvent;
import net.fabricmc.loader.api.ObjectShare;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class ServerSyncEvents {

    public static final SyncEvent<ServerPlayerEntity> READ_PLAYER_DATA = new SyncEvent<>();

    public static final SyncEvent<ServerPlayerEntity> WRITE_PLAYER_DATA = new SyncEvent<>();

    public static final SyncEvent<MinecraftServer> READ_SERVER_DATA = new SyncEvent<>();

    public static final SyncEvent<MinecraftServer> WRITE_SERVER_DATA = new SyncEvent<>();

    public static final SyncEvent<ObjectShare> READ_OBJECT_SHARE = new SyncEvent<>();

    public static final SyncEvent<ObjectShare> WRITE_OBJECT_SHARE = new SyncEvent<>();

    public static final SimpleSyncEvent READ_GENERAL_DATA = new SimpleSyncEvent();

    public static final SimpleSyncEvent WRITE_GENERAL_DATA = new SimpleSyncEvent();
}
