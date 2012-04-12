package com.acyrid.proskills.listeners;

import com.acyrid.proskills.ProSkills;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class PSBlockListener implements Listener {
    private ProSkills plugin;

    public PSBlockListener(ProSkills plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        int blockID = block.getTypeId();
        Material blockType = block.getType();
    }
}


