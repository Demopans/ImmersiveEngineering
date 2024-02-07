/*
 * BluSunrize
 * Copyright (c) 2024
 *
 * This code is licensed under "Blu's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package compact;

import net.minecraft.world.level.ItemLike;
import com.google.common.base.Preconditions;

public class WoodDict{
	public String getModID()
	{
		return modID;
	}

	public String getName()
	{
		return name;
	}

	public String getPlank()
	{
		return plank;
	}

	public String getLog()
	{
		return log;
	}

	public boolean isProduceSawdust()
	{
		return produceSawdust;
	}

	public String getStripped()
	{
		return stripped;
	}

	public String getWood()
	{
		return wood;
	}

	public String getStrippedWood()
	{
		return strippedWood;
	}

	public String getDoor()
	{
		return door;
	}

	public String getStairs()
	{
		return stairs;
	}

	public String getSlab()
	{
		return slab;
	}

	private final String modID;
	private final String name;
	private final String plank;
	private final String log;
	private final boolean produceSawdust;
	private final String stripped;
	private final String wood;
	private final String strippedWood;
	private final String door;
	private final String stairs;
	private final String slab;

	WoodDict(String modID, String name, String plank, String log, boolean produceSawdust, String stripped, String wood, String strippedWood, String door, String stairs, String slab)
	{
		// the following must exist
		Preconditions.checkNotNull(modID);
		Preconditions.checkNotNull(name);
		Preconditions.checkNotNull(plank);
		Preconditions.checkNotNull(log);

		this.modID = modID;
		this.name = name;
		this.produceSawdust = produceSawdust;
		this.plank = plank;
		this.log = log;
		this.stripped = stripped;
		this.wood = wood;
		this.strippedWood = strippedWood;
		this.door = door;
		this.stairs = stairs;
		this.slab = slab;
	}
	
}
