package com.electrifiedded.extvil.world;

import java.util.List;
import java.util.Random;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class ExtVillageHandler implements IVillageCreationHandler {
    public interface Builder {
        StructureVillagePieces.Village build(StructureVillagePieces.Start start, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int type);
    }

    private final Class<? extends ComponentExtVillage> cls;
    private final Builder builder;
    private final int weight, max;

    public ExtVillageHandler(Class<? extends ComponentExtVillage> cls, Builder builder, int weight, int max) {
        this.cls = cls; this.builder = builder; this.weight = weight; this.max = max;
    }

    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size) {
        return new StructureVillagePieces.PieceWeight(cls, weight, max);
    }

    @Override
    public Class<?> getComponentClass() {
        return cls;
    }

    @Override
    public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight piece, StructureVillagePieces.Start start, List<StructureComponent> pieces,
                                                         Random random, int x, int y, int z, EnumFacing facing, int type) {
        return builder.build(start, pieces, random, x, y, z, facing, type);
    }
}
