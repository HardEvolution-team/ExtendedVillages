package com.electrifiedded.extvil.world;

import com.electrifiedded.extvil.entity.EntityExtVillager;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

/** Shared base of the four Extended Villages buildings. */
public abstract class ComponentExtVillage extends StructureVillagePieces.Village {
    protected static final IBlockState SMOOTH_SAND = Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH);
    protected static final IBlockState DECO_SAND = Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED);

    private int spawned;

    protected ComponentExtVillage() {}

    protected ComponentExtVillage(StructureVillagePieces.Start start, int type, StructureBoundingBox box, EnumFacing facing) {
        super(start, type);
        setCoordBaseMode(facing);
        this.boundingBox = box;
    }

    protected abstract VillagerProfession profession();

    @SuppressWarnings("deprecation")
    protected static IBlockState st(IBlockState s, int meta) {
        return meta == 0 ? s : s.getBlock().getStateFromMeta(meta);
    }

    protected boolean isDesert(World world, int x, int z) {
        return structureType == 1 || world.getBiome(new BlockPos(x, 64, z)) == Biomes.DESERT;
    }

    /** @return false if the ground level could not be found yet. */
    protected boolean levelToGround(World world, StructureBoundingBox sbb) {
        if (this.averageGroundLvl < 0) {
            this.averageGroundLvl = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLvl < 0) return false;
            this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4, 0);
        }
        return true;
    }

    @Override
    protected VillagerProfession chooseForgeProfession(int count, VillagerProfession prof) {
        return profession();
    }

    /**
     * Same as vanilla, but spawns {@link EntityExtVillager} so mods that swap out plain EntityVillager
     * (e.g. Helpful Villagers) keep our professions intact.
     */
    @Override
    protected void spawnVillagers(World world, StructureBoundingBox sbb, int x, int y, int z, int count) {
        for (int i = spawned; i < count; i++) {
            int j = getXWithOffset(x + i, z), k = getYWithOffset(y), l = getZWithOffset(x + i, z);
            BlockPos pos = new BlockPos(j, k, l);
            if (!sbb.isVecInside(pos)) break;
            spawned++;
            if (isZombieInfested) {
                EntityZombieVillager zv = new EntityZombieVillager(world);
                zv.setLocationAndAngles(j + 0.5, k, l + 0.5, 0.0F, 0.0F);
                zv.onInitialSpawn(world.getDifficultyForLocation(pos), null);
                zv.setForgeProfession(profession());
                zv.enablePersistence();
                world.spawnEntity(zv);
            } else {
                EntityExtVillager v = new EntityExtVillager(world);
                v.setLocationAndAngles(j + 0.5, k, l + 0.5, 0.0F, 0.0F);
                v.setProfession(profession());
                v.finalizeMobSpawn(world.getDifficultyForLocation(pos), null, false);
                world.spawnEntity(v);
            }
        }
    }

    @Override
    protected void writeStructureToNBT(NBTTagCompound tag) {
        super.writeStructureToNBT(tag);
        tag.setInteger("EVSpawned", spawned);
    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound tag, TemplateManager tm) {
        super.readStructureFromNBT(tag, tm);
        spawned = tag.getInteger("EVSpawned");
    }
}
