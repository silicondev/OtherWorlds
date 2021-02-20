
package io.github.silicondev.otherworlds.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.biome.Biome;

import io.github.silicondev.otherworlds.block.HardenedRedMassBlock;
import io.github.silicondev.otherworlds.OtherworldsModElements;

@OtherworldsModElements.ModElement.Tag
public class RedHellBiome extends OtherworldsModElements.ModElement {
	@ObjectHolder("otherworlds:red_hell")
	public static final CustomBiome biome = null;
	public RedHellBiome(OtherworldsModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(2f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(HardenedRedMassBlock.block.getDefaultState(),
							HardenedRedMassBlock.block.getDefaultState(), HardenedRedMassBlock.block.getDefaultState())));
			setRegistryName("red_hell");
			this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		}
	}
}
