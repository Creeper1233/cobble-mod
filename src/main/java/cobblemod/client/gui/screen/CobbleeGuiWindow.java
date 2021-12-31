
package cobblemod.client.gui.screen;

import net.minecraft.world.World;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.MinecraftClient;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import cobblemod.screen.CobbleeGui;

import cobblemod.CobblecultmodMod;

@Environment(EnvType.CLIENT)
public class CobbleeGuiWindow extends HandledScreen<CobbleeGui.GuiContainerMod> {
	private World world;
	private int positionX, positionY, positionZ;
	private PlayerEntity entity;
	private final static HashMap guistate = CobbleeGui.guistate;

	public CobbleeGuiWindow(CobbleeGui.GuiContainerMod container, PlayerInventory inventory, Text text) {
		super(container, inventory, text);
		this.world = container.world;
		this.positionX = container.x;
		this.positionY = container.y;
		this.positionZ = container.z;
		this.entity = container.entity;
		this.backgroundWidth = 150;
		this.backgroundHeight = 175;
	}

	private static final Identifier texture = new Identifier("cobblecultmod:textures/cobblee.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.drawMouseoverTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawBackground(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		MinecraftClient.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.backgroundWidth) / 2;
		int l = (this.height - backgroundHeight) / 2;
		drawTexture(ms, k, l, 0, 0, this.backgroundWidth, backgroundHeight, this.backgroundWidth, backgroundHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.client.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawForeground(MatrixStack ms, int mouseX, int mouseY) {
		this.textRenderer.draw(ms, "more coming soon", 29, 44, -10027009);
	}

	@Override
	public void onClose() {
		super.onClose();
		MinecraftClient.getInstance().keyboard.setRepeatEvents(false);
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		client.keyboard.setRepeatEvents(true);
		this.addButton(new ButtonWidget(this.x + 2, this.y + 3, 61, 20, new LiteralText("Chicken"), e -> {
			if (true) {
				ClientPlayNetworking.send(CobblecultmodMod.id("cobblee_button_0"),
						new CobbleeGui.ButtonPressedMessage(0, positionX, positionY, positionZ));
			}
		}));
		this.addButton(new ButtonWidget(this.x + 63, this.y + 3, 82, 20, new LiteralText("Chicken.ogg"), e -> {
			if (true) {
				ClientPlayNetworking.send(CobblecultmodMod.id("cobblee_button_1"),
						new CobbleeGui.ButtonPressedMessage(1, positionX, positionY, positionZ));
			}
		}));
	}

	public static void screenInit() {
		ServerPlayNetworking.registerGlobalReceiver(CobblecultmodMod.id("cobblee_button_0"), CobbleeGui.ButtonPressedMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(CobblecultmodMod.id("cobblee_button_1"), CobbleeGui.ButtonPressedMessage::apply);
	}
}
