package org.kitteh.simplervanish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SV extends JavaPlugin {

    @Override
    public void onDisable() {
        this.getLogger().info("v" + this.getDescription().getVersion() + " disabled");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("v" + this.getDescription().getVersion() + " enabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target;
        Player toggling;
        if(args.length==1 && sender instanceof Player){
            toggling=(Player)sender;
            target=getServer().getPlayer(args[0]);
        } else if (args.length == 2){
            toggling=getServer().getPlayer(args[0]);
            target=getServer().getPlayer(args[1]);
        } else{
            return true;
        }
        if(toggling!=null && target!=null){
            if(target.canSee(toggling)){
                target.hidePlayer(toggling);
                sender.sendMessage("Hiding "+toggling.getName()+" from "+target.getName());
            } else{
                target.showPlayer(toggling);
                sender.sendMessage("Showing "+toggling.getName()+ " to "+target.getName());
            }
        }
        return true;
    }
}