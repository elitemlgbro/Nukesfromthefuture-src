package nukesfromthefuture.objModelLoader;

import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;

import nukesfromthefuture.Nukesfromthefuture;

public class ObjModel {
	private Vector3[] verts;
	private short[] tris;
	public ObjModel(String path)
	{
		ByteBuffer buf = null;
		try
		{
			InputStream in = Nukesfromthefuture.instance.getClass().getResourceAsStream("/assets/nff/models/" + path);
			byte[] data = new byte[(in.read()<<24)|(in.read()<<16)|(in.read()<<8)|(in.read())];
			in.read(data);
			buf = ByteBuffer.wrap(data);
		}
		catch (Exception e)
		{
			//complain
		}
		if (buf != null)
		{
			verts = new Vector3[buf.getShort()];
			for (int i = 0; i < verts.length; i++)
			{
				verts[i] = new Vector3(buf.getFloat(),buf.getFloat(),buf.getFloat(),(buf.get()-127)/127f,(buf.get()-127)/127f,(buf.get()-127)/127f,(buf.get()-127)/127f,(buf.get()-127)/127f);
			}
			tris = new short[buf.getInt()*3];
			for (int i = 0; i < tris.length; i++)
			{
				tris[i] = buf.getShort();
			}
		}
		else
		{
			//complain
		}
	}
	
	public void render()
	{
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int i = 0; i < tris.length; i++)
		{
			//GL11.
		}
	}
	
	private class Vector3
	{
		public float x,y,z;//pos
		public float i,j,k;//norm
		public float u,v;
		public Vector3(float X,float Y,float Z,float I,float J,float K,float U,float V)
		{
			x=X;
			y=Y;
			z=Z;
			i=I;
			j=J;
			k=K;
			u=U;
			v=V;
		}
	}
}
