package biomesoplenty.biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenOceanCoral extends BiomeGenBase
{
    public BiomeGenOceanCoral(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
    }
}