package net.warlaak.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.warlaak.tutorialmod.TutorialMod;

public class ModItemGroup {
    public static final ItemGroup TUTORIAL_MOD = FabricItemGroup.builder(new Identifier(TutorialMod.MOD_ID))
            .displayName(Text.literal("Tutorial Mod"))
            .icon(()->new ItemStack(ModItems.TANZANITE))//change later to a dif item??????
            .build();
}
