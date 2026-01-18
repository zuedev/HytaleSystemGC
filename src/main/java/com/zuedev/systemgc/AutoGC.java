package com.zuedev.systemgc;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Handles automatic garbage collection scheduling.
 * <p>
 * This class manages a daemon timer that periodically triggers garbage collection
 * and logs the amount of memory freed when it exceeds a configurable threshold.
 * </p>
 *
 * @author zuedev
 * @version 1.0.0
 */
public class AutoGC {

    private final GCConfig config;
    private Timer timer;

    /**
     * Creates a new AutoGC instance with the specified configuration.
     *
     * @param config the GC configuration to use
     */
    public AutoGC(GCConfig config) {
        this.config = config;
    }

    /**
     * Starts the automatic garbage collection scheduler.
     * <p>
     * If a scheduler is already running, it will be stopped before starting a new one.
     * If the configured interval is 0 or negative, no scheduler will be started.
     * </p>
     */
    public void start() {
        stop();

        if (config.getAutoGcIntervalSeconds() <= 0) {
            return;
        }

        timer = new Timer("HytaleSystemGC", true);
        long intervalMs = config.getAutoGcIntervalSeconds() * 1000L;

        System.out.println("[HytaleSystemGC] Starting auto GC every " + config.getAutoGcIntervalSeconds() + " seconds");

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                performGC();
            }
        }, intervalMs, intervalMs);
    }

    /**
     * Stops the automatic garbage collection scheduler.
     * <p>
     * This method is safe to call even if no scheduler is running.
     * </p>
     */
    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    /**
     * Performs a single garbage collection cycle and logs results.
     */
    private void performGC() {
        try {
            long beforeFree = Runtime.getRuntime().freeMemory();
            System.gc();
            long afterFree = Runtime.getRuntime().freeMemory();
            long freed = afterFree - beforeFree;

            if (freed > config.getMinMemoryThresholdBytes()) {
                System.out.println("[HytaleSystemGC] Freed " + (freed / 1024 / 1024) + " MB");
            }
        } catch (Exception e) {
            System.err.println("[HytaleSystemGC] Error during garbage collection: " + e.getMessage());
        }
    }

    /**
     * Checks if the scheduler is currently running.
     *
     * @return true if the scheduler is active, false otherwise
     */
    public boolean isRunning() {
        return timer != null;
    }
}
