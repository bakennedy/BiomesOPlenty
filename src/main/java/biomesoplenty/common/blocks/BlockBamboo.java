package biomesoplenty.common.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import biomesoplenty.BiomesOPlenty;

public class BlockBamboo extends Block
{
	private IIcon bambooSide;
	private IIcon bambooTop;
	
	public BlockBamboo()
	{
		//TODO: Material.plants
		super(Material.field_151585_k);
		
		//TODO:		setBurnProperties() getIdFromBlock()
		Blocks.fire.func_149842_a(func_149682_b(this), 5, 5);
		//TODO: setTickRandomly()
		this.func_149675_a(true);
		
		//TODO: this.setCreativeTab()
		this.func_149647_a(BiomesOPlenty.tabBiomesOPlenty);
	}

	@Override
	//TODO:		registerIcons()
	public void func_149651_a(IIconRegister iconRegister)
	{
		bambooSide = iconRegister.registerIcon("biomesoplenty:bamboo");
		bambooTop = iconRegister.registerIcon("biomesoplenty:bambootop");
	}
	
	@Override
	//TODO:		 getIcon()
	public IIcon func_149691_a(int side, int meta)
	{
		if (side > 1)
			return bambooSide;
		else
			return bambooTop;
	}

	@Override
	//TODO:		updateTick()
	public void func_149674_a(World world, int x, int y, int z, Random random)
	{
		//TODO:   isAirBlock()
		if (world.func_147437_c(x, y + 1, z))
		{
			int var6;

			//TODO:				 getBlock()
			for (var6 = 1; world.func_147439_a(x, y - var6, z) == this; ++var6)
			{
				;
			}

			if (var6 < 3)
			{
				int var7 = world.getBlockMetadata(x, y, z);

				if (var7 == 15)
				{
					//TODO: setBlock()
					world.func_147465_d(x, y + 1, z, this, 0, 2);
					world.setBlockMetadataWithNotify(x, y, z, 0, 2);
				}
				else
				{
					world.setBlockMetadataWithNotify(x, y, z, var7 + 1, 2);
				}
			}
		}
	}
	
	@Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
		float pixel = 0.0625F;
		
        return AxisAlignedBB.getAABBPool().getAABB((double)x + (1.0F - (pixel * 4)), (double)y, (double)z + (1.0F - (pixel * 4)), (double)x + (pixel * 4), (double)y + 1.0F, (double)z + (pixel * 4));
    }
	
    @Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity)
    {
		float pixel = 0.0625F;
        //TODO: setBlockBounds
		this.func_149676_a((pixel * 4), 0.0F, (pixel * 4), 1.0F - (pixel * 4), 1.0F, 1.0F - (pixel * 4));
        super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
        this.setBlockBoundsForItemRender();
    }
    
    @Override
    //TODO:		setBlockBoundsForItemRender()
    public void func_149683_g()
    {
        //TODO: setBlockBounds
		this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

	@Override
	public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z)
	{
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		int var5 = par1World.getBlockId(par2, par3 - 1, par4);
		if (var5 == blockID)
			return true;
		else if (var5 == Block.grass.blockID)
			return true;
		else
			return false;
	}

	@Override
	//TODO:		onNeighborBlockChange()
	public void func_149695_a(World world, int x, int y, int z, Block neighborBlock)
	{
		this.checkBlockCoordValid(world, x, y, z);
	}

	protected final void checkBlockCoordValid(World par1World, int par2, int par3, int par4)
	{
		if (!this.canBlockStay(par1World, par2, par3, par4))
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlock(par2, par3, par4, 0);
		}
	}

	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		return this.canPlaceBlockAt(par1World, par2, par3, par4);
	}

	@Override
	//TODO:		   isOpaqueCube()
	public boolean func_149662_c()
	{
		return false;
	}

	@Override
	//TODO:		   renderAsNormalBlock()
    public boolean func_149686_d()
	{
		return false;
	}

	@Override
	//TODO		getRenderType()
	public int func_149645_b()
	{
		return RenderUtils.bambooModel;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

}