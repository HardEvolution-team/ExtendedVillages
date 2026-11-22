package com.electrifiedded.extvil.client;

import com.electrifiedded.extvil.entity.EntityExtVillager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ExtClient {
    private ExtClient() {}

    public static void preInit() {
        RenderingRegistry.registerEntityRenderingHandler(EntityExtVillager.class, RenderVillager::new);
    }
}
