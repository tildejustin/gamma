package xyz.tildejustin.gamma.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.Option.class)
public abstract class GameOptions$OptionMixin {
    @Mutable
    @Final
    @Shadow
    public static GameOptions.Option BRIGHTNESS;

    @Inject(
            method = "<clinit>",
            at = @At(
                    value = "TAIL"
            )
    )
    private static void changeBrightnessEnum(CallbackInfo ci) {
        BRIGHTNESS = ClassTinkerers.getEnum(GameOptions.Option.class, "BRIGHTNESS");
    }
}
