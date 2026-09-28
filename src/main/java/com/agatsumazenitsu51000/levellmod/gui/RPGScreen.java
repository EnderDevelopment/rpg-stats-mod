package com.agatsumazenitsu51000.levellmod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public
class RPGScreen extends Screen {
    private final Screen parentScreen;

    public RPGScreen(Screen parentScreen) {
        super(new StringTextComponent("RPG UI"));
        this.parentScreen = parentScreen;
    }

    @Override
    protected void init() {
        super.init();
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 - 10, 200, 20, new StringTextComponent("Increase Health"), button -> {
            // Logic to increase health stat
        }));
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 + 20, 200, 20, new StringTextComponent("Increase Strength"), button -> {
            // Logic to increase strength stat
        }));
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 + 50, 200, 20, new StringTextComponent("Increase Agility"), button -> {
            // Logic to increase agility stat
        }));
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 + 80, 200, 20, new StringTextComponent("Increase Luck"), button -> {
            // Logic to increase luck stat
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
    }
}
