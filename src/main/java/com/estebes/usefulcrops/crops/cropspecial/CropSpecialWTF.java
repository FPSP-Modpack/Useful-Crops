package com.estebes.usefulcrops.crops.cropspecial;

import com.estebes.usefulcrops.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import ic2.api.info.Info;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class CropSpecialWTF extends CropCard {

	public CropSpecialWTF() {
	}

	@Override
	public String owner() {
		return "UsefulCrops";
	}

	@Override
	public String displayName() {
		return "Thunder Crop";
	}

	@Override
	public String discoveredBy() {
		return "Player";
	}

	@Override
	public String name() {
		return "thunder crop";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Thunder", "Leaves", "Bad"};
	}

	@Override
	public int tier() {
		return 15;
	}

	@Override
	public int maxSize() {
		return 4;
	}

	@Override
	public int getrootslength(ICropTile crop) {
		return 3;
	}

	@Override
	public boolean canGrow(ICropTile crop) {
		return crop.getSize() < this.maxSize();
	}

	@Override
	public int getOptimalHavestSize(ICropTile crop) {
		return 4;
	}

	@Override
	public boolean canBeHarvested(ICropTile crop) {
		return false;
	}

	@Override
	public byte getSizeAfterHarvest(ICropTile crop) {
		return 2;
	}

	@Override
	public int growthDuration(ICropTile crop) {
		return crop.getSize() == 3 ? 2000 : 800;
	}

	@Override
	public ItemStack getGain(ICropTile crop) {
		return null;
	}

	@Override
	public float dropGainChance() {
		return 0.0F;
	}

	@Override
	public int stat(int n) {
		switch (n) {
		case 0:
			return 2;
		case 1:
			return 0;
		case 2:
			return 0;
		case 3:
			return 1;
		case 4:
			return 0;
		}
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerSprites(IIconRegister iconRegister) {
		this.textures = new IIcon[this.maxSize()];
		for (int size = 1; size <= this.maxSize(); size++) {
			this.textures[(size - 1)] = iconRegister
					.registerIcon(Reference.LOWERCASE_MOD_ID + ":crop_plant_1_" + size);
		}
	}

	@Override
	public void tick(ICropTile crop) {
		crop.getWorld().addWeatherEffect(
				new EntityLightningBolt(crop.getWorld(), crop.getLocation().posX, crop.getLocation().posY, crop.getLocation().posZ));
	}

	@Override
	public boolean onEntityCollision(ICropTile crop, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			((EntityLivingBase) entity).attackEntityFrom(Info.DMG_ELECTRIC, crop.getGain());
			return ((EntityLivingBase) entity).isSprinting();
		}
		return false;
	}
}
