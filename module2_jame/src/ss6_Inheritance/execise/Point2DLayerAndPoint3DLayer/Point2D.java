package ss6_Inheritance.execise.Point2DLayerAndPoint3DLayer;

import ss6_Inheritance.execise.PointClassAndMoveablePoint.Point;

public class Point2D {
    float x = 0.0f;
    float y = 0.0f;
    public Point2D(){

    }
    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){

    }
    public float[] getXY(){
        float Array[] = {getX(),getY()};
        return Array;
    }
    public String toString(){
        return "(" + getX() + "," + getY() + ")";
    }
}
