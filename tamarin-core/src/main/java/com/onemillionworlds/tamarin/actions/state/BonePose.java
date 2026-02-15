package com.onemillionworlds.tamarin.actions.state;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;

/**
 * Represents the pose of a bone: position, orientation, and radius to skin surface.
 */
public final class BonePose{
    private final Vector3f position;
    private final Quaternion orientation;
    private final float radius;

    /**
     * @param position the bone's position (relative to the overall hand pose space)
     * @param orientation the bone's orientation (relative to the overall hand pose space)
     * @param radius the radius from the bone's position to the skin's surface
     */
    public BonePose(Vector3f position, Quaternion orientation, float radius){
        this.position = position;
        this.orientation = orientation;
        this.radius = radius;
    }

    public Vector3f position(){
        return position;
    }

    public Quaternion orientation(){
        return orientation;
    }

    public float radius(){
        return radius;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonePose bonePose = (BonePose) o;
        if (Float.compare(bonePose.radius, radius) != 0) return false;
        if (position != null ? !position.equals(bonePose.position) : bonePose.position != null) return false;
        return orientation != null ? orientation.equals(bonePose.orientation) : bonePose.orientation == null;
    }

    @Override
    public int hashCode(){
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        result = 31 * result + (radius != +0.0f ? Float.floatToIntBits(radius) : 0);
        return result;
    }

    @Override
    public String toString(){
        return "BonePose{" +
                "position=" + position +
                ", orientation=" + orientation +
                ", radius=" + radius +
                '}';
    }
}
