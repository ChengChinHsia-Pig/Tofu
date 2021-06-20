package asia.ubb.tofu.framework;

import java.util.ArrayList;
import java.util.List;

public class PluginService {

    private final List<Runnable> reloadCallbacks = new ArrayList<>();

    public void registerReloadCallback(Runnable callback) {
        reloadCallbacks.add(callback);
    }

    public void reload() {
        for (Runnable callback : reloadCallbacks) {
            callback.run();
        }
    }

}
