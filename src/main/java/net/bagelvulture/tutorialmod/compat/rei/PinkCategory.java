package net.bagelvulture.tutorialmod.compat.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.bagelvulture.tutorialmod.TutorialMod;
import net.bagelvulture.tutorialmod.block.ModBlocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class PinkCategory implements DisplayCategory<PinkDisplay> {
    public static final Identifier PINK_BG = Identifier.of(TutorialMod.MOD_ID,
            "textures/gui/pink/pink_emi_bg.png");
    public static final Identifier PINK_ARROW = Identifier.of(TutorialMod.MOD_ID,
            "textures/gui/pink/pink_arrow.png");
    public static final CategoryIdentifier<PinkDisplay> PINK =
            CategoryIdentifier.of(TutorialMod.MOD_ID, "pink");

    @Override
    public CategoryIdentifier<? extends PinkDisplay> getCategoryIdentifier() {
        return PINK;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.tutorialmod.pink");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.PINK.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(PinkDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 46, bounds.getCenterY() - 22);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(PINK_BG, new Rectangle(startPoint.x, startPoint.y, 92, 44), 0, 0, 92, 44, 92, 44));

        widgets.add(Widgets.createDrawableWidget((context, mouseX, mouseY, delta) -> {
            long duration = display.getPinkingTime() * 100L;
            float progress = (System.currentTimeMillis() % duration) / (float) duration;

            int width = (int) (24 * progress);

            context.drawTexture(PINK_ARROW, startPoint.x + 34, startPoint.y + 15, 0, 0, width, 16, 24, 16);
        }));

        widgets.add(Widgets.createLabel(new Point(startPoint.x + 36, startPoint.y + 32),
                Text.of(display.getPinkingTime() / 10 + " Seconds")));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 14, startPoint.y + 14))
                .entries(display.getInputEntries().get(0)).markInput().disableBackground());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 62, startPoint.y + 14))
                .entries(display.getOutputEntries().get(0)).markOutput().disableBackground());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 44;
    }
}