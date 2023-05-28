package net.warlaak.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JumpyBlock extends Block {
    public JumpyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("Stand on the block for a jump boost!").formatted(Formatting.AQUA));
        } else{
            tooltip.add(Text.translatable("Press Shift for more info.").formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 10, 3));
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
