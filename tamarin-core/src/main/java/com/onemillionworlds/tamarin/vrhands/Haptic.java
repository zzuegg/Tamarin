package com.onemillionworlds.tamarin.vrhands;

import com.onemillionworlds.tamarin.actions.actionprofile.ActionHandle;

/**
 * Represents a haptic action request.
 */
public final class Haptic{
    private final ActionHandle actionHandle;
    private final float duration;
    private final float frequency;
    private final float amplitude;

    /**
     * @param actionHandle the handle for the action (just an object with the set name and action name)
     * @param duration how long in seconds the haptic should run
     * @param frequency in cycles per second
     * @param amplitude between 0 and 1
     */
    public Haptic(ActionHandle actionHandle, float duration, float frequency, float amplitude){
        this.actionHandle = actionHandle;
        this.duration = duration;
        this.frequency = frequency;
        this.amplitude = amplitude;
    }

    public ActionHandle actionHandle(){
        return actionHandle;
    }

    public float duration(){
        return duration;
    }

    public float frequency(){
        return frequency;
    }

    public float amplitude(){
        return amplitude;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Haptic haptic = (Haptic) o;
        if (Float.compare(haptic.duration, duration) != 0) return false;
        if (Float.compare(haptic.frequency, frequency) != 0) return false;
        if (Float.compare(haptic.amplitude, amplitude) != 0) return false;
        return actionHandle != null ? actionHandle.equals(haptic.actionHandle) : haptic.actionHandle == null;
    }

    @Override
    public int hashCode(){
        int result = actionHandle != null ? actionHandle.hashCode() : 0;
        result = 31 * result + (duration != +0.0f ? Float.floatToIntBits(duration) : 0);
        result = 31 * result + (frequency != +0.0f ? Float.floatToIntBits(frequency) : 0);
        result = 31 * result + (amplitude != +0.0f ? Float.floatToIntBits(amplitude) : 0);
        return result;
    }

    @Override
    public String toString(){
        return "Haptic{" +
                "actionHandle=" + actionHandle +
                ", duration=" + duration +
                ", frequency=" + frequency +
                ", amplitude=" + amplitude +
                '}';
    }
}
