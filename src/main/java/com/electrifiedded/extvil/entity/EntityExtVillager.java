package com.electrifiedded.extvil.entity;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.World;

/**
 * A plain villager with one of our professions. Separate class only so that mods replacing
 * exact {@code EntityVillager} instances (Helpful Villagers' replaceVanillaVillagers) leave it alone.
 * Rendered by the vanilla villager renderer, which reads the profession skin.
 */
public class EntityExtVillager extends EntityVillager {
    public EntityExtVillager(World world) {
        super(world);
    }
}
