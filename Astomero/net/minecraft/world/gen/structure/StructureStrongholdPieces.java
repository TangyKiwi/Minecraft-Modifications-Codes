package net.minecraft.world.gen.structure;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;

public class StructureStrongholdPieces
{
    private static final PieceWeight[] pieceWeightArray;
    private static List<PieceWeight> structurePieceList;
    private static Class<? extends Stronghold> strongComponentType;
    static int totalWeight;
    private static final Stones strongholdStones;
    
    public static void registerStrongholdPieces() {
        MapGenStructureIO.registerStructureComponent(ChestCorridor.class, "SHCC");
        MapGenStructureIO.registerStructureComponent(Corridor.class, "SHFC");
        MapGenStructureIO.registerStructureComponent(Crossing.class, "SH5C");
        MapGenStructureIO.registerStructureComponent(LeftTurn.class, "SHLT");
        MapGenStructureIO.registerStructureComponent(Library.class, "SHLi");
        MapGenStructureIO.registerStructureComponent(PortalRoom.class, "SHPR");
        MapGenStructureIO.registerStructureComponent(Prison.class, "SHPH");
        MapGenStructureIO.registerStructureComponent(RightTurn.class, "SHRT");
        MapGenStructureIO.registerStructureComponent(RoomCrossing.class, "SHRC");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "SHSD");
        MapGenStructureIO.registerStructureComponent(Stairs2.class, "SHStart");
        MapGenStructureIO.registerStructureComponent(Straight.class, "SHS");
        MapGenStructureIO.registerStructureComponent(StairsStraight.class, "SHSSD");
    }
    
    public static void prepareStructurePieces() {
        StructureStrongholdPieces.structurePieceList = (List<PieceWeight>)Lists.newArrayList();
        for (final PieceWeight structurestrongholdpieces$pieceweight : StructureStrongholdPieces.pieceWeightArray) {
            structurestrongholdpieces$pieceweight.instancesSpawned = 0;
            StructureStrongholdPieces.structurePieceList.add(structurestrongholdpieces$pieceweight);
        }
        StructureStrongholdPieces.strongComponentType = null;
    }
    
    private static boolean canAddStructurePieces() {
        boolean flag = false;
        StructureStrongholdPieces.totalWeight = 0;
        for (final PieceWeight structurestrongholdpieces$pieceweight : StructureStrongholdPieces.structurePieceList) {
            if (structurestrongholdpieces$pieceweight.instancesLimit > 0 && structurestrongholdpieces$pieceweight.instancesSpawned < structurestrongholdpieces$pieceweight.instancesLimit) {
                flag = true;
            }
            StructureStrongholdPieces.totalWeight += structurestrongholdpieces$pieceweight.pieceWeight;
        }
        return flag;
    }
    
    private static Stronghold func_175954_a(final Class<? extends Stronghold> p_175954_0_, final List<StructureComponent> p_175954_1_, final Random p_175954_2_, final int p_175954_3_, final int p_175954_4_, final int p_175954_5_, final EnumFacing p_175954_6_, final int p_175954_7_) {
        Stronghold structurestrongholdpieces$stronghold = null;
        if (p_175954_0_ == Straight.class) {
            structurestrongholdpieces$stronghold = Straight.func_175862_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == Prison.class) {
            structurestrongholdpieces$stronghold = Prison.func_175860_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == LeftTurn.class) {
            structurestrongholdpieces$stronghold = LeftTurn.func_175867_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == RightTurn.class) {
            structurestrongholdpieces$stronghold = LeftTurn.func_175867_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == RoomCrossing.class) {
            structurestrongholdpieces$stronghold = RoomCrossing.func_175859_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StairsStraight.class) {
            structurestrongholdpieces$stronghold = StairsStraight.func_175861_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == Stairs.class) {
            structurestrongholdpieces$stronghold = Stairs.func_175863_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == Crossing.class) {
            structurestrongholdpieces$stronghold = Crossing.func_175866_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == ChestCorridor.class) {
            structurestrongholdpieces$stronghold = ChestCorridor.func_175868_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == Library.class) {
            structurestrongholdpieces$stronghold = Library.func_175864_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == PortalRoom.class) {
            structurestrongholdpieces$stronghold = PortalRoom.func_175865_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        return structurestrongholdpieces$stronghold;
    }
    
    private static Stronghold func_175955_b(final Stairs2 p_175955_0_, final List<StructureComponent> p_175955_1_, final Random p_175955_2_, final int p_175955_3_, final int p_175955_4_, final int p_175955_5_, final EnumFacing p_175955_6_, final int p_175955_7_) {
        if (!canAddStructurePieces()) {
            return null;
        }
        if (StructureStrongholdPieces.strongComponentType != null) {
            final Stronghold structurestrongholdpieces$stronghold = func_175954_a(StructureStrongholdPieces.strongComponentType, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);
            StructureStrongholdPieces.strongComponentType = null;
            if (structurestrongholdpieces$stronghold != null) {
                return structurestrongholdpieces$stronghold;
            }
        }
        int j = 0;
        while (j < 5) {
            ++j;
            int i = p_175955_2_.nextInt(StructureStrongholdPieces.totalWeight);
            for (final PieceWeight structurestrongholdpieces$pieceweight : StructureStrongholdPieces.structurePieceList) {
                i -= structurestrongholdpieces$pieceweight.pieceWeight;
                if (i < 0) {
                    if (!structurestrongholdpieces$pieceweight.canSpawnMoreStructuresOfType(p_175955_7_)) {
                        break;
                    }
                    if (structurestrongholdpieces$pieceweight == p_175955_0_.strongholdPieceWeight) {
                        break;
                    }
                    final Stronghold structurestrongholdpieces$stronghold2 = func_175954_a(structurestrongholdpieces$pieceweight.pieceClass, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);
                    if (structurestrongholdpieces$stronghold2 != null) {
                        final PieceWeight pieceWeight = structurestrongholdpieces$pieceweight;
                        ++pieceWeight.instancesSpawned;
                        p_175955_0_.strongholdPieceWeight = structurestrongholdpieces$pieceweight;
                        if (!structurestrongholdpieces$pieceweight.canSpawnMoreStructures()) {
                            StructureStrongholdPieces.structurePieceList.remove(structurestrongholdpieces$pieceweight);
                        }
                        return structurestrongholdpieces$stronghold2;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox structureboundingbox = Corridor.func_175869_a(p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_);
        if (structureboundingbox != null && structureboundingbox.minY > 1) {
            return new Corridor(p_175955_7_, p_175955_2_, structureboundingbox, p_175955_6_);
        }
        return null;
    }
    
    private static StructureComponent func_175953_c(final Stairs2 p_175953_0_, final List<StructureComponent> p_175953_1_, final Random p_175953_2_, final int p_175953_3_, final int p_175953_4_, final int p_175953_5_, final EnumFacing p_175953_6_, final int p_175953_7_) {
        if (p_175953_7_ > 50) {
            return null;
        }
        if (Math.abs(p_175953_3_ - p_175953_0_.getBoundingBox().minX) <= 112 && Math.abs(p_175953_5_ - p_175953_0_.getBoundingBox().minZ) <= 112) {
            final StructureComponent structurecomponent = func_175955_b(p_175953_0_, p_175953_1_, p_175953_2_, p_175953_3_, p_175953_4_, p_175953_5_, p_175953_6_, p_175953_7_ + 1);
            if (structurecomponent != null) {
                p_175953_1_.add(structurecomponent);
                p_175953_0_.field_75026_c.add(structurecomponent);
            }
            return structurecomponent;
        }
        return null;
    }
    
    static {
        pieceWeightArray = new PieceWeight[] { new PieceWeight(Straight.class, 40, 0), new PieceWeight(Prison.class, 5, 5), new PieceWeight(LeftTurn.class, 20, 0), new PieceWeight(RightTurn.class, 20, 0), new PieceWeight(RoomCrossing.class, 10, 6), new PieceWeight(StairsStraight.class, 5, 5), new PieceWeight(Stairs.class, 5, 5), new PieceWeight(Crossing.class, 5, 4), new PieceWeight(ChestCorridor.class, 5, 4), new PieceWeight(Library.class, 10, 2) {
                @Override
                public boolean canSpawnMoreStructuresOfType(final int p_75189_1_) {
                    return super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 4;
                }
            }, new PieceWeight(PortalRoom.class, 20, 1) {
                @Override
                public boolean canSpawnMoreStructuresOfType(final int p_75189_1_) {
                    return super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 5;
                }
            } };
        strongholdStones = new Stones();
    }
    
    public static class ChestCorridor extends Stronghold
    {
        private static final List<WeightedRandomChestContent> strongholdChestContents;
        private boolean hasMadeChest;
        
        public ChestCorridor() {
        }
        
        public ChestCorridor(final int p_i45582_1_, final Random p_i45582_2_, final StructureBoundingBox p_i45582_3_, final EnumFacing p_i45582_4_) {
            super(p_i45582_1_);
            this.coordBaseMode = p_i45582_4_;
            this.field_143013_d = this.getRandomDoor(p_i45582_2_);
            this.boundingBox = p_i45582_3_;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Chest", this.hasMadeChest);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.hasMadeChest = tagCompound.getBoolean("Chest");
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
        }
        
        public static ChestCorridor func_175868_a(final List<StructureComponent> p_175868_0_, final Random p_175868_1_, final int p_175868_2_, final int p_175868_3_, final int p_175868_4_, final EnumFacing p_175868_5_, final int p_175868_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175868_2_, p_175868_3_, p_175868_4_, -1, -1, 0, 5, 5, 7, p_175868_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175868_0_, structureboundingbox) == null) ? new ChestCorridor(p_175868_6_, p_175868_1_, structureboundingbox, p_175868_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 4, 6, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 1, 1, 0);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, Door.OPENING, 1, 1, 6);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 1, 2, 3, 1, 4, Blocks.stonebrick.getDefaultState(), Blocks.stonebrick.getDefaultState(), false);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 1, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 1, 5, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 2, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 2, 4, structureBoundingBoxIn);
            for (int i = 2; i <= 4; ++i) {
                this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 2, 1, i, structureBoundingBoxIn);
            }
            if (!this.hasMadeChest && structureBoundingBoxIn.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
                this.hasMadeChest = true;
                this.generateChestContents(worldIn, structureBoundingBoxIn, randomIn, 3, 2, 3, WeightedRandomChestContent.func_177629_a(ChestCorridor.strongholdChestContents, Items.enchanted_book.getRandom(randomIn)), 2 + randomIn.nextInt(2));
            }
            return true;
        }
        
        static {
            strongholdChestContents = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.ender_pearl, 0, 1, 1, 10), new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_helmet, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_leggings, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 1), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1) });
        }
    }
    
    public static class Corridor extends Stronghold
    {
        private int field_74993_a;
        
        public Corridor() {
        }
        
        public Corridor(final int p_i45581_1_, final Random p_i45581_2_, final StructureBoundingBox p_i45581_3_, final EnumFacing p_i45581_4_) {
            super(p_i45581_1_);
            this.coordBaseMode = p_i45581_4_;
            this.boundingBox = p_i45581_3_;
            this.field_74993_a = ((p_i45581_4_ != EnumFacing.NORTH && p_i45581_4_ != EnumFacing.SOUTH) ? p_i45581_3_.getXSize() : p_i45581_3_.getZSize());
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setInteger("Steps", this.field_74993_a);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.field_74993_a = tagCompound.getInteger("Steps");
        }
        
        public static StructureBoundingBox func_175869_a(final List<StructureComponent> p_175869_0_, final Random p_175869_1_, final int p_175869_2_, final int p_175869_3_, final int p_175869_4_, final EnumFacing p_175869_5_) {
            final int i = 3;
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, 4, p_175869_5_);
            final StructureComponent structurecomponent = StructureComponent.findIntersecting(p_175869_0_, structureboundingbox);
            if (structurecomponent == null) {
                return null;
            }
            if (structurecomponent.getBoundingBox().minY == structureboundingbox.minY) {
                for (int j = 3; j >= 1; --j) {
                    structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, j - 1, p_175869_5_);
                    if (!structurecomponent.getBoundingBox().intersectsWith(structureboundingbox)) {
                        return StructureBoundingBox.getComponentToAddBoundingBox(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, j, p_175869_5_);
                    }
                }
            }
            return null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            for (int i = 0; i < this.field_74993_a; ++i) {
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 0, 0, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 0, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 2, 0, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3, 0, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 4, 0, i, structureBoundingBoxIn);
                for (int j = 1; j <= 3; ++j) {
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 0, j, i, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.air.getDefaultState(), 1, j, i, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.air.getDefaultState(), 2, j, i, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.air.getDefaultState(), 3, j, i, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 4, j, i, structureBoundingBoxIn);
                }
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 0, 4, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 4, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 2, 4, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3, 4, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 4, 4, i, structureBoundingBoxIn);
            }
            return true;
        }
    }
    
    public static class Crossing extends Stronghold
    {
        private boolean field_74996_b;
        private boolean field_74997_c;
        private boolean field_74995_d;
        private boolean field_74999_h;
        
        public Crossing() {
        }
        
        public Crossing(final int p_i45580_1_, final Random p_i45580_2_, final StructureBoundingBox p_i45580_3_, final EnumFacing p_i45580_4_) {
            super(p_i45580_1_);
            this.coordBaseMode = p_i45580_4_;
            this.field_143013_d = this.getRandomDoor(p_i45580_2_);
            this.boundingBox = p_i45580_3_;
            this.field_74996_b = p_i45580_2_.nextBoolean();
            this.field_74997_c = p_i45580_2_.nextBoolean();
            this.field_74995_d = p_i45580_2_.nextBoolean();
            this.field_74999_h = (p_i45580_2_.nextInt(3) > 0);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("leftLow", this.field_74996_b);
            tagCompound.setBoolean("leftHigh", this.field_74997_c);
            tagCompound.setBoolean("rightLow", this.field_74995_d);
            tagCompound.setBoolean("rightHigh", this.field_74999_h);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.field_74996_b = tagCompound.getBoolean("leftLow");
            this.field_74997_c = tagCompound.getBoolean("leftHigh");
            this.field_74995_d = tagCompound.getBoolean("rightLow");
            this.field_74999_h = tagCompound.getBoolean("rightHigh");
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            int i = 3;
            int j = 5;
            if (this.coordBaseMode == EnumFacing.WEST || this.coordBaseMode == EnumFacing.NORTH) {
                i = 8 - i;
                j = 8 - j;
            }
            this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 5, 1);
            if (this.field_74996_b) {
                this.getNextComponentX((Stairs2)componentIn, listIn, rand, i, 1);
            }
            if (this.field_74997_c) {
                this.getNextComponentX((Stairs2)componentIn, listIn, rand, j, 7);
            }
            if (this.field_74995_d) {
                this.getNextComponentZ((Stairs2)componentIn, listIn, rand, i, 1);
            }
            if (this.field_74999_h) {
                this.getNextComponentZ((Stairs2)componentIn, listIn, rand, j, 7);
            }
        }
        
        public static Crossing func_175866_a(final List<StructureComponent> p_175866_0_, final Random p_175866_1_, final int p_175866_2_, final int p_175866_3_, final int p_175866_4_, final EnumFacing p_175866_5_, final int p_175866_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175866_2_, p_175866_3_, p_175866_4_, -4, -3, 0, 10, 9, 11, p_175866_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175866_0_, structureboundingbox) == null) ? new Crossing(p_175866_6_, p_175866_1_, structureboundingbox, p_175866_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 9, 8, 10, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 4, 3, 0);
            if (this.field_74996_b) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 1, 0, 5, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.field_74995_d) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 3, 1, 9, 5, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.field_74997_c) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 7, 0, 7, 9, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.field_74999_h) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 5, 7, 9, 7, 9, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 1, 10, 7, 3, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 1, 2, 1, 8, 2, 6, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 1, 5, 4, 4, 9, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 8, 1, 5, 8, 4, 9, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 1, 4, 7, 3, 4, 9, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 1, 3, 5, 3, 3, 6, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 4, 3, 3, 4, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 6, 3, 4, 6, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 5, 1, 7, 7, 1, 8, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 1, 9, 7, 1, 9, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 7, 7, 2, 7, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 5, 7, 4, 5, 9, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 7, 8, 5, 9, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 5, 7, 7, 5, 9, Blocks.double_stone_slab.getDefaultState(), Blocks.double_stone_slab.getDefaultState(), false);
            this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 6, 5, 6, structureBoundingBoxIn);
            return true;
        }
    }
    
    public static class LeftTurn extends Stronghold
    {
        public LeftTurn() {
        }
        
        public LeftTurn(final int p_i45579_1_, final Random p_i45579_2_, final StructureBoundingBox p_i45579_3_, final EnumFacing p_i45579_4_) {
            super(p_i45579_1_);
            this.coordBaseMode = p_i45579_4_;
            this.field_143013_d = this.getRandomDoor(p_i45579_2_);
            this.boundingBox = p_i45579_3_;
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 1);
            }
            else {
                this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 1);
            }
        }
        
        public static LeftTurn func_175867_a(final List<StructureComponent> p_175867_0_, final Random p_175867_1_, final int p_175867_2_, final int p_175867_3_, final int p_175867_4_, final EnumFacing p_175867_5_, final int p_175867_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175867_2_, p_175867_3_, p_175867_4_, -1, -1, 0, 5, 5, 5, p_175867_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175867_0_, structureboundingbox) == null) ? new LeftTurn(p_175867_6_, p_175867_1_, structureboundingbox, p_175867_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 4, 4, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 1, 1, 0);
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 1, 4, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 1, 0, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
    }
    
    public static class Library extends Stronghold
    {
        private static final List<WeightedRandomChestContent> strongholdLibraryChestContents;
        private boolean isLargeRoom;
        
        public Library() {
        }
        
        public Library(final int p_i45578_1_, final Random p_i45578_2_, final StructureBoundingBox p_i45578_3_, final EnumFacing p_i45578_4_) {
            super(p_i45578_1_);
            this.coordBaseMode = p_i45578_4_;
            this.field_143013_d = this.getRandomDoor(p_i45578_2_);
            this.boundingBox = p_i45578_3_;
            this.isLargeRoom = (p_i45578_3_.getYSize() > 6);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Tall", this.isLargeRoom);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.isLargeRoom = tagCompound.getBoolean("Tall");
        }
        
        public static Library func_175864_a(final List<StructureComponent> p_175864_0_, final Random p_175864_1_, final int p_175864_2_, final int p_175864_3_, final int p_175864_4_, final EnumFacing p_175864_5_, final int p_175864_6_) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 11, 15, p_175864_5_);
            if (!Stronghold.canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_175864_0_, structureboundingbox) != null) {
                structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 6, 15, p_175864_5_);
                if (!Stronghold.canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_175864_0_, structureboundingbox) != null) {
                    return null;
                }
            }
            return new Library(p_175864_6_, p_175864_1_, structureboundingbox, p_175864_5_);
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            int i = 11;
            if (!this.isLargeRoom) {
                i = 6;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 13, i - 1, 14, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 4, 1, 0);
            this.func_175805_a(worldIn, structureBoundingBoxIn, randomIn, 0.07f, 2, 1, 1, 11, 4, 13, Blocks.web.getDefaultState(), Blocks.web.getDefaultState(), false);
            final int j = 1;
            final int k = 12;
            for (int l = 1; l <= 13; ++l) {
                if ((l - 1) % 4 == 0) {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, l, 1, 4, l, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 1, l, 12, 4, l, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                    this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 2, 3, l, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 11, 3, l, structureBoundingBoxIn);
                    if (this.isLargeRoom) {
                        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 6, l, 1, 9, l, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 6, l, 12, 9, l, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                    }
                }
                else {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, l, 1, 4, l, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 1, l, 12, 4, l, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                    if (this.isLargeRoom) {
                        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 6, l, 1, 9, l, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 6, l, 12, 9, l, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                    }
                }
            }
            for (int k2 = 3; k2 < 12; k2 += 2) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 1, k2, 4, 3, k2, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 1, k2, 7, 3, k2, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 1, k2, 10, 3, k2, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
            }
            if (this.isLargeRoom) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 1, 3, 5, 13, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 5, 1, 12, 5, 13, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 5, 1, 9, 5, 2, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 5, 12, 9, 5, 13, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 9, 5, 11, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 8, 5, 11, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 9, 5, 10, structureBoundingBoxIn);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 6, 2, 3, 6, 12, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 6, 2, 10, 6, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 6, 2, 9, 6, 2, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 6, 12, 8, 6, 12, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), 9, 6, 11, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), 8, 6, 11, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), 9, 6, 10, structureBoundingBoxIn);
                final int l2 = this.getMetadataWithOffset(Blocks.ladder, 3);
                this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(l2), 10, 1, 13, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(l2), 10, 2, 13, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(l2), 10, 3, 13, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(l2), 10, 4, 13, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(l2), 10, 5, 13, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(l2), 10, 6, 13, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(l2), 10, 7, 13, structureBoundingBoxIn);
                final int i2 = 7;
                final int j2 = 7;
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2 - 1, 9, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2, 9, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2 - 1, 8, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2, 8, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2 - 1, 7, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2, 7, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2 - 2, 7, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2 + 1, 7, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2 - 1, 7, j2 - 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2 - 1, 7, j2 + 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2, 7, j2 - 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.oak_fence.getDefaultState(), i2, 7, j2 + 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.torch.getDefaultState(), i2 - 2, 8, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.torch.getDefaultState(), i2 + 1, 8, j2, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.torch.getDefaultState(), i2 - 1, 8, j2 - 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.torch.getDefaultState(), i2 - 1, 8, j2 + 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.torch.getDefaultState(), i2, 8, j2 - 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.torch.getDefaultState(), i2, 8, j2 + 1, structureBoundingBoxIn);
            }
            this.generateChestContents(worldIn, structureBoundingBoxIn, randomIn, 3, 3, 5, WeightedRandomChestContent.func_177629_a(Library.strongholdLibraryChestContents, Items.enchanted_book.getRandom(randomIn, 1, 5, 2)), 1 + randomIn.nextInt(4));
            if (this.isLargeRoom) {
                this.setBlockState(worldIn, Blocks.air.getDefaultState(), 12, 9, 1, structureBoundingBoxIn);
                this.generateChestContents(worldIn, structureBoundingBoxIn, randomIn, 12, 8, 1, WeightedRandomChestContent.func_177629_a(Library.strongholdLibraryChestContents, Items.enchanted_book.getRandom(randomIn, 1, 5, 2)), 1 + randomIn.nextInt(4));
            }
            return true;
        }
        
        static {
            strongholdLibraryChestContents = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.book, 0, 1, 3, 20), new WeightedRandomChestContent(Items.paper, 0, 2, 7, 20), new WeightedRandomChestContent(Items.map, 0, 1, 1, 1), new WeightedRandomChestContent(Items.compass, 0, 1, 1, 1) });
        }
    }
    
    static class PieceWeight
    {
        public Class<? extends Stronghold> pieceClass;
        public final int pieceWeight;
        public int instancesSpawned;
        public int instancesLimit;
        
        public PieceWeight(final Class<? extends Stronghold> p_i2076_1_, final int p_i2076_2_, final int p_i2076_3_) {
            this.pieceClass = p_i2076_1_;
            this.pieceWeight = p_i2076_2_;
            this.instancesLimit = p_i2076_3_;
        }
        
        public boolean canSpawnMoreStructuresOfType(final int p_75189_1_) {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
        
        public boolean canSpawnMoreStructures() {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
    }
    
    public static class PortalRoom extends Stronghold
    {
        private boolean hasSpawner;
        
        public PortalRoom() {
        }
        
        public PortalRoom(final int p_i45577_1_, final Random p_i45577_2_, final StructureBoundingBox p_i45577_3_, final EnumFacing p_i45577_4_) {
            super(p_i45577_1_);
            this.coordBaseMode = p_i45577_4_;
            this.boundingBox = p_i45577_3_;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Mob", this.hasSpawner);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.hasSpawner = tagCompound.getBoolean("Mob");
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            if (componentIn != null) {
                ((Stairs2)componentIn).strongholdPortalRoom = this;
            }
        }
        
        public static PortalRoom func_175865_a(final List<StructureComponent> p_175865_0_, final Random p_175865_1_, final int p_175865_2_, final int p_175865_3_, final int p_175865_4_, final EnumFacing p_175865_5_, final int p_175865_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175865_2_, p_175865_3_, p_175865_4_, -4, -1, 0, 11, 8, 16, p_175865_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175865_0_, structureboundingbox) == null) ? new PortalRoom(p_175865_6_, p_175865_1_, structureboundingbox, p_175865_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 10, 7, 15, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, Door.GRATES, 4, 1, 0);
            int i = 6;
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 1, i, 1, 1, i, 14, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 9, i, 1, 9, i, 14, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 2, i, 1, 8, i, 2, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 2, i, 14, 8, i, 14, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 1, 1, 1, 2, 1, 4, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 8, 1, 1, 9, 1, 4, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 1, 1, 1, 3, Blocks.flowing_lava.getDefaultState(), Blocks.flowing_lava.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 1, 1, 9, 1, 3, Blocks.flowing_lava.getDefaultState(), Blocks.flowing_lava.getDefaultState(), false);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 3, 1, 8, 7, 1, 12, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 9, 6, 1, 11, Blocks.flowing_lava.getDefaultState(), Blocks.flowing_lava.getDefaultState(), false);
            for (int j = 3; j < 14; j += 2) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, j, 0, 4, j, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 3, j, 10, 4, j, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            }
            for (int k1 = 2; k1 < 9; k1 += 2) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, k1, 3, 15, k1, 4, 15, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            }
            final int l1 = this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 1, 5, 6, 1, 7, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 2, 6, 6, 2, 7, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 3, 7, 6, 3, 7, false, randomIn, StructureStrongholdPieces.strongholdStones);
            for (int m = 4; m <= 6; ++m) {
                this.setBlockState(worldIn, Blocks.stone_brick_stairs.getStateFromMeta(l1), m, 1, 4, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stone_brick_stairs.getStateFromMeta(l1), m, 2, 5, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stone_brick_stairs.getStateFromMeta(l1), m, 3, 6, structureBoundingBoxIn);
            }
            int i2 = EnumFacing.NORTH.getHorizontalIndex();
            int l2 = EnumFacing.SOUTH.getHorizontalIndex();
            int i3 = EnumFacing.EAST.getHorizontalIndex();
            int j2 = EnumFacing.WEST.getHorizontalIndex();
            if (this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case SOUTH: {
                        i2 = EnumFacing.SOUTH.getHorizontalIndex();
                        l2 = EnumFacing.NORTH.getHorizontalIndex();
                        break;
                    }
                    case WEST: {
                        i2 = EnumFacing.WEST.getHorizontalIndex();
                        l2 = EnumFacing.EAST.getHorizontalIndex();
                        i3 = EnumFacing.SOUTH.getHorizontalIndex();
                        j2 = EnumFacing.NORTH.getHorizontalIndex();
                        break;
                    }
                    case EAST: {
                        i2 = EnumFacing.EAST.getHorizontalIndex();
                        l2 = EnumFacing.WEST.getHorizontalIndex();
                        i3 = EnumFacing.SOUTH.getHorizontalIndex();
                        j2 = EnumFacing.NORTH.getHorizontalIndex();
                        break;
                    }
                }
            }
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(i2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 4, 3, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(i2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 5, 3, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(i2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 6, 3, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(l2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 4, 3, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(l2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 5, 3, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(l2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 6, 3, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(i3).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 3, 3, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(i3).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 3, 3, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(i3).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 3, 3, 11, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(j2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 7, 3, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(j2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 7, 3, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.end_portal_frame.getStateFromMeta(j2).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, randomIn.nextFloat() > 0.9f), 7, 3, 11, structureBoundingBoxIn);
            if (!this.hasSpawner) {
                i = this.getYWithOffset(3);
                final BlockPos blockpos = new BlockPos(this.getXWithOffset(5, 6), i, this.getZWithOffset(5, 6));
                if (structureBoundingBoxIn.isVecInside(blockpos)) {
                    this.hasSpawner = true;
                    worldIn.setBlockState(blockpos, Blocks.mob_spawner.getDefaultState(), 2);
                    final TileEntity tileentity = worldIn.getTileEntity(blockpos);
                    if (tileentity instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityName("Silverfish");
                    }
                }
            }
            return true;
        }
    }
    
    public static class Prison extends Stronghold
    {
        public Prison() {
        }
        
        public Prison(final int p_i45576_1_, final Random p_i45576_2_, final StructureBoundingBox p_i45576_3_, final EnumFacing p_i45576_4_) {
            super(p_i45576_1_);
            this.coordBaseMode = p_i45576_4_;
            this.field_143013_d = this.getRandomDoor(p_i45576_2_);
            this.boundingBox = p_i45576_3_;
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
        }
        
        public static Prison func_175860_a(final List<StructureComponent> p_175860_0_, final Random p_175860_1_, final int p_175860_2_, final int p_175860_3_, final int p_175860_4_, final EnumFacing p_175860_5_, final int p_175860_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175860_2_, p_175860_3_, p_175860_4_, -1, -1, 0, 9, 5, 11, p_175860_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175860_0_, structureboundingbox) == null) ? new Prison(p_175860_6_, p_175860_1_, structureboundingbox, p_175860_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 8, 4, 10, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 1, 1, 0);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 10, 3, 3, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 1, 1, 4, 3, 1, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 1, 3, 4, 3, 3, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 1, 7, 4, 3, 7, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 4, 1, 9, 4, 3, 9, false, randomIn, StructureStrongholdPieces.strongholdStones);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 4, 4, 3, 6, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 1, 5, 7, 3, 5, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), 4, 3, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), 4, 3, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3)), 4, 1, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3) + 8), 4, 2, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3)), 4, 1, 8, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3) + 8), 4, 2, 8, structureBoundingBoxIn);
            return true;
        }
    }
    
    public static class RightTurn extends LeftTurn
    {
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 1);
            }
            else {
                this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 1);
            }
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 4, 4, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 1, 1, 0);
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 1, 0, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 1, 4, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
    }
    
    public static class RoomCrossing extends Stronghold
    {
        private static final List<WeightedRandomChestContent> strongholdRoomCrossingChestContents;
        protected int roomType;
        
        public RoomCrossing() {
        }
        
        public RoomCrossing(final int p_i45575_1_, final Random p_i45575_2_, final StructureBoundingBox p_i45575_3_, final EnumFacing p_i45575_4_) {
            super(p_i45575_1_);
            this.coordBaseMode = p_i45575_4_;
            this.field_143013_d = this.getRandomDoor(p_i45575_2_);
            this.boundingBox = p_i45575_3_;
            this.roomType = p_i45575_2_.nextInt(5);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setInteger("Type", this.roomType);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.roomType = tagCompound.getInteger("Type");
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 4, 1);
            this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 4);
            this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 4);
        }
        
        public static RoomCrossing func_175859_a(final List<StructureComponent> p_175859_0_, final Random p_175859_1_, final int p_175859_2_, final int p_175859_3_, final int p_175859_4_, final EnumFacing p_175859_5_, final int p_175859_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175859_2_, p_175859_3_, p_175859_4_, -4, -1, 0, 11, 7, 11, p_175859_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175859_0_, structureboundingbox) == null) ? new RoomCrossing(p_175859_6_, p_175859_1_, structureboundingbox, p_175859_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 10, 6, 10, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 4, 1, 0);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 10, 6, 3, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 4, 0, 3, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 1, 4, 10, 3, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            switch (this.roomType) {
                case 0: {
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 5, 1, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 5, 2, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 5, 3, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 4, 3, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 6, 3, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 5, 3, 4, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 5, 3, 6, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 4, 1, 4, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 4, 1, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 4, 1, 6, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 6, 1, 4, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 6, 1, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 6, 1, 6, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 5, 1, 4, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stone_slab.getDefaultState(), 5, 1, 6, structureBoundingBoxIn);
                    break;
                }
                case 1: {
                    for (int i1 = 0; i1 < 5; ++i1) {
                        this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3, 1, 3 + i1, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 7, 1, 3 + i1, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3 + i1, 1, 3, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3 + i1, 1, 7, structureBoundingBoxIn);
                    }
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 5, 1, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 5, 2, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 5, 3, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.flowing_water.getDefaultState(), 5, 4, 5, structureBoundingBoxIn);
                    break;
                }
                case 2: {
                    for (int j = 1; j <= 9; ++j) {
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 1, 3, j, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 9, 3, j, structureBoundingBoxIn);
                    }
                    for (int k = 1; k <= 9; ++k) {
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), k, 3, 1, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), k, 3, 9, structureBoundingBoxIn);
                    }
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 5, 1, 4, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 5, 1, 6, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 5, 3, 4, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 5, 3, 6, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 4, 1, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 6, 1, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 4, 3, 5, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 6, 3, 5, structureBoundingBoxIn);
                    for (int l = 1; l <= 3; ++l) {
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 4, l, 4, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 6, l, 4, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 4, l, 6, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.cobblestone.getDefaultState(), 6, l, 6, structureBoundingBoxIn);
                    }
                    this.setBlockState(worldIn, Blocks.torch.getDefaultState(), 5, 3, 5, structureBoundingBoxIn);
                    for (int m = 2; m <= 8; ++m) {
                        this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 2, 3, m, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 3, 3, m, structureBoundingBoxIn);
                        if (m <= 3 || m >= 7) {
                            this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 4, 3, m, structureBoundingBoxIn);
                            this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 5, 3, m, structureBoundingBoxIn);
                            this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 6, 3, m, structureBoundingBoxIn);
                        }
                        this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 7, 3, m, structureBoundingBoxIn);
                        this.setBlockState(worldIn, Blocks.planks.getDefaultState(), 8, 3, m, structureBoundingBoxIn);
                    }
                    this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(this.getMetadataWithOffset(Blocks.ladder, EnumFacing.WEST.getIndex())), 9, 1, 3, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(this.getMetadataWithOffset(Blocks.ladder, EnumFacing.WEST.getIndex())), 9, 2, 3, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.ladder.getStateFromMeta(this.getMetadataWithOffset(Blocks.ladder, EnumFacing.WEST.getIndex())), 9, 3, 3, structureBoundingBoxIn);
                    this.generateChestContents(worldIn, structureBoundingBoxIn, randomIn, 3, 4, 8, WeightedRandomChestContent.func_177629_a(RoomCrossing.strongholdRoomCrossingChestContents, Items.enchanted_book.getRandom(randomIn)), 1 + randomIn.nextInt(4));
                    break;
                }
            }
            return true;
        }
        
        static {
            strongholdRoomCrossingChestContents = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.coal, 0, 3, 8, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 1) });
        }
    }
    
    public static class Stairs extends Stronghold
    {
        private boolean field_75024_a;
        
        public Stairs() {
        }
        
        public Stairs(final int p_i2081_1_, final Random p_i2081_2_, final int p_i2081_3_, final int p_i2081_4_) {
            super(p_i2081_1_);
            this.field_75024_a = true;
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(p_i2081_2_);
            this.field_143013_d = Door.OPENING;
            switch (this.coordBaseMode) {
                case SOUTH:
                case NORTH: {
                    this.boundingBox = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
                    break;
                }
            }
        }
        
        public Stairs(final int p_i45574_1_, final Random p_i45574_2_, final StructureBoundingBox p_i45574_3_, final EnumFacing p_i45574_4_) {
            super(p_i45574_1_);
            this.field_75024_a = false;
            this.coordBaseMode = p_i45574_4_;
            this.field_143013_d = this.getRandomDoor(p_i45574_2_);
            this.boundingBox = p_i45574_3_;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Source", this.field_75024_a);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.field_75024_a = tagCompound.getBoolean("Source");
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            if (this.field_75024_a) {
                StructureStrongholdPieces.strongComponentType = Crossing.class;
            }
            this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
        }
        
        public static Stairs func_175863_a(final List<StructureComponent> p_175863_0_, final Random p_175863_1_, final int p_175863_2_, final int p_175863_3_, final int p_175863_4_, final EnumFacing p_175863_5_, final int p_175863_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175863_2_, p_175863_3_, p_175863_4_, -1, -7, 0, 5, 11, 5, p_175863_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175863_0_, structureboundingbox) == null) ? new Stairs(p_175863_6_, p_175863_1_, structureboundingbox, p_175863_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 10, 4, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 1, 7, 0);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, Door.OPENING, 1, 1, 4);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 2, 6, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 5, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 6, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 5, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 4, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 5, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 2, 4, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3, 3, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 3, 4, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3, 3, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 3, 3, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 2, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 1, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 2, 1, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 1, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 1, 3, structureBoundingBoxIn);
            return true;
        }
    }
    
    public static class Stairs2 extends Stairs
    {
        public PieceWeight strongholdPieceWeight;
        public PortalRoom strongholdPortalRoom;
        public List<StructureComponent> field_75026_c;
        
        public Stairs2() {
            this.field_75026_c = (List<StructureComponent>)Lists.newArrayList();
        }
        
        public Stairs2(final int p_i2083_1_, final Random p_i2083_2_, final int p_i2083_3_, final int p_i2083_4_) {
            super(0, p_i2083_2_, p_i2083_3_, p_i2083_4_);
            this.field_75026_c = (List<StructureComponent>)Lists.newArrayList();
        }
        
        @Override
        public BlockPos getBoundingBoxCenter() {
            return (this.strongholdPortalRoom != null) ? this.strongholdPortalRoom.getBoundingBoxCenter() : super.getBoundingBoxCenter();
        }
    }
    
    public static class StairsStraight extends Stronghold
    {
        public StairsStraight() {
        }
        
        public StairsStraight(final int p_i45572_1_, final Random p_i45572_2_, final StructureBoundingBox p_i45572_3_, final EnumFacing p_i45572_4_) {
            super(p_i45572_1_);
            this.coordBaseMode = p_i45572_4_;
            this.field_143013_d = this.getRandomDoor(p_i45572_2_);
            this.boundingBox = p_i45572_3_;
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
        }
        
        public static StairsStraight func_175861_a(final List<StructureComponent> p_175861_0_, final Random p_175861_1_, final int p_175861_2_, final int p_175861_3_, final int p_175861_4_, final EnumFacing p_175861_5_, final int p_175861_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175861_2_, p_175861_3_, p_175861_4_, -1, -7, 0, 5, 11, 8, p_175861_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175861_0_, structureboundingbox) == null) ? new StairsStraight(p_175861_6_, p_175861_1_, structureboundingbox, p_175861_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 10, 7, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 1, 7, 0);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, Door.OPENING, 1, 1, 7);
            final int i = this.getMetadataWithOffset(Blocks.stone_stairs, 2);
            for (int j = 0; j < 6; ++j) {
                this.setBlockState(worldIn, Blocks.stone_stairs.getStateFromMeta(i), 1, 6 - j, 1 + j, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stone_stairs.getStateFromMeta(i), 2, 6 - j, 1 + j, structureBoundingBoxIn);
                this.setBlockState(worldIn, Blocks.stone_stairs.getStateFromMeta(i), 3, 6 - j, 1 + j, structureBoundingBoxIn);
                if (j < 5) {
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 1, 5 - j, 1 + j, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 2, 5 - j, 1 + j, structureBoundingBoxIn);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), 3, 5 - j, 1 + j, structureBoundingBoxIn);
                }
            }
            return true;
        }
    }
    
    static class Stones extends StructureComponent.BlockSelector
    {
        private Stones() {
        }
        
        @Override
        public void selectBlocks(final Random rand, final int x, final int y, final int z, final boolean p_75062_5_) {
            if (p_75062_5_) {
                final float f = rand.nextFloat();
                if (f < 0.2f) {
                    this.blockstate = Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CRACKED_META);
                }
                else if (f < 0.5f) {
                    this.blockstate = Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.MOSSY_META);
                }
                else if (f < 0.55f) {
                    this.blockstate = Blocks.monster_egg.getStateFromMeta(BlockSilverfish.EnumType.STONEBRICK.getMetadata());
                }
                else {
                    this.blockstate = Blocks.stonebrick.getDefaultState();
                }
            }
            else {
                this.blockstate = Blocks.air.getDefaultState();
            }
        }
    }
    
    public static class Straight extends Stronghold
    {
        private boolean expandsX;
        private boolean expandsZ;
        
        public Straight() {
        }
        
        public Straight(final int p_i45573_1_, final Random p_i45573_2_, final StructureBoundingBox p_i45573_3_, final EnumFacing p_i45573_4_) {
            super(p_i45573_1_);
            this.coordBaseMode = p_i45573_4_;
            this.field_143013_d = this.getRandomDoor(p_i45573_2_);
            this.boundingBox = p_i45573_3_;
            this.expandsX = (p_i45573_2_.nextInt(2) == 0);
            this.expandsZ = (p_i45573_2_.nextInt(2) == 0);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Left", this.expandsX);
            tagCompound.setBoolean("Right", this.expandsZ);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            super.readStructureFromNBT(tagCompound);
            this.expandsX = tagCompound.getBoolean("Left");
            this.expandsZ = tagCompound.getBoolean("Right");
        }
        
        @Override
        public void buildComponent(final StructureComponent componentIn, final List<StructureComponent> listIn, final Random rand) {
            this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
            if (this.expandsX) {
                this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 2);
            }
            if (this.expandsZ) {
                this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 2);
            }
        }
        
        public static Straight func_175862_a(final List<StructureComponent> p_175862_0_, final Random p_175862_1_, final int p_175862_2_, final int p_175862_3_, final int p_175862_4_, final EnumFacing p_175862_5_, final int p_175862_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175862_2_, p_175862_3_, p_175862_4_, -1, -1, 0, 5, 5, 7, p_175862_5_);
            return (Stronghold.canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175862_0_, structureboundingbox) == null) ? new Straight(p_175862_6_, p_175862_1_, structureboundingbox, p_175862_5_) : null;
        }
        
        @Override
        public boolean addComponentParts(final World worldIn, final Random randomIn, final StructureBoundingBox structureBoundingBoxIn) {
            if (this.isLiquidInStructureBoundingBox(worldIn, structureBoundingBoxIn)) {
                return false;
            }
            this.fillWithRandomizedBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 4, 6, true, randomIn, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, this.field_143013_d, 1, 1, 0);
            this.placeDoor(worldIn, randomIn, structureBoundingBoxIn, Door.OPENING, 1, 1, 6);
            this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1f, 1, 2, 1, Blocks.torch.getDefaultState());
            this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1f, 3, 2, 1, Blocks.torch.getDefaultState());
            this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1f, 1, 2, 5, Blocks.torch.getDefaultState());
            this.randomlyPlaceBlock(worldIn, structureBoundingBoxIn, randomIn, 0.1f, 3, 2, 5, Blocks.torch.getDefaultState());
            if (this.expandsX) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 2, 0, 3, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.expandsZ) {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 2, 4, 3, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
    }
    
    abstract static class Stronghold extends StructureComponent
    {
        protected Door field_143013_d;
        
        public Stronghold() {
            this.field_143013_d = Door.OPENING;
        }
        
        protected Stronghold(final int p_i2087_1_) {
            super(p_i2087_1_);
            this.field_143013_d = Door.OPENING;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound tagCompound) {
            tagCompound.setString("EntryDoor", this.field_143013_d.name());
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound tagCompound) {
            this.field_143013_d = Door.valueOf(tagCompound.getString("EntryDoor"));
        }
        
        protected void placeDoor(final World worldIn, final Random p_74990_2_, final StructureBoundingBox p_74990_3_, final Door p_74990_4_, final int p_74990_5_, final int p_74990_6_, final int p_74990_7_) {
            switch (p_74990_4_) {
                default: {
                    this.fillWithBlocks(worldIn, p_74990_3_, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_5_ + 3 - 1, p_74990_6_ + 3 - 1, p_74990_7_, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                    break;
                }
                case WOOD_DOOR: {
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.oak_door.getDefaultState(), p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.oak_door.getStateFromMeta(8), p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    break;
                }
                case GRATES: {
                    this.setBlockState(worldIn, Blocks.air.getDefaultState(), p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.air.getDefaultState(), p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_bars.getDefaultState(), p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
                    break;
                }
                case IRON_DOOR: {
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stonebrick.getDefaultState(), p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_door.getDefaultState(), p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.iron_door.getStateFromMeta(8), p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stone_button.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_button, 4)), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ + 1, p_74990_3_);
                    this.setBlockState(worldIn, Blocks.stone_button.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_button, 3)), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ - 1, p_74990_3_);
                    break;
                }
            }
        }
        
        protected Door getRandomDoor(final Random p_74988_1_) {
            final int i = p_74988_1_.nextInt(5);
            switch (i) {
                default: {
                    return Door.OPENING;
                }
                case 2: {
                    return Door.WOOD_DOOR;
                }
                case 3: {
                    return Door.GRATES;
                }
                case 4: {
                    return Door.IRON_DOOR;
                }
            }
        }
        
        protected StructureComponent getNextComponentNormal(final Stairs2 p_74986_1_, final List<StructureComponent> p_74986_2_, final Random p_74986_3_, final int p_74986_4_, final int p_74986_5_) {
            if (this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        return func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ - 1, this.coordBaseMode, this.getComponentType());
                    }
                    case SOUTH: {
                        return func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.maxZ + 1, this.coordBaseMode, this.getComponentType());
                    }
                    case WEST: {
                        return func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, this.coordBaseMode, this.getComponentType());
                    }
                    case EAST: {
                        return func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, this.coordBaseMode, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        protected StructureComponent getNextComponentX(final Stairs2 p_74989_1_, final List<StructureComponent> p_74989_2_, final Random p_74989_3_, final int p_74989_4_, final int p_74989_5_) {
            if (this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        return func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, EnumFacing.WEST, this.getComponentType());
                    }
                    case SOUTH: {
                        return func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, EnumFacing.WEST, this.getComponentType());
                    }
                    case WEST: {
                        return func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                    case EAST: {
                        return func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        protected StructureComponent getNextComponentZ(final Stairs2 p_74987_1_, final List<StructureComponent> p_74987_2_, final Random p_74987_3_, final int p_74987_4_, final int p_74987_5_) {
            if (this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        return func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, EnumFacing.EAST, this.getComponentType());
                    }
                    case SOUTH: {
                        return func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, EnumFacing.EAST, this.getComponentType());
                    }
                    case WEST: {
                        return func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                    case EAST: {
                        return func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        protected static boolean canStrongholdGoDeeper(final StructureBoundingBox p_74991_0_) {
            return p_74991_0_ != null && p_74991_0_.minY > 10;
        }
        
        public enum Door
        {
            OPENING, 
            WOOD_DOOR, 
            GRATES, 
            IRON_DOOR;
        }
    }
}