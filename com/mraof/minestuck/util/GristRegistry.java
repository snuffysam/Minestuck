package com.mraof.minestuck.util;

import java.util.Arrays;
import java.util.Hashtable;

import net.minecraft.item.ItemStack;

public class GristRegistry {
	private static Hashtable gristRecipes = new Hashtable();
	
	/**
	 * Creates a item-grist conversion ratio for an ItemStack. Used in the Alchemiter and GristWidget.
	 */
	public static void addGristConversion(ItemStack item,GristSet grist) {
		addGristConversion(item,true,grist);
	}

	public static void addGristConversion(ItemStack item,boolean useDamage,GristSet grist) {
		System.out.printf("[MINESTUCK] adding grist conversion for id %d and metadata %d, %susing metadata\n", item.itemID, item.getItemDamage(), useDamage ? "" : "not ");
		gristRecipes.put(Arrays.asList(item.itemID,useDamage ? item.getItemDamage() : 0,useDamage), grist);
	}
	public static void addGristConversion(int id, GristSet grist)
	{
		addGristConversion(id, 0, false, grist);
	}
	public static void addGristConversion(int id, int metadata, boolean useDamage, GristSet grist)
	{
		gristRecipes.put(Arrays.asList(id, useDamage ? metadata : 0, useDamage), grist);
	}
	
	/**
	 * Returns a item-grist conversion ratio, given an ItemStack. Used in the Alchemiter and GristWidget.
	 */
	public static GristSet getGristConversion(ItemStack item) {
		if (item == null) {return null;}
		if (gristRecipes.get(Arrays.asList(item.itemID,item.getItemDamage(),true)) == null) {
			return (GristSet) gristRecipes.get(Arrays.asList(item.itemID,0,false));
		} else {
			return (GristSet) gristRecipes.get(Arrays.asList(item.itemID,item.getItemDamage(),true));
		}
	}
}
