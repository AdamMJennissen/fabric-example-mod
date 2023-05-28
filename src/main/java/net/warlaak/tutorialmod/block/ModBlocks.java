package net.warlaak.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.warlaak.tutorialmod.TutorialMod;
import net.warlaak.tutorialmod.block.custom.JumpyBlock;
import net.warlaak.tutorialmod.item.ModItemGroup;
import net.warlaak.tutorialmod.item.ModItems;

public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TUTORIAL_MOD);

    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(), UniformIntProvider.create(3, 7)), ModItemGroup.TUTORIAL_MOD);
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool(), UniformIntProvider.create(3, 7)), ModItemGroup.TUTORIAL_MOD);

    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(), UniformIntProvider.create(4, 8)), ModItemGroup.TUTORIAL_MOD);
    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(), UniformIntProvider.create(4, 8)), ModItemGroup.TUTORIAL_MOD);

    public static final Block JUMPY_BLOCK = registerBlock("jumpy_block",
            new JumpyBlock(FabricBlockSettings.of(Material.STONE).strength(2f)), ModItemGroup.TUTORIAL_MOD);


    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public  static void registerModBlocks(){
        TutorialMod.LOGGER.debug("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
