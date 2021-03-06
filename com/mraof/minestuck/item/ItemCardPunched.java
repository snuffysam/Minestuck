package com.mraof.minestuck.item;

import java.util.List;

import com.mraof.minestuck.Minestuck;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;

public class ItemCardPunched extends Item {

	public ItemCardPunched(int par1) {
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(Minestuck.tabMinestuck);
		this.setUnlocalizedName("cardPunched");
	}

	public void registerIcons(IconRegister par1IconRegister) {
	   itemIcon = par1IconRegister.registerIcon("minestuck:CardPunched");
	}
    
	   @Override
	    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	        if (par1ItemStack.hasTagCompound())
	        {
		        NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
		        NBTTagInt contentID = (NBTTagInt)nbttagcompound.getTag("contentID");
		        NBTTagInt contentMeta = (NBTTagInt)nbttagcompound.getTag("contentMeta");
		        
		
		        if (contentID != null && contentMeta != null) {
		        	//par3List.add("(" + contentID.data + ":" + contentMeta.data + ")");
		        	par3List.add("(" + (new ItemStack(contentID.data,1,contentMeta.data)).getDisplayName() + ")");
		        	return;
		        }
		        else {
		        	 par3List.add("(invalid data)");
		        }
	        } else {
	        	par3List.add("(no data)");
	        }
      
	   	}
       
    }
