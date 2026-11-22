package com.electrifiedded.extvil.world;

import java.util.Random;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

/** "Pay buy (min..max), get sell (min..max)", offered with a 70% chance like the original. */
public class ExtTrade implements EntityVillager.ITradeList {
    private final Item sell, buy;
    private final int sMin, sMax, bMin, bMax;

    public ExtTrade(Item sell, int sMin, int sMax, Item buy, int bMin, int bMax) {
        this.sell = sell; this.sMin = sMin; this.sMax = sMax;
        this.buy = buy; this.bMin = bMin; this.bMax = bMax;
    }

    @Override
    public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList list, Random rand) {
        if (rand.nextFloat() >= 0.7F) return;
        list.add(new MerchantRecipe(new ItemStack(buy, MathHelper.getInt(rand, bMin, bMax)),
                new ItemStack(sell, MathHelper.getInt(rand, sMin, sMax))));
    }
}
