package blusunrize.immersiveengineering.common.util.fakeworld;

import blusunrize.immersiveengineering.ImmersiveEngineering;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.StructureBlockInfo;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.ticks.LevelTickAccess;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class TemplateWorld extends Level
{
	private final Map<String, MapItemSavedData> maps = new HashMap<>();
	private final Scoreboard scoreboard = new Scoreboard();
	private final RecipeManager recipeManager = new RecipeManager();
	private final TemplateChunkProvider chunkProvider;

	public TemplateWorld(
			List<StructureBlockInfo> blocks, Predicate<BlockPos> shouldShow, Holder<DimensionType> dimensionType
	)
	{
		super(
				new FakeSpawnInfo(), Level.OVERWORLD, dimensionType,
				() -> InactiveProfiler.INSTANCE, true, false, 0, 0
		);
		this.chunkProvider = new TemplateChunkProvider(blocks, this, shouldShow);
	}

	@Override
	public void sendBlockUpdated(@Nonnull BlockPos pos, @Nonnull BlockState oldState, @Nonnull BlockState newState, int flags)
	{
	}

	@Override
	public void playSeededSound(@Nullable Player p_262953_, double p_263004_, double p_263398_, double p_263376_, Holder<SoundEvent> p_263359_, SoundSource p_263020_, float p_263055_, float p_262914_, long p_262991_)
	{
	}

	@Override
	public void playSeededSound(@Nullable Player p_220372_, Entity p_220373_, Holder<SoundEvent> p_263500_, SoundSource p_220375_, float p_220376_, float p_220377_, long p_220378_)
	{
	}

	@Nonnull
	@Override
	public String gatherChunkSourceStats()
	{
		return "";
	}

	@Nullable
	@Override
	public Entity getEntity(int id)
	{
		return null;
	}

	@Nullable
	@Override
	public MapItemSavedData getMapData(@Nonnull String mapName)
	{
		return maps.get(mapName);
	}

	@Override
	public void setMapData(@Nonnull String key, @Nonnull MapItemSavedData mapDataIn)
	{
		maps.put(key, mapDataIn);
	}

	@Override
	public int getFreeMapId()
	{
		return maps.size();
	}

	@Override
	public void destroyBlockProgress(int breakerId, @Nonnull BlockPos pos, int progress)
	{
	}

	@Nonnull
	@Override
	public Scoreboard getScoreboard()
	{
		return scoreboard;
	}

	@Nonnull
	@Override
	public RecipeManager getRecipeManager()
	{
		return recipeManager;
	}

	@Nonnull
	@Override
	protected LevelEntityGetter<Entity> getEntities()
	{
		return new EmptyLevelEntityGetter<>();
	}

	@Nonnull
	@Override
	public LevelTickAccess<Block> getBlockTicks()
	{
		return new EmptyTickAccess<>();
	}

	@Nonnull
	@Override
	public LevelTickAccess<Fluid> getFluidTicks()
	{
		return new EmptyTickAccess<>();
	}

	@Nonnull
	@Override
	public ChunkSource getChunkSource()
	{
		return chunkProvider;
	}

	@Override
	public void levelEvent(@Nullable Player player, int type, @Nonnull BlockPos pos, int data)
	{
	}

	@Override
	public void gameEvent(GameEvent p_220404_, Vec3 p_220405_, Context p_220406_)
	{
	}

	@Nonnull
	@Override
	public RegistryAccess registryAccess()
	{
		Level clientWorld = ImmersiveEngineering.proxy.getClientWorld();
		return Objects.requireNonNull(clientWorld).registryAccess();
	}

	@Override
	public FeatureFlagSet enabledFeatures()
	{
		return ImmersiveEngineering.proxy.getClientWorld().enabledFeatures();
	}

	@Override
	public float getShade(@Nonnull Direction p_230487_1_, boolean p_230487_2_)
	{
		return 1;
	}

	@Nonnull
	@Override
	public List<? extends Player> players()
	{
		return ImmutableList.of();
	}

	@Nonnull
	@Override
	public Holder<Biome> getUncachedNoiseBiome(int x, int y, int z)
	{
		return Holder.direct(registryAccess().registryOrThrow(Registries.BIOME).getOrThrow(Biomes.PLAINS));
	}

	@Override
	public int getBrightness(@Nonnull LightLayer lightType, @Nonnull BlockPos pos)
	{
		return 15;
	}

	@Override
	public int getMinBuildHeight()
	{
		return 0;
	}
}
