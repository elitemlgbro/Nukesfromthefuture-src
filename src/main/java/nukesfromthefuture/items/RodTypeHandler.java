package nukesfromthefuture.items;

import nukesfromthefuture.handler.FluidTypeHandler.FluidType;

public class RodTypeHandler {
public enum RodType{
	None(0x888888, "eliterods.none"),
	NUCLEAR(0x00FF1D, "eliterods.nuclear"),
	EGONIUM(0xD23FFF, "eliterods.egonium");
	private int color;
	private String name;
	private RodType(int colour, String name) {
		color = colour;
		this.name = name;
	}
	
	public int getCOLOR() {
		return color;
	}
	
	public static RodType getEnum(int i) {
		if(i < RodType.values().length)
			return RodType.values()[i];
		else
			return RodType.None;
	}
	public String getUnlocalizedName() {
		return name;
	}
	public static RodType getEnumFromName(String s) {
		
		for(int i = 0; i < RodType.values().length; i++)
			if(RodType.values()[i].getName().equals(s))
				return RodType.values()[i];
		
		return RodType.None;
	}
	public String getName() {
		return this.toString();
	}
}
}
