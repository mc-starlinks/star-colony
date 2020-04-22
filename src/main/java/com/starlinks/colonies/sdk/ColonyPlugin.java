package com.starlinks.colonies.sdk;

import com.starlinks.colonies.api.ColonyAPI;
import com.starlinks.core.api.StarAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ColonyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final ServicesManager services = Bukkit.getServicesManager();
        final StarAPI starAPI = services.load(StarAPI.class);

        final ColonyAPI colonyAPI = new ColonyImpl(starAPI);
        colonyAPI.onActivate();

        services.register(
                ColonyAPI.class,
                colonyAPI,
                this,
                ServicePriority.Normal
        );
    }
}
