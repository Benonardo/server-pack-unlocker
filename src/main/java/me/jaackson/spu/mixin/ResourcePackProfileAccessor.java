package me.jaackson.spu.mixin;

import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Supplier;

@Mixin(ResourcePackProfile.class)
public interface ResourcePackProfileAccessor {

    @Accessor("packFactory")
    Supplier<ResourcePack> accessPackFactory();

}
