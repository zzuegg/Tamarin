package com.onemillionworlds.tamarin.actions.actionprofile;

import com.jme3.input.controls.KeyTrigger;

/**
 * Represents a keybinding for desktop simulation.
 */
public final class DesktopSimulationKeybinding{
    private final KeyTrigger desktopDebugKeyTrigger;
    private final boolean toggle;

    /**
     * @param desktopDebugKeyTrigger The key trigger for the desktop debug key.
     * @param toggle Whether the keybinding is a toggle. If true, the action will be toggled on and off when the key is pressed.
     */
    public DesktopSimulationKeybinding(KeyTrigger desktopDebugKeyTrigger, boolean toggle){
        this.desktopDebugKeyTrigger = desktopDebugKeyTrigger;
        this.toggle = toggle;
    }

    public KeyTrigger desktopDebugKeyTrigger(){
        return desktopDebugKeyTrigger;
    }

    public boolean toggle(){
        return toggle;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesktopSimulationKeybinding that = (DesktopSimulationKeybinding) o;
        if (toggle != that.toggle) return false;
        return desktopDebugKeyTrigger != null ? desktopDebugKeyTrigger.equals(that.desktopDebugKeyTrigger) : that.desktopDebugKeyTrigger == null;
    }

    @Override
    public int hashCode(){
        int result = desktopDebugKeyTrigger != null ? desktopDebugKeyTrigger.hashCode() : 0;
        result = 31 * result + (toggle ? 1 : 0);
        return result;
    }

    @Override
    public String toString(){
        return "DesktopSimulationKeybinding{" +
                "desktopDebugKeyTrigger=" + desktopDebugKeyTrigger +
                ", toggle=" + toggle +
                '}';
    }
}