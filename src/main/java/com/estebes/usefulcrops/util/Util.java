package com.estebes.usefulcrops.util;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Util {
    public static NBTTagCompound getOrCreateNbtData(ItemStack itemStack) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound();
        if (nbtTagCompound == null) {
            nbtTagCompound = new NBTTagCompound();
            itemStack.setTagCompound(nbtTagCompound);
        }
        return nbtTagCompound;
    }

    public static int[] getIntArray(ArrayList<Integer> arrayList)
    {
        int[] aux = new int[arrayList.size()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = arrayList.get(i);
        }
        return aux;
    }
}
