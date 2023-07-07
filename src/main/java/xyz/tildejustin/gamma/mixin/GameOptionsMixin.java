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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
    @Inject(
            method = "getValueMessage",
            at = @At(
                    value = "RETURN",
                    ordinal = 12
            ),
            locals = LocalCapture.CAPTURE_FAILHARD,
            cancellable = true
    )
    private void modifyBrightnessSliderNaming(GameOptions.Option option, CallbackInfoReturnable<String> cir, String string, float f, float g) {
        cir.setReturnValue(string + (int) (g * 500.0F) + "%");
    }

    @Mixin(GameOptions.Option.class)
    public abstract static class OptionMixin {
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

}
