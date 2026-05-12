package com.pvpclient.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pvpclient.modules.combat.*;
import com.pvpclient.modules.movement.*;
import com.pvpclient.modules.render.*;
import com.pvpclient.modules.misc.*;

/**
 * Manages all loaded modules
 * Handles registration, enabling/disabling, and event dispatching
 */
public class ModuleManager {
    private List<Module> modules;
    private Map<ModuleCategory, List<Module>> modulesByCategory;

    public ModuleManager() {
        this.modules = new ArrayList<>();
        this.modulesByCategory = new HashMap<>();

        // Initialize categories
        for (ModuleCategory category : ModuleCategory.values()) {
            modulesByCategory.put(category, new ArrayList<>());
        }
    }

    /**
     * Register all available modules
     */
    public void registerModules() {
        // Combat modules
        registerModule(new AimAssist());
        registerModule(new AutoClicker());
        registerModule(new CriticalHits());
        registerModule(new Reach());

        // Render modules
        registerModule(new ESP());
        registerModule(new Fullbright());
        registerModule(new Keystrokes());
        registerModule(new FPSCounter());
        registerModule(new Crosshair());

        // Movement modules
        registerModule(new AutoSprint());
        registerModule(new NoFall());
        registerModule(new Speed());

        // Misc modules
        registerModule(new ToggleSprint());
        registerModule(new AutoLog());
    }

    /**
     * Register a single module
     */
    public void registerModule(Module module) {
        modules.add(module);
        modulesByCategory.get(module.getCategory()).add(module);
    }

    /**
     * Call onTick for all enabled modules
     */
    public void onTick() {
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onTick();
            }
        }
    }

    /**
     * Call onRender for all enabled modules
     */
    public void onRender() {
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onRender();
            }
        }
    }

    /**
     * Get module by name
     */
    public Module getModuleByName(String name) {
        return modules.stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get all modules
     */
    public List<Module> getModules() {
        return new ArrayList<>(modules);
    }

    /**
     * Get modules by category
     */
    public List<Module> getModulesByCategory(ModuleCategory category) {
        return new ArrayList<>(modulesByCategory.get(category));
    }

    /**
     * Get count of enabled modules
     */
    public int getEnabledModuleCount() {
        return (int) modules.stream().filter(Module::isEnabled).count();
    }
}
