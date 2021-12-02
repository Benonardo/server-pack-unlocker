package me.jaackson.spu.mixin;

import net.minecraft.client.resource.ClientBuiltinResourcePackProvider;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackSource;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;
import java.util.concurrent.CompletableFuture;

@Mixin(ClientBuiltinResourcePackProvider.class)
public class ClientBuiltinResourcePackProviderMixin {

	@Shadow private @Nullable ResourcePackProfile serverContainer;

	@Inject(at = @At("TAIL"), method = "loadServerPack")
	private void unlockServerPack(File packZip, ResourcePackSource packSource, CallbackInfoReturnable<CompletableFuture<Void>> cir) {
		this.serverContainer = new ResourcePackProfile(serverContainer.getName(), serverContainer.isAlwaysEnabled(), ((ResourcePackProfileAccessor)serverContainer).accessPackFactory(), serverContainer.getDisplayName(), serverContainer.getDescription(), serverContainer.getCompatibility(), serverContainer.getInitialPosition(), false, serverContainer.getSource());
	}
	
}