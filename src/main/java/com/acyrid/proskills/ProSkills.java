package com.acyrid.proskills;

import com.acyrid.proskills.listeners.PSBlockListener;
import com.acyrid.proskills.listeners.PSDamageListener;
import com.acyrid.proskills.listeners.PSPlayerListener;
import com.acyrid.proskills.utils.PSConfig;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class ProSkills extends JavaPlugin{
    private PSPlayerListener playerListener = new PSPlayerListener(this);
    private PSDamageListener damageListener = new PSDamageListener(this);
    private PSBlockListener blockListener = new PSBlockListener(this);
    //private PSEntityListener entityListener = new PSEntityListener(this);
    private String configVersion = "b.01";
    private String oldconfigVersion = "b.00";

    public void onDisable(){
        this.getLogger().log(Level.INFO, "is Disabled!");
    }
    public void onEnable(){
        loadConfig();
        getConfig();
        this.registerEvents();
        this.getLogger().log(Level.INFO, "is now enabled like a true pro!");
    }

    private void loadConfig(){
        if(!new File(this.getDataFolder(), "config.yml").exists()){
            this.getLogger().log(Level.INFO, "<----FIRST RUN, Generating config.yml---->");
            saveDefaultConfig();
        }else if(!this.getConfig().getString(PSConfig.configCheck).contentEquals(configVersion)){
            File file = new File(this.getDataFolder()+File.separator+"config.yml");
            this.getLogger().log(Level.INFO, "<----Config.yml is not up-to-date for this version---->");
            file.renameTo(new File(this.getDataFolder()+File.separator + "OLD_config_" + oldconfigVersion + ".yml"));
            this.getLogger().log(Level.INFO, "<----Renaming your Config to OLD_config_" + oldconfigVersion + ".yml---->");
            this.getLogger().log(Level.INFO, "<----Generating new config.yml for version:"+configVersion+"----->");
            saveDefaultConfig();
            this.getLogger().log(Level.INFO, "A new config file has been created please make adjustments as needed.");
        }
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.playerListener, this);
        pm.registerEvents(this.blockListener, this);
        pm.registerEvents(this.damageListener, this);
        //pm.registerEvents(this.entityListener, this);

    }
}

