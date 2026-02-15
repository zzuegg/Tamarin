package com.onemillionworlds.tamarin.actions.actionprofile;

import java.util.regex.Pattern;

/**
 * This is used to identify the action when you want to programmatically interact with it e.g. getting an actions value. It is anticipated that
 * these may be held in a static final field, or something similar where they can be easily accessed
 * application wide.
 * <p>
 * The action name should be things like "teleport", not things like "X Click". The idea is that they are
 * abstract concepts your application would like to support, and they are bound to specific buttons based on the suggested
 * bindings (which may be changed by the user, or guessed at by the binding).
 */
public final class ActionHandle{
    public static final Pattern VALID_ACTION_NAMES = Pattern.compile("^[a-z_]+$");

    private final String actionSetName;
    private final String actionName;

    public ActionHandle(String actionSetName, String actionName){
        this.actionSetName = actionSetName;
        this.actionName = actionName;

        if (!VALID_ACTION_NAMES.matcher(actionSetName).matches()){
            throw new IllegalArgumentException("Action set name must be lower case and only contain letters and underscores but was "+actionSetName);
        }

        if (!VALID_ACTION_NAMES.matcher(actionName).matches()){
            throw new IllegalArgumentException("Action name must be lower case and only contain letters and underscores but was "+actionName);
        }

        if (actionName.length() > 32){
            throw new IllegalArgumentException("Action name must be less than 32 characters but was "+actionName);
        }
        if (actionSetName.length() > 32){
            throw new IllegalArgumentException("Action set name must be less than 32 characters but was "+actionSetName);
        }
    }

    public String actionSetName(){
        return actionSetName;
    }

    public String actionName(){
        return actionName;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionHandle that = (ActionHandle) o;
        if (actionSetName != null ? !actionSetName.equals(that.actionSetName) : that.actionSetName != null) return false;
        return actionName != null ? actionName.equals(that.actionName) : that.actionName == null;
    }

    @Override
    public int hashCode(){
        int result = actionSetName != null ? actionSetName.hashCode() : 0;
        result = 31 * result + (actionName != null ? actionName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "ActionHandle{" +
                "actionSetName='" + actionSetName + '\'' +
                ", actionName='" + actionName + '\'' +
                '}';
    }
}
