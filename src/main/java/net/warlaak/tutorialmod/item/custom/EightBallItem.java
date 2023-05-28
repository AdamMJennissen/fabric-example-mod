package net.warlaak.tutorialmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class EightBallItem extends Item {
    public EightBallItem(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            outputRandomResponse(user);
            user.getItemCooldownManager().set(this, 20);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("Right Click to get a response to a yes or no question.").formatted(Formatting.AQUA));
        } else{
            tooltip.add(Text.translatable("Press Shift for more info.").formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    /**
     * outputs a magic eight-ball response to the player
     * @param player - the player
     */
    private void outputRandomResponse(PlayerEntity player){
        switch (getRandomNumber()) {
            case 1 -> player.sendMessage(Text.translatable("It is decidedly so."));
            case 0 -> player.sendMessage(Text.translatable("It is certain."));
            case 2 -> player.sendMessage(Text.translatable("Without a doubt."));
            case 3 -> player.sendMessage(Text.translatable("Yes definitely."));
            case 4 -> player.sendMessage(Text.translatable("You may rely on it."));
            case 5 -> player.sendMessage(Text.translatable("As I see it, yes."));
            case 6 -> player.sendMessage(Text.translatable("Most likely"));
            case 7 -> player.sendMessage(Text.translatable("Outlook good."));
            case 8 -> player.sendMessage(Text.translatable("Yes."));
            case 9 -> player.sendMessage(Text.translatable("Signs point to yes."));
            case 10 -> player.sendMessage(Text.translatable("Reply hazy, try again."));
            case 11 -> player.sendMessage(Text.translatable("Ask again later."));
            case 12 -> player.sendMessage(Text.translatable("Better not yell you now."));
            case 13 -> player.sendMessage(Text.translatable("Cannot predict now."));
            case 14 -> player.sendMessage(Text.translatable("Concentrate and ask again."));
            case 15 -> player.sendMessage(Text.translatable("Don't count on it."));
            case 16 -> player.sendMessage(Text.translatable("My reply is no."));
            case 17 -> player.sendMessage(Text.translatable("My sources say no."));
            case 18 -> player.sendMessage(Text.translatable("Outlook not so good."));
            case 19 -> player.sendMessage(Text.translatable("Very doubtful."));
        }
    }

    /**
     * @return - random int between 0 and 19
     */
    private int getRandomNumber(){
        return Random.createLocal().nextInt(20);
    }
}
