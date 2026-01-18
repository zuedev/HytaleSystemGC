package com.zuedev.systemgc;

/**
 * Main plugin class for HytaleSystemGC.
 * <p>
 * This plugin provides automatic garbage collection scheduling for Hytale servers
 * to help manage memory usage and maintain server performance.
 * </p>
 *
 * @author zuedev
 * @version 1.0.0
 */
public class SystemGCPlugin {

    private AutoGC autoGC;
    private GCConfig config;

    /**
     * Called when the plugin is enabled.
     * Initializes the configuration and starts the automatic GC scheduler.
     */
    public void onEnable() {
        config = new GCConfig();
        autoGC = new AutoGC(config);
        autoGC.start();
        System.out.println("[HytaleSystemGC] Plugin enabled");
    }

    /**
     * Called when the plugin is disabled.
     * Stops the automatic GC scheduler and cleans up resources.
     */
    public void onDisable() {
        if (autoGC != null) {
            autoGC.stop();
        }
        System.out.println("[HytaleSystemGC] Plugin disabled");
    }

    /**
     * Gets the current plugin configuration.
     *
     * @return the GC configuration instance
     */
    public GCConfig getConfig() {
        return config;
    }
}
