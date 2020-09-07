package nukesfromthefuture.interfaces;

import nukesfromthefuture.handler.FluidTypeHandler.FluidType;

public interface IFluidAcceptor extends IFluidContainer{
	int getMaxFluidFill(FluidType type);

}
