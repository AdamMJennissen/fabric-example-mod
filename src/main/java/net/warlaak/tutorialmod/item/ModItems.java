package net.warlaak.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.warlaak.tutorialmod.TutorialMod;
import net.warlaak.tutorialmod.item.custom.EightBallItem;

public class ModItems {
    //for built in item groups: ItemGroups.GROUP_NAME
    //for modded item groups: ModItemGroup.MOD_GROUP_NAME
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite", new Item(new Item.Settings()), ModItemGroup.TUTORIAL_MOD);
    public static final Item TANZANITE = registerItem("tanzanite", new Item(new Item.Settings()), ModItemGroup.TUTORIAL_MOD);
    public static final Item EIGHT_BALL = registerItem("eight_ball", new EightBallItem(new Item.Settings().maxCount(1)), ModItemGroup.TUTORIAL_MOD);





    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.debug("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
