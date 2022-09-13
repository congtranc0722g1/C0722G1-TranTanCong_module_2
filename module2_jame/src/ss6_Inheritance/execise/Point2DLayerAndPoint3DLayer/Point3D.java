package ss6_Inheritance.execise.Point2DLayerAndPoint3DLayer;

import java.lang.reflect.Array;

public class Point3D extends Point2D {
    float z = 0.0f;
    public Point3D(){

    }
    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        super.getXY();
        this.z = z;

    }
    public float[] getXYZ(){
        return new float[]{getX(), getY(), getZ()};
    }
    public String toString(){
        return "(" + getX() + "," + getY() + "," +getZ() + ")";
    }

}
