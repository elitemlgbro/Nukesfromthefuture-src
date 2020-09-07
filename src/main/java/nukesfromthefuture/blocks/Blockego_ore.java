package nukesfromthefuture.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import nukesfromthefuture.Nukesfromthefuture;

public class Blockego_ore extends Block {

	public Blockego_ore() {
		super(Material.rock);
		this.setHardness(10.0F);
	}
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return Nukesfromthefuture.ego_ingot;
	}
}
