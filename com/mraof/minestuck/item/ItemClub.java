/**
 * 
 */
package com.mraof.minestuck.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author mraof
 *
 */
public class ItemClub extends ItemWeapon
{
	private final EnumClubType clubType;
    public float efficiencyOnProperMaterial = 4.0F;
    
	public ItemClub(int id, EnumClubType clubType) 
	{
		super(id);
		this.clubType = clubType;
		this.setMaxDamage(clubType.getMaxUses());
		switch(clubType)
		{
		case DEUCE:
			this.setUnlocalizedName("deuceClub");
//			this.setIconIndex(19);
			break;
		}
		this.weaponDamage = 2 + clubType.getDamageVsEntity();
	}

    @Override
	public int getAttackDamage() 
	{
		return weaponDamage;
	}

    @Override
	public int getItemEnchantability()
	{
		return this.clubType.getEnchantability();
	}

    @Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
	{
		itemStack.damageItem(1, player);
		return true;
	}

    @Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLiving)
	{
		if ((double)Block.blocksList[par3].getBlockHardness(world, par4, par5, par6) != 0.0D)
		{
			itemStack.damageItem(2, par7EntityLiving);
		}
		
		return true;
	}

    @Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minestuck:DeuceClub");
	}
}
