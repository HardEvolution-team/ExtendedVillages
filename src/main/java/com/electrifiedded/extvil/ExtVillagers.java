package com.electrifiedded.extvil;

import com.electrifiedded.extvil.world.ExtTrade;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

/** The four professions. Registry names are under our own domain, so they never collide with other mods. */
public final class ExtVillagers {
    private ExtVillagers() {}

    public static final VillagerProfession MILLER = prof("miller");
    public static final VillagerProfession FISHER = prof("fisher");
    public static final VillagerProfession BAKER = prof("baker");
    public static final VillagerProfession MINER = prof("miner");

    private static VillagerProfession prof(String name) {
        // skins come from the original jar (served by ArchaicLib), file names aliased in ExtendedVillages
        String tex = Reference.MOD_ID + ":textures/entities/villager/" + name + ".png";
        return new VillagerProfession(Reference.MOD_ID + ":" + name, tex, "minecraft:textures/entity/zombie_villager/zombie_farmer.png");
    }

    static void addCareers() {
        new VillagerCareer(MILLER, "miller").addTrade(1,
                new ExtTrade(Items.WHEAT, 16, 24, Items.EMERALD, 2, 3),
                new ExtTrade(Items.EMERALD, 3, 4, Items.WHEAT, 10, 16),
                new ExtTrade(Items.WHEAT_SEEDS, 16, 16, Items.EMERALD, 3, 3),
                new ExtTrade(Items.EMERALD, 4, 4, Items.WHEAT_SEEDS, 10, 10),
                new ExtTrade(Items.BREAD, 3, 3, Items.EMERALD, 3, 3),
                new ExtTrade(Items.EMERALD, 5, 5, Items.BREAD, 2, 2));
        new VillagerCareer(FISHER, "fisher").addTrade(1,
                new ExtTrade(Items.DYE, 16, 24, Items.EMERALD, 2, 3),
                new ExtTrade(Items.EMERALD, 3, 4, Items.DYE, 10, 16),
                new ExtTrade(Items.FISHING_ROD, 1, 1, Items.EMERALD, 8, 8),
                new ExtTrade(Items.FISH, 3, 3, Items.EMERALD, 1, 1),
                new ExtTrade(Items.EMERALD, 5, 5, Items.FISH, 8, 8));
        new VillagerCareer(BAKER, "baker").addTrade(1,
                new ExtTrade(Items.BREAD, 2, 2, Items.EMERALD, 1, 1),
                new ExtTrade(Items.EMERALD, 3, 3, Items.BREAD, 2, 2),
                new ExtTrade(Items.BREAD, 6, 6, Items.WHEAT, 16, 16));
        new VillagerCareer(MINER, "miner").addTrade(1,
                new ExtTrade(Item.getItemFromBlock(Blocks.IRON_ORE), 1, 3, Items.EMERALD, 1, 2),
                new ExtTrade(Items.IRON_PICKAXE, 1, 1, Items.EMERALD, 3, 4),
                new ExtTrade(Item.getItemFromBlock(Blocks.GOLD_ORE), 1, 1, Items.EMERALD, 3, 3),
                new ExtTrade(Items.DIAMOND, 1, 1, Items.EMERALD, 6, 8));
    }
}
