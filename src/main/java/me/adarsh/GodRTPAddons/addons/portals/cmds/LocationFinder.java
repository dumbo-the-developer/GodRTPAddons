package me.adarsh.GodRTPAddons.addons.portals.cmds;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

public interface LocationFinder {

    default Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = null;
        while (iter.hasNext()) {
            Block block = iter.next();
            if (block.getType() != Material.AIR) {
                lastBlock = block;
                break;
            }
        }
        return lastBlock;
    }

}
