package com.agatsumazenitsu51000.levellmod.item;

import com.agatsumazenitsu51000.levellmod.capability.PlayerStats;
import com.agatsumazenitsu51000.levellmod.capability.PlayerStatsProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public
class StatRequirementItem extends Item {
    private final int requiredLevel;
    private final int requiredStrength;
    private final int requiredAgility;

    public StatRequirementItem(Properties properties, int requiredLevel, int requiredStrength, int requiredAgility) {
        super(properties);
        this.requiredLevel = requiredLevel;
        this.requiredStrength = requiredStrength;
        this.requiredAgility = requiredAgility;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            playerIn.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent(stats -> {
                if (stats.getLevel() >= requiredLevel && stats.getStrength() >= requiredStrength && stats.getAgility() >= requiredAgility) {
                    // Logic to use the item
                } else {
                    playerIn.sendMessage(new StringTextComponent("You do not meet the requirements to use this item."));
                }
            });
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
