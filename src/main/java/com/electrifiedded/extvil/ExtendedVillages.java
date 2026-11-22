package com.electrifiedded.extvil;

import com.electrifiedded.archaiclib.original.OriginalModAssets;
import com.electrifiedded.extvil.entity.EntityExtVillager;
import com.electrifiedded.extvil.world.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:archaiclib;after:helpfulvillagers")
public class ExtendedVillages {
    public static final Logger LOG = LogManager.getLogger(Reference.MOD_ID);
    public static final String ORIGINAL_NAME = "Extended Villages 1.7.10 (extended_villages_mod_1.7.10.jar)";
    public static final String ORIGINAL_URL = "https://www.curseforge.com/minecraft/mc-mods/extended-villages";

    public static int windmillWeight = 3, fishHutWeight = 3, bakeryWeight = 3, mineWeight = 3;

    public ExtendedVillages() {
        OriginalModAssets.require(Reference.MOD_ID, "extvil", ORIGINAL_NAME, ORIGINAL_URL, "extvil");
        for (String n : new String[]{"Miller", "Fisher", "Baker", "Miner"}) {
            OriginalModAssets.alias("extvil", "textures/entities/villager/" + n.toLowerCase() + ".png", "textures/entities/villager/" + n + ".png");
        }
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        cfg.load();
        windmillWeight = cfg.getInt("windmillWeight", "village", 3, 0, 100, "Village piece weight of the windmill (Miller). 0 disables it.");
        fishHutWeight = cfg.getInt("fishHutWeight", "village", 3, 0, 100, "Village piece weight of the fish hut (Fisher). 0 disables it.");
        bakeryWeight = cfg.getInt("bakeryWeight", "village", 3, 0, 100, "Village piece weight of the bakery (Baker). 0 disables it.");
        mineWeight = cfg.getInt("mineWeight", "village", 3, 0, 100, "Village piece weight of the mine (Miner). 0 disables it.");
        if (cfg.hasChanged()) cfg.save();
        if (event.getSide().isClient()) com.electrifiedded.extvil.client.ExtClient.preInit();
    }

    @SubscribeEvent
    public void onProfessions(RegistryEvent.Register<VillagerProfession> e) {
        e.getRegistry().registerAll(ExtVillagers.MILLER, ExtVillagers.FISHER, ExtVillagers.BAKER, ExtVillagers.MINER);
        ExtVillagers.addCareers();
    }

    @SubscribeEvent
    public void onEntities(RegistryEvent.Register<EntityEntry> e) {
        e.getRegistry().register(EntityEntryBuilder.create().entity(EntityExtVillager.class)
                .id(new ResourceLocation(Reference.MOD_ID, "villager"), 0).name(Reference.MOD_ID + ".villager")
                .tracker(80, 3, true).build());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        add(ComponentWindmill.class, "extvil:Windmill", ComponentWindmill::build, windmillWeight);
        add(ComponentFishHut.class, "extvil:FishHut", ComponentFishHut::build, fishHutWeight);
        add(ComponentBakery.class, "extvil:Bakery", ComponentBakery::build, bakeryWeight);
        add(ComponentMiner.class, "extvil:Minery", ComponentMiner::build, mineWeight);
        if (Loader.isModLoaded("helpfulvillagers")) {
            LOG.info("Helpful Villagers present: Extended Villages spawns its own villager class, so its professions are not replaced.");
        }
    }

    private static void add(Class<? extends ComponentExtVillage> cls, String id, ExtVillageHandler.Builder b, int weight) {
        MapGenStructureIO.registerStructureComponent(cls, id); // always, so saved villages still load
        if (weight > 0) VillagerRegistry.instance().registerVillageCreationHandler(new ExtVillageHandler(cls, b, weight, 1));
    }
}
