package com.zuedev.systemgc;

/**
 * Configuration class for the garbage collection scheduler.
 * <p>
 * This class holds all configurable settings for the automatic GC system.
 * </p>
 *
 * @author zuedev
 * @version 1.0.0
 */
public class GCConfig {

    /**
     * Default interval between GC runs in seconds.
     */
    public static final int DEFAULT_INTERVAL_SECONDS = 10;

    /**
     * Default minimum memory threshold in bytes (1 MB).
     */
    public static final long DEFAULT_MEMORY_THRESHOLD_BYTES = 1048576L;

    private int autoGcIntervalSeconds;
    private long minMemoryThresholdBytes;

    /**
     * Creates a new GCConfig with default values.
     */
    public GCConfig() {
        this.autoGcIntervalSeconds = DEFAULT_INTERVAL_SECONDS;
        this.minMemoryThresholdBytes = DEFAULT_MEMORY_THRESHOLD_BYTES;
    }

    /**
     * Creates a new GCConfig with custom values.
     *
     * @param autoGcIntervalSeconds   the interval between GC runs in seconds (0 to disable)
     * @param minMemoryThresholdBytes the minimum bytes freed before logging
     */
    public GCConfig(int autoGcIntervalSeconds, long minMemoryThresholdBytes) {
        this.autoGcIntervalSeconds = autoGcIntervalSeconds;
        this.minMemoryThresholdBytes = minMemoryThresholdBytes;
    }

    /**
     * Gets the interval between automatic GC runs.
     *
     * @return the interval in seconds, or 0 if disabled
     */
    public int getAutoGcIntervalSeconds() {
        return autoGcIntervalSeconds;
    }

    /**
     * Sets the interval between automatic GC runs.
     *
     * @param autoGcIntervalSeconds the interval in seconds (0 to disable)
     */
    public void setAutoGcIntervalSeconds(int autoGcIntervalSeconds) {
        this.autoGcIntervalSeconds = autoGcIntervalSeconds;
    }

    /**
     * Gets the minimum memory threshold for logging.
     *
     * @return the threshold in bytes
     */
    public long getMinMemoryThresholdBytes() {
        return minMemoryThresholdBytes;
    }

    /**
     * Sets the minimum memory threshold for logging.
     *
     * @param minMemoryThresholdBytes the threshold in bytes
     */
    public void setMinMemoryThresholdBytes(long minMemoryThresholdBytes) {
        this.minMemoryThresholdBytes = minMemoryThresholdBytes;
    }

    @Override
    public String toString() {
        return "GCConfig{" +
                "autoGcIntervalSeconds=" + autoGcIntervalSeconds +
                ", minMemoryThresholdBytes=" + minMemoryThresholdBytes +
                '}';
    }
}
