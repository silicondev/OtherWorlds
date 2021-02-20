
package io.github.silicondev.otherworlds.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.feature.structure.OceanRuinStructure;
import net.minecraft.world.gen.feature.structure.OceanRuinConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.Blocks;

import io.github.silicondev.otherworlds.OtherworldsModElements;

@OtherworldsModElements.ModElement.Tag
public class IceWorldBiome extends OtherworldsModElements.ModElement {
	@ObjectHolder("otherworlds:ice_world")
	public static final CustomBiome biome = null;
	public IceWorldBiome(OtherworldsModElements instance) {
		super(instance, 5);
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
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0f).precipitation(Biome.RainType.SNOW)
					.category(Biome.Category.ICY).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.ICE.getDefaultState(),
							Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())));
			setRegistryName("ice_world");
			this.addStructure(Feature.IGLOO.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			this.addStructure(Feature.OCEAN_RUIN.withConfiguration(new OceanRuinConfig(OceanRuinStructure.Type.COLD, 0.3F, 0.9F)));
		}
	}
}
