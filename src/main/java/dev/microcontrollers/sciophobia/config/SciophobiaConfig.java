package dev.microcontrollers.sciophobia.config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.ConfigEntry;
import dev.isxander.yacl3.config.ConfigInstance;
import dev.isxander.yacl3.config.GsonConfigInstance;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class SciophobiaConfig {
    public static final ConfigInstance<SciophobiaConfig> INSTANCE = GsonConfigInstance.createBuilder(SciophobiaConfig.class)
            .setPath(FabricLoader.getInstance().getConfigDir().resolve("overlaytweaks.json"))
            .build();

    @ConfigEntry
    public boolean removeShadows = true;

    @SuppressWarnings("deprecation")
    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(INSTANCE, ((defaults, config, builder) -> builder
                .title(Text.literal("Sciophobia"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Sciophobia"))
                        .option(Option.createBuilder(boolean.class)
                                .name(Text.literal("Hide text shadows"))
                                .description(OptionDescription.of(Text.of("Hides text shadow globally.")))
                                .binding(defaults.removeShadows, () -> config.removeShadows, newVal -> config.removeShadows = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .build())
        )).generateScreen(parent);
    }

}
