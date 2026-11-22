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

public class ComponentWindmill extends ComponentExtVillage {
    public ComponentWindmill() {}

    public ComponentWindmill(StructureVillagePieces.Start start, int type, StructureBoundingBox box, EnumFacing facing) {
        super(start, type, box, facing);
    }

    public static ComponentWindmill build(StructureVillagePieces.Start start, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int type) {
        StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 6, 11, facing);
        return canVillageGoDeeper(box) && StructureComponent.findIntersecting(pieces, box) == null ? new ComponentWindmill(start, type, box, facing) : null;
    }

    @Override
    protected VillagerProfession profession() {
        return ExtVillagers.MILLER;
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb) {
        if (!levelToGround(world, sbb)) return true;
      int x = this.boundingBox.minX;
      int y = this.boundingBox.minY;
      int z = this.boundingBox.minZ;
      boolean desert = isDesert(world, x, z);
      IBlockState walls;
      IBlockState roof;
      IBlockState Ground;
      IBlockState Path;
      IBlockState Floor;
      if (desert) {
         walls = Blocks.SANDSTONE.getDefaultState();
         roof = SMOOTH_SAND;
         IBlockState Deco = Blocks.SANDSTONE.getDefaultState();
         Ground = Blocks.SAND.getDefaultState();
         Path = Blocks.SANDSTONE.getDefaultState();
         Floor = Blocks.PLANKS.getDefaultState();
      } else {
         walls = Blocks.COBBLESTONE.getDefaultState();
         roof = Blocks.PLANKS.getDefaultState();
         IBlockState Deco = Blocks.LOG.getDefaultState();
         Ground = Blocks.GRASS.getDefaultState();
         Floor = Blocks.PLANKS.getDefaultState();
         Path = Blocks.GRAVEL.getDefaultState();
      }

      this.fillWithBlocks(world, sbb, 2, 0, 2, 10, 19, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 2, 0, 2, 10, 0, 10, Floor, Floor, false);
      this.fillWithBlocks(world, sbb, 2, 0, 2, 3, 0, 3, Ground, Ground, false);
      this.setBlockState(world, st(Ground, 0), 4, 0, 2, sbb);
      this.setBlockState(world, st(Ground, 0), 2, 0, 4, sbb);
      this.fillWithBlocks(world, sbb, 9, 0, 2, 10, 0, 3, Ground, Ground, false);
      this.setBlockState(world, st(Ground, 0), 8, 0, 2, sbb);
      this.setBlockState(world, st(Ground, 0), 10, 0, 4, sbb);
      this.fillWithBlocks(world, sbb, 9, 0, 9, 10, 0, 10, Ground, Ground, false);
      this.setBlockState(world, st(Ground, 0), 8, 0, 10, sbb);
      this.setBlockState(world, st(Ground, 0), 10, 0, 8, sbb);
      this.fillWithBlocks(world, sbb, 2, 0, 9, 3, 0, 10, Ground, Ground, false);
      this.setBlockState(world, st(Ground, 0), 2, 0, 8, sbb);
      this.setBlockState(world, st(Ground, 0), 4, 0, 10, sbb);
      this.fillWithBlocks(world, sbb, 5, 1, 5, 7, 1, 7, walls, walls, false);
      this.fillWithBlocks(world, sbb, 5, 1, 2, 5, 3, 2, walls, walls, false);
      this.fillWithBlocks(world, sbb, 7, 1, 2, 7, 3, 2, walls, walls, false);
      this.fillWithBlocks(world, sbb, 4, 1, 3, 4, 3, 3, walls, walls, false);
      this.fillWithBlocks(world, sbb, 8, 1, 3, 8, 3, 3, walls, walls, false);
      this.fillWithBlocks(world, sbb, 3, 1, 4, 3, 3, 4, walls, walls, false);
      this.fillWithBlocks(world, sbb, 9, 1, 4, 9, 3, 4, walls, walls, false);
      this.fillWithBlocks(world, sbb, 2, 1, 5, 2, 3, 7, walls, walls, false);
      this.fillWithBlocks(world, sbb, 10, 1, 5, 10, 3, 7, walls, walls, false);
      this.setBlockState(world, st(Blocks.GLASS.getDefaultState(), 0), 10, 2, 6, sbb);
      this.setBlockState(world, st(Blocks.GLASS.getDefaultState(), 0), 2, 2, 6, sbb);
      this.fillWithBlocks(world, sbb, 3, 1, 8, 3, 3, 8, walls, walls, false);
      this.fillWithBlocks(world, sbb, 9, 1, 8, 9, 3, 8, walls, walls, false);
      this.fillWithBlocks(world, sbb, 4, 1, 9, 4, 3, 9, walls, walls, false);
      this.fillWithBlocks(world, sbb, 8, 1, 9, 8, 3, 9, walls, walls, false);
      this.fillWithBlocks(world, sbb, 5, 1, 10, 7, 3, 10, walls, walls, false);
      this.setBlockState(world, st(Blocks.GLASS.getDefaultState(), 0), 6, 2, 10, sbb);
      this.setBlockState(world, st(walls, 0), 6, 3, 2, sbb);
      this.setBlockState(world, st(roof, 0), 5, 3, 1, sbb);
      this.setBlockState(world, st(roof, 0), 6, 3, 1, sbb);
      this.setBlockState(world, st(roof, 0), 7, 3, 1, sbb);
      this.setBlockState(world, st(roof, 0), 8, 3, 2, sbb);
      this.setBlockState(world, st(roof, 0), 9, 3, 3, sbb);
      this.setBlockState(world, st(roof, 0), 10, 3, 4, sbb);
      this.setBlockState(world, st(roof, 0), 11, 3, 5, sbb);
      this.setBlockState(world, st(roof, 0), 11, 3, 6, sbb);
      this.setBlockState(world, st(roof, 0), 11, 3, 7, sbb);
      this.setBlockState(world, st(roof, 0), 10, 3, 8, sbb);
      this.setBlockState(world, st(roof, 0), 9, 3, 9, sbb);
      this.setBlockState(world, st(roof, 0), 8, 3, 10, sbb);
      this.setBlockState(world, st(roof, 0), 7, 3, 11, sbb);
      this.setBlockState(world, st(roof, 0), 6, 3, 11, sbb);
      this.setBlockState(world, st(roof, 0), 5, 3, 11, sbb);
      this.setBlockState(world, st(roof, 0), 4, 3, 10, sbb);
      this.setBlockState(world, st(roof, 0), 3, 3, 9, sbb);
      this.setBlockState(world, st(roof, 0), 2, 3, 8, sbb);
      this.setBlockState(world, st(roof, 0), 1, 3, 7, sbb);
      this.setBlockState(world, st(roof, 0), 1, 3, 6, sbb);
      this.setBlockState(world, st(roof, 0), 1, 3, 5, sbb);
      this.setBlockState(world, st(roof, 0), 2, 3, 4, sbb);
      this.setBlockState(world, st(roof, 0), 3, 3, 3, sbb);
      this.setBlockState(world, st(roof, 0), 4, 3, 2, sbb);
      this.setBlockState(world, st(roof, 0), 5, 4, 2, sbb);
      this.setBlockState(world, st(roof, 0), 6, 4, 2, sbb);
      this.setBlockState(world, st(roof, 0), 7, 4, 2, sbb);
      this.setBlockState(world, st(roof, 0), 8, 4, 3, sbb);
      this.setBlockState(world, st(roof, 0), 9, 4, 4, sbb);
      this.setBlockState(world, st(roof, 0), 10, 4, 5, sbb);
      this.setBlockState(world, st(roof, 0), 10, 4, 6, sbb);
      this.setBlockState(world, st(roof, 0), 10, 4, 7, sbb);
      this.setBlockState(world, st(roof, 0), 9, 4, 8, sbb);
      this.setBlockState(world, st(roof, 0), 8, 4, 9, sbb);
      this.setBlockState(world, st(roof, 0), 7, 4, 10, sbb);
      this.setBlockState(world, st(roof, 0), 6, 4, 10, sbb);
      this.setBlockState(world, st(roof, 0), 5, 4, 10, sbb);
      this.setBlockState(world, st(roof, 0), 4, 4, 9, sbb);
      this.setBlockState(world, st(roof, 0), 3, 4, 8, sbb);
      this.setBlockState(world, st(roof, 0), 2, 4, 7, sbb);
      this.setBlockState(world, st(roof, 0), 2, 4, 6, sbb);
      this.setBlockState(world, st(roof, 0), 2, 4, 5, sbb);
      this.setBlockState(world, st(roof, 0), 3, 4, 4, sbb);
      this.setBlockState(world, st(roof, 0), 4, 4, 3, sbb);
      this.setBlockState(world, st(roof, 0), 5, 5, 3, sbb);
      this.setBlockState(world, st(roof, 0), 6, 5, 3, sbb);
      this.setBlockState(world, st(roof, 0), 7, 5, 3, sbb);
      this.setBlockState(world, st(roof, 0), 8, 5, 4, sbb);
      this.setBlockState(world, st(roof, 0), 9, 5, 5, sbb);
      this.setBlockState(world, st(roof, 0), 9, 5, 6, sbb);
      this.setBlockState(world, st(roof, 0), 9, 5, 7, sbb);
      this.setBlockState(world, st(roof, 0), 8, 5, 8, sbb);
      this.setBlockState(world, st(roof, 0), 7, 5, 9, sbb);
      this.setBlockState(world, st(roof, 0), 6, 5, 9, sbb);
      this.setBlockState(world, st(roof, 0), 5, 5, 9, sbb);
      this.setBlockState(world, st(roof, 0), 4, 5, 8, sbb);
      this.setBlockState(world, st(roof, 0), 3, 5, 7, sbb);
      this.setBlockState(world, st(roof, 0), 3, 5, 6, sbb);
      this.setBlockState(world, st(roof, 0), 3, 5, 5, sbb);
      this.setBlockState(world, st(roof, 0), 4, 5, 4, sbb);
      this.setBlockState(world, st(roof, 0), 6, 6, 3, sbb);
      this.setBlockState(world, st(roof, 0), 7, 6, 4, sbb);
      this.setBlockState(world, st(roof, 0), 8, 6, 5, sbb);
      this.setBlockState(world, st(roof, 0), 9, 6, 6, sbb);
      this.setBlockState(world, st(roof, 0), 8, 6, 7, sbb);
      this.setBlockState(world, st(roof, 0), 7, 6, 8, sbb);
      this.setBlockState(world, st(roof, 0), 6, 6, 9, sbb);
      this.setBlockState(world, st(roof, 0), 5, 6, 8, sbb);
      this.setBlockState(world, st(roof, 0), 4, 6, 7, sbb);
      this.setBlockState(world, st(roof, 0), 3, 6, 6, sbb);
      this.setBlockState(world, st(roof, 0), 4, 6, 5, sbb);
      this.setBlockState(world, st(roof, 0), 5, 6, 4, sbb);
      this.fillWithBlocks(world, sbb, 6, 7, 4, 6, 13, 4, walls, walls, false);
      this.fillWithBlocks(world, sbb, 7, 7, 5, 7, 13, 5, walls, walls, false);
      this.fillWithBlocks(world, sbb, 8, 7, 6, 8, 13, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 7, 7, 7, 7, 13, 7, walls, walls, false);
      this.fillWithBlocks(world, sbb, 6, 7, 8, 6, 13, 8, walls, walls, false);
      this.fillWithBlocks(world, sbb, 5, 7, 7, 5, 13, 7, walls, walls, false);
      this.fillWithBlocks(world, sbb, 4, 7, 6, 4, 13, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 5, 7, 5, 5, 13, 5, walls, walls, false);
      this.fillWithBlocks(world, sbb, 6, 2, 6, 6, 14, 6, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 3, 13, 4, 4, 13, 5, roof, roof, false);
      this.fillWithBlocks(world, sbb, 8, 13, 4, 9, 13, 5, roof, roof, false);
      this.setBlockState(world, st(roof, 0), 7, 13, 4, sbb);
      this.setBlockState(world, st(roof, 0), 5, 13, 4, sbb);
      this.setBlockState(world, st(roof, 0), 3, 13, 6, sbb);
      this.setBlockState(world, st(roof, 0), 4, 13, 7, sbb);
      this.setBlockState(world, st(roof, 0), 5, 13, 8, sbb);
      this.setBlockState(world, st(roof, 0), 6, 13, 9, sbb);
      this.setBlockState(world, st(roof, 0), 7, 13, 8, sbb);
      this.setBlockState(world, st(roof, 0), 8, 13, 7, sbb);
      this.setBlockState(world, st(roof, 0), 9, 13, 6, sbb);
      this.fillWithBlocks(world, sbb, 4, 14, 4, 4, 14, 6, roof, roof, false);
      this.fillWithBlocks(world, sbb, 8, 14, 4, 8, 14, 6, roof, roof, false);
      this.fillWithBlocks(world, sbb, 5, 14, 7, 7, 14, 7, roof, roof, false);
      this.setBlockState(world, st(roof, 0), 6, 14, 8, sbb);
      this.fillWithBlocks(world, sbb, 5, 15, 4, 7, 15, 6, roof, roof, false);
      this.fillWithBlocks(world, sbb, 6, 16, 4, 6, 16, 5, roof, roof, false);
      this.fillWithBlocks(world, sbb, 5, 14, 4, 5, 14, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 7, 14, 4, 7, 14, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 6, 14, 2, 6, 14, 5, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 2, 10, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 3, 11, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 4, 12, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 5, 13, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 2, 11, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 3, 12, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 4, 13, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 10, 10, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 9, 11, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 8, 12, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 7, 13, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 9, 10, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 8, 11, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 7, 12, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 10, 18, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 9, 17, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 8, 16, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 7, 15, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 10, 17, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 9, 16, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 8, 15, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 5, 15, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 4, 16, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 3, 17, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 0), 2, 18, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 4, 17, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 3, 18, 2, sbb);
      this.setBlockState(world, st(Blocks.WOOL.getDefaultState(), 14), 5, 16, 2, sbb);
      this.createVillageDoor(world, sbb, random, 6, 1, 2, EnumFacing.NORTH);
      this.setBlockState(world, st(Path, 0), 6, 0, 0, sbb);
      this.setBlockState(world, st(Path, 0), 6, 0, 1, sbb);
      this.spawnVillagers(world, sbb, 0, 1, 0, 2);
      return true;
    }
}
