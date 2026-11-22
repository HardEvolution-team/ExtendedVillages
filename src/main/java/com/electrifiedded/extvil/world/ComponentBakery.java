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

public class ComponentBakery extends ComponentExtVillage {
    public ComponentBakery() {}

    public ComponentBakery(StructureVillagePieces.Start start, int type, StructureBoundingBox box, EnumFacing facing) {
        super(start, type, box, facing);
    }

    public static ComponentBakery build(StructureVillagePieces.Start start, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int type) {
        StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 6, 11, facing);
        return canVillageGoDeeper(box) && StructureComponent.findIntersecting(pieces, box) == null ? new ComponentBakery(start, type, box, facing) : null;
    }

    @Override
    protected VillagerProfession profession() {
        return ExtVillagers.BAKER;
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
      IBlockState Floor;
      if (desert) {
         walls = Blocks.SANDSTONE.getDefaultState();
         roof = SMOOTH_SAND;
         IBlockState Deco = Blocks.SANDSTONE.getDefaultState();
         IBlockState Ground = Blocks.SAND.getDefaultState();
         IBlockState Path = Blocks.SANDSTONE.getDefaultState();
         Floor = Blocks.PLANKS.getDefaultState();
      } else {
         walls = Blocks.LOG.getDefaultState();
         roof = Blocks.COBBLESTONE.getDefaultState();
         IBlockState Deco = Blocks.LOG.getDefaultState();
         IBlockState Ground = Blocks.GRASS.getDefaultState();
         Floor = Blocks.PLANKS.getDefaultState();
         IBlockState Path = Blocks.GRAVEL.getDefaultState();
      }

      this.spawnVillagers(world, sbb, 3, 1, 4, 2);
      this.fillWithBlocks(world, sbb, 2, 0, 2, 9, 0, 6, Floor, Floor, false);
      this.fillWithBlocks(world, sbb, 2, 1, 2, 9, 3, 2, walls, walls, false);
      this.setBlockState(world, st(Blocks.AIR.getDefaultState(), 3), 1, 2, 0, sbb);
      this.setBlockState(world, st(Blocks.AIR.getDefaultState(), 3), 2, 2, 0, sbb);
      this.createVillageDoor(world, sbb, random, 3, 1, 2, EnumFacing.NORTH);
      this.fillWithBlocks(world, sbb, 5, 2, 2, 7, 2, 2, Blocks.GLASS.getDefaultState(), Blocks.GLASS.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 2, 1, 2, 2, 4, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 2, 2, 3, 2, 2, 5, Blocks.GLASS.getDefaultState(), Blocks.GLASS.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 3, 1, 6, 9, 3, 6, walls, walls, false);
      this.fillWithBlocks(world, sbb, 3, 2, 6, 7, 2, 6, Blocks.GLASS.getDefaultState(), Blocks.GLASS.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 8, 1, 3, 9, 4, 5, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 9, 5, 4, 9, 7, 4, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 10, 1, 4, 10, 3, 4, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 8, 4, 3, 8, 4, 5, walls, walls, false);
      this.setBlockState(world, st(Blocks.AIR.getDefaultState(), 0), 8, 2, 4, sbb);
      this.setBlockState(world, st(Blocks.FURNACE.getDefaultState(), 0), 9, 2, 4, sbb);
      this.setBlockState(world, st(Blocks.WOODEN_SLAB.getDefaultState(), 0), 4, 1, 4, sbb);
      this.setBlockState(world, st(Blocks.WOODEN_SLAB.getDefaultState(), 0), 4, 1, 5, sbb);
      this.fillWithBlocks(world, sbb, 5, 1, 4, 5, 1, 5, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 5, 2, 4, 5, 2, 5, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 5, 2, 6, 5, 2, 6, walls, walls, true);
      this.fillWithBlocks(world, sbb, 1, 3, 1, 10, 3, 1, roof, roof, false);
      this.fillWithBlocks(world, sbb, 1, 4, 2, 10, 4, 2, roof, roof, false);
      this.fillWithBlocks(world, sbb, 1, 5, 3, 10, 5, 5, roof, roof, false);
      this.fillWithBlocks(world, sbb, 1, 4, 6, 10, 4, 6, roof, roof, false);
      this.fillWithBlocks(world, sbb, 1, 3, 7, 10, 3, 7, roof, roof, false);
      return true;
    }
}
