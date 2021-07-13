package asia.ubb.tofu.tablist.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;

import java.util.SortedMap;
import java.util.UUID;

public class LuckPermsUtils {

    public static LuckPerms getProvider() {
        return LuckPermsProvider.get();
    }

    public static User getUser(UUID uuid) {
        return getProvider().getUserManager().getUser(uuid);
    }

    public static CachedMetaData getUserMeta(UUID uuid) {
        return getUser(uuid).getCachedData().getMetaData();
    }

    public static SortedMap<Integer, String> getUserPrefixes(UUID uuid) {
        return getUserMeta(uuid).getPrefixes();
    }

}
