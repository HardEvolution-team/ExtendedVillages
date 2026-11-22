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

public class ComponentMiner extends ComponentExtVillage {
    public ComponentMiner() {}

    public ComponentMiner(StructureVillagePieces.Start start, int type, StructureBoundingBox box, EnumFacing facing) {
        super(start, type, box, facing);
    }

    public static ComponentMiner build(StructureVillagePieces.Start start, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int type) {
        StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 6, 11, facing);
        return canVillageGoDeeper(box) && StructureComponent.findIntersecting(pieces, box) == null ? new ComponentMiner(start, type, box, facing) : null;
    }

    @Override
    protected VillagerProfession profession() {
        return ExtVillagers.MINER;
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb) {
        if (!levelToGround(world, sbb)) return true;
      int x = this.boundingBox.minX;
      int y = this.boundingBox.minY;
      int z = this.boundingBox.minZ;
      boolean desert = isDesert(world, x, z);
      IBlockState roof;
      IBlockState Deco;
      if (desert) {
         IBlockState walls = Blocks.SANDSTONE.getDefaultState();
         roof = SMOOTH_SAND;
         Deco = Blocks.OAK_FENCE.getDefaultState();
         IBlockState Ground = Blocks.SAND.getDefaultState();
         IBlockState Path = Blocks.SANDSTONE.getDefaultState();
         IBlockState Floor = Blocks.PLANKS.getDefaultState();
      } else {
         IBlockState walls = Blocks.COBBLESTONE.getDefaultState();
         roof = Blocks.LOG.getDefaultState();
         Deco = Blocks.OAK_FENCE.getDefaultState();
         IBlockState Ground = Blocks.GRASS.getDefaultState();
         IBlockState Floor = Blocks.PLANKS.getDefaultState();
         IBlockState Path = Blocks.GRAVEL.getDefaultState();
      }

      this.fillWithBlocks(world, sbb, 1, 1, 1, 1, 14, 1, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 5, 1, 1, 5, 14, 1, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 5, 1, 5, 5, 14, 5, Deco, Deco, false);
      this.fillWithBlocks(world, sbb, 1, 1, 5, 1, 14, 5, Deco, Deco, false);
      this.setBlockState(world, st(roof, 0), 1, 0, 1, sbb);
      this.setBlockState(world, st(roof, 0), 1, 0, 5, sbb);
      this.setBlockState(world, st(roof, 0), 5, 0, 1, sbb);
      this.setBlockState(world, st(roof, 0), 5, 0, 5, sbb);
      this.setBlockState(world, st(roof, 0), 4, 1, 1, sbb);
      this.setBlockState(world, st(roof, 0), 3, 2, 1, sbb);
      this.setBlockState(world, st(roof, 0), 2, 3, 1, sbb);
      this.setBlockState(world, st(roof, 0), 2, 5, 1, sbb);
      this.setBlockState(world, st(roof, 0), 3, 6, 1, sbb);
      this.setBlockState(world, st(roof, 0), 4, 7, 1, sbb);
      this.setBlockState(world, st(roof, 0), 4, 9, 1, sbb);
      this.setBlockState(world, st(roof, 0), 3, 10, 1, sbb);
      this.setBlockState(world, st(roof, 0), 2, 11, 1, sbb);
      this.fillWithBlocks(world, sbb, 2, 13, 1, 4, 13, 1, roof, roof, false);
      this.setBlockState(world, st(roof, 0), 5, 1, 4, sbb);
      this.setBlockState(world, st(roof, 0), 5, 2, 3, sbb);
      this.setBlockState(world, st(roof, 0), 5, 3, 2, sbb);
      this.setBlockState(world, st(roof, 0), 5, 5, 2, sbb);
      this.setBlockState(world, st(roof, 0), 5, 6, 3, sbb);
      this.setBlockState(world, st(roof, 0), 5, 7, 4, sbb);
      this.setBlockState(world, st(roof, 0), 5, 9, 4, sbb);
      this.setBlockState(world, st(roof, 0), 5, 10, 3, sbb);
      this.setBlockState(world, st(roof, 0), 5, 11, 2, sbb);
      this.fillWithBlocks(world, sbb, 5, 13, 2, 5, 13, 4, roof, roof, false);
      this.setBlockState(world, st(roof, 0), 2, 1, 5, sbb);
      this.setBlockState(world, st(roof, 0), 3, 2, 5, sbb);
      this.setBlockState(world, st(roof, 0), 4, 3, 5, sbb);
      this.setBlockState(world, st(roof, 0), 4, 5, 5, sbb);
      this.setBlockState(world, st(roof, 0), 3, 6, 5, sbb);
      this.setBlockState(world, st(roof, 0), 2, 7, 5, sbb);
      this.setBlockState(world, st(roof, 0), 2, 9, 5, sbb);
      this.setBlockState(world, st(roof, 0), 3, 10, 5, sbb);
      this.setBlockState(world, st(roof, 0), 4, 11, 5, sbb);
      this.fillWithBlocks(world, sbb, 2, 13, 5, 4, 13, 5, roof, roof, false);
      this.setBlockState(world, st(roof, 0), 1, 1, 2, sbb);
      this.setBlockState(world, st(roof, 0), 1, 2, 3, sbb);
      this.setBlockState(world, st(roof, 0), 1, 3, 4, sbb);
      this.setBlockState(world, st(roof, 0), 1, 5, 4, sbb);
      this.setBlockState(world, st(roof, 0), 1, 6, 3, sbb);
      this.setBlockState(world, st(roof, 0), 1, 7, 2, sbb);
      this.setBlockState(world, st(roof, 0), 1, 9, 2, sbb);
      this.setBlockState(world, st(roof, 0), 1, 10, 3, sbb);
      this.setBlockState(world, st(roof, 0), 1, 11, 4, sbb);
      this.fillWithBlocks(world, sbb, 1, 13, 2, 1, 13, 4, roof, roof, false);
      int dept = new Random().nextInt(5) + 2;
      this.fillWithBlocks(world, sbb, 2, -dept, 2, 4, 0, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), true);
      this.fillWithBlocks(world, sbb, 3, 14, 1, 3, 14, 5, Blocks.COBBLESTONE_WALL.getDefaultState(), Blocks.COBBLESTONE_WALL.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 1, 14, 3, 5, 14, 3, Blocks.COBBLESTONE_WALL.getDefaultState(), Blocks.COBBLESTONE_WALL.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 3, -1, 3, 3, 13, 3, Blocks.COBBLESTONE_WALL.getDefaultState(), Blocks.COBBLESTONE_WALL.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 3, -1, 2, 3, -1, 4, Blocks.COBBLESTONE_WALL.getDefaultState(), Blocks.COBBLESTONE_WALL.getDefaultState(), false);
      this.fillWithBlocks(world, sbb, 2, -1, 3, 4, -1, 3, Blocks.COBBLESTONE_WALL.getDefaultState(), Blocks.COBBLESTONE_WALL.getDefaultState(), false);
      this.spawnVillagers(world, sbb, 0, 1, 0, 2);
      return true;
    }
}
