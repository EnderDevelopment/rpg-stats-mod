package com.agatsumazenitsu51000.levellmod.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public
class PlayerStatsProvider implements ICapabilitySerializable<CompoundNBT> {
    @CapabilityInject(PlayerStats.class)
    public static final Capability<PlayerStats> PLAYER_STATS_CAPABILITY = null;

    private LazyOptional<PlayerStats> instance = LazyOptional.of(PLAYER_STATS_CAPABILITY::getDefaultInstance);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == PLAYER_STATS_CAPABILITY ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        return (CompoundNBT) PLAYER_STATS_CAPABILITY.getStorage().writeNBT(PLAYER_STATS_CAPABILITY, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        PLAYER_STATS_CAPABILITY.getStorage().readNBT(PLAYER_STATS_CAPABILITY, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
    }
}
