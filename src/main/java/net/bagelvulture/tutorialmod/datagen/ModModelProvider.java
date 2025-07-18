package net.bagelvulture.tutorialmod.datagen;

import net.bagelvulture.tutorialmod.block.custom.BevultriumLampBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.bagelvulture.tutorialmod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool bevultriumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BEVULTRIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BEVULTRIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEVULTRIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEVULTRIUM_DEEPSLATE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUDE_ALCHEMY_TRANSFORMER);

        bevultriumPool.stairs(ModBlocks.BEVULTRIUM_STAIRS);
        bevultriumPool.slab(ModBlocks.BEVULTRIUM_SLAB);

        bevultriumPool.button(ModBlocks.BEVULTRIUM_BUTTON);
        bevultriumPool.pressurePlate(ModBlocks.BEVULTRIUM_PRESSURE_PLATE);

        bevultriumPool.fence(ModBlocks.BEVULTRIUM_FENCE);
        bevultriumPool.fenceGate(ModBlocks.BEVULTRIUM_FENCE_GATE);
        bevultriumPool.wall(ModBlocks.BEVULTRIUM_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.BEVULTRIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BEVULTRIUM_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.BEVULTRIUM_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.BEVULTRIUM_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BEVULTRIUM_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(BevultriumLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BEVULTRIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BEVULTRIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.FRIED_BEVULTRIUM, Models.GENERATED);
        //itemModelGenerator.register(ModItems.HAND_SMELTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERTILE_BEVULTRIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.BEVULTRIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEVULTRIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEVULTRIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEVULTRIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEVULTRIUM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEVULTRIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEVULTRIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEVULTRIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEVULTRIUM_BOOTS));

        itemModelGenerator.register(ModItems.BEVULTRIUM_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.BEVULTURE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BEVULTRIUM_HAMMER, Models.HANDHELD);
    }
}