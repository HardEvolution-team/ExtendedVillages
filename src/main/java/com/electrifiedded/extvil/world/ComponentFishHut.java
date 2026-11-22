package com.electrifiedded.extvil.world;

import com.electrifiedded.extvil.ExtVillagers;
import java.util.List;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class ComponentFishHut extends ComponentExtVillage {
    public ComponentFishHut() {}

    public ComponentFishHut(StructureVillagePieces.Start start, int type, StructureBoundingBox box, EnumFacing facing) {
        super(start, type, box, facing);
    }

    public static ComponentFishHut build(StructureVillagePieces.Start start, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int type) {
        StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 6, 11, facing);
        return canVillageGoDeeper(box) && StructureComponent.findIntersecting(pieces, box) == null ? new ComponentFishHut(start, type, box, facing) : null;
    }

    @Override
    protected VillagerProfession profession() {
        return ExtVillagers.FISHER;
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb) {
        if (!levelToGround(world, sbb)) return true;
      int x = this.boundingBox.minX;
      int y = this.boundingBox.minY;
      int z = this.boundingBox.minZ;
      this.spawnVillagers(world, sbb, 0, 1, 0, 2);
      boolean desert = isDesert(world, x, z);
      IBlockState walls;
      IBlockState roof;
      IBlockState Deco;
      IBlockState Ground;
      IBlockState Floor;
      if (desert) {
         walls = Blocks.SANDSTONE.getDefaultState();
         roof = SMOOTH_SAND;
         Deco = DECO_SAND;
         Ground = Blocks.SAND.getDefaultState();
         IBlockState Path = Blocks.SANDSTONE.getDefaultState();
         Floor = Blocks.PLANKS.getDefaultState();
      } else {
         walls = Blocks.COBBLESTONE.getDefaultState();
         roof = Blocks.PLANKS.getDefaultState();
         Deco = Blocks.LOG.getDefaultState();
         Ground = Blocks.GRASS.getDefaultState();
         Floor = Blocks.PLANKS.getDefaultState();
      }

      this.fillWithBlocks(world, sbb, 1, 0, 5, 5, 0, 12, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
      this.setBlockState(world, st(Ground, 0), 1, 0, 5, sbb);
      this.setBlockState(world, st(Ground, 0), 1, 0, 6, sbb);
      this.setBlockState(world, st(Ground, 0), 1, 0, 12, sbb);
      this.setBlockState(world, st(Deco, 0), 3, 0, 7, sbb);
      this.fillWithBlocks(world, sbb, 6, 0, 6, 6, 0, 14, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 7, 0, 8, 12, 0, 15, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
      this.setBlockState(world, st(Ground, 0), 7, 0, 14, sbb);
      this.setBlockState(world, st(Ground, 0), 8, 0, 14, sbb);
      this.fillWithBlocks(world, sbb, 8, 0, 8, 12, 0, 8, Ground, Ground, false);
      this.fillWithBlocks(world, sbb, 9, 0, 9, 10, 0, 9, Ground, Ground, false);
      this.fillWithBlocks(world, sbb, 9, 1, 9, 10, 2, 9, Blocks.REEDS.getDefaultState(), Blocks.REEDS.getDefaultState(), false);
      this.setBlockState(world, st(Ground, 0), 11, 0, 14, sbb);
      this.setBlockState(world, st(Ground, 0), 11, 0, 13, sbb);
      this.setBlockState(world, st(Ground, 0), 12, 0, 14, sbb);
      this.setBlockState(world, st(Ground, 0), 12, 0, 13, sbb);
      this.setBlockState(world, st(Ground, 0), 12, 0, 12, sbb);
      this.setBlockState(world, st(Blocks.OAK_FENCE.getDefaultState(), 0), 10, 1, 1, sbb);
      this.setBlockState(world, st(Blocks.OAK_FENCE.getDefaultState(), 0), 9, 2, 1, sbb);
      this.setBlockState(world, st(Blocks.OAK_FENCE.getDefaultState(), 0), 8, 3, 1, sbb);
      this.setBlockState(world, st(Blocks.OAK_FENCE.getDefaultState(), 0), 7, 4, 1, sbb);
      this.setBlockState(world, st(Blocks.OAK_FENCE.getDefaultState(), 0), 6, 4, 1, sbb);
      this.setBlockState(world, st(Blocks.OAK_FENCE.getDefaultState(), 0), 6, 4, 2, sbb);
      this.setBlockState(world, st(Deco, 0), 9, 1, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 8, 1, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 7, 1, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 6, 1, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 8, 2, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 7, 2, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 6, 2, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 7, 3, 1, sbb);
      this.setBlockState(world, st(Deco, 0), 6, 3, 1, sbb);
      this.setBlockState(world, st(Floor, 0), 9, 1, 2, sbb);
      this.setBlockState(world, st(Floor, 0), 8, 2, 2, sbb);
      this.setBlockState(world, st(Floor, 0), 7, 3, 2, sbb);
      this.fillWithBlocks(world, sbb, 6, 1, 2, 6, 3, 2, Deco, Deco, false);
      this.setBlockState(world, st(Blocks.OAK_FENCE.getDefaultState(), 0), 6, 4, 2, sbb);
      this.fillWithBlocks(world, sbb, 3, 3, 3, 10, 3, 7, Floor, Floor, false);
      this.fillWithBlocks(world, sbb, 10, 1, 3, 10, 6, 3, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 4, 2, 3, 9, 2, 3, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 3, 1, 3, 3, 6, 3, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 4, 4, 3, 10, 5, 3, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 4, 6, 3, 9, 6, 3, Floor, Floor, false);
      this.setBlockState(world, st(Deco, 0), 6, 6, 3, sbb);
      this.setBlockState(world, st(Deco, 0), 8, 6, 3, sbb);
      this.setBlockState(world, st(Blocks.GLASS.getDefaultState(), 0), 4, 5, 3, sbb);
      this.setBlockState(world, st(Blocks.GLASS.getDefaultState(), 0), 5, 5, 3, sbb);
      this.setBlockState(world, st(Blocks.GLASS.getDefaultState(), 0), 9, 5, 3, sbb);
      this.setBlockState(world, st(Blocks.AIR.getDefaultState(), 0), 7, 5, 3, sbb);
      this.setBlockState(world, st(Blocks.AIR.getDefaultState(), 0), 7, 4, 3, sbb);
      this.fillWithBlocks(world, sbb, 2, 6, 2, 11, 6, 2, roof, roof, false);
      this.fillWithBlocks(world, sbb, 2, 7, 3, 11, 7, 3, roof, roof, false);
      this.fillWithBlocks(world, sbb, 2, 8, 4, 11, 8, 4, roof, roof, false);
      this.fillWithBlocks(world, sbb, 2, 9, 5, 11, 9, 5, roof, roof, false);
      this.fillWithBlocks(world, sbb, 2, 8, 6, 11, 8, 6, roof, roof, false);
      this.fillWithBlocks(world, sbb, 2, 7, 7, 11, 7, 7, roof, roof, false);
      this.fillWithBlocks(world, sbb, 2, 6, 8, 11, 6, 8, roof, roof, false);
      this.fillWithBlocks(world, sbb, 3, 2, 4, 3, 2, 6, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 3, 4, 4, 3, 4, 6, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 3, 5, 4, 3, 5, 6, Blocks.GLASS.getDefaultState(), Blocks.GLASS.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 3, 6, 4, 3, 6, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 3, 7, 4, 3, 7, 6, walls, walls, false);
      this.setBlockState(world, st(walls, 0), 3, 8, 5, sbb);
      this.fillWithBlocks(world, sbb, 10, 2, 4, 10, 2, 6, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 10, 4, 4, 10, 4, 6, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 10, 5, 4, 10, 5, 6, Blocks.GLASS.getDefaultState(), Blocks.GLASS.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 10, 6, 4, 10, 6, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 10, 7, 4, 10, 7, 6, walls, walls, false);
      this.setBlockState(world, st(walls, 0), 10, 8, 5, sbb);
      this.fillWithBlocks(world, sbb, 3, 1, 7, 3, 6, 7, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 10, 1, 7, 10, 6, 7, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 4, 2, 7, 9, 2, 7, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 4, 4, 7, 9, 4, 7, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 4, 5, 7, 9, 5, 7, Blocks.GLASS.getDefaultState(), Blocks.GLASS.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 4, 6, 7, 9, 6, 7, Floor, Floor, false);
      this.createVillageDoor(world, sbb, random, 7, 4, 3, EnumFacing.NORTH);
      return true;
    }
}
