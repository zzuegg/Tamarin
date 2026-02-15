package com.onemillionworlds.tamarin.actions;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public final class PhysicalBindingInterpretation{
    private final String rawValue;
    private final Optional<HandSide> handSide;
    private final String fundamentalButton;
    private final String withinButtonAction;

    public PhysicalBindingInterpretation(String rawValue, Optional<HandSide> handSide, String fundamentalButton, String withinButtonAction){
        this.rawValue = rawValue;
        this.handSide = handSide;
        this.fundamentalButton = fundamentalButton;
        this.withinButtonAction = withinButtonAction;
    }

    public String rawValue(){
        return rawValue;
    }

    public Optional<HandSide> handSide(){
        return handSide;
    }

    public String fundamentalButton(){
        return fundamentalButton;
    }

    public String withinButtonAction(){
        return withinButtonAction;
    }

    private static final Pattern pattern = Pattern.compile(".*/([^/]+)/([^/]+)$");

    public static PhysicalBindingInterpretation interpretRawValue(String rawValue){
        Matcher matcher = pattern.matcher(rawValue);
        if(!matcher.matches()){
            throw new RuntimeException("Invalid physical binding interpretation: " + rawValue);
        }
        String fundamentalButton = matcher.group(1);
        String withinButtonAction = matcher.group(2);
        HandSide handSide = rawValue.contains("left") ? HandSide.LEFT : rawValue.contains("right") ? HandSide.RIGHT : null;
        return new PhysicalBindingInterpretation(rawValue, Optional.ofNullable(handSide), fundamentalButton, withinButtonAction);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalBindingInterpretation that = (PhysicalBindingInterpretation) o;
        if (rawValue != null ? !rawValue.equals(that.rawValue) : that.rawValue != null) return false;
        if (handSide != null ? !handSide.equals(that.handSide) : that.handSide != null) return false;
        if (fundamentalButton != null ? !fundamentalButton.equals(that.fundamentalButton) : that.fundamentalButton != null) return false;
        return withinButtonAction != null ? withinButtonAction.equals(that.withinButtonAction) : that.withinButtonAction == null;
    }

    @Override
    public int hashCode(){
        int result = rawValue != null ? rawValue.hashCode() : 0;
        result = 31 * result + (handSide != null ? handSide.hashCode() : 0);
        result = 31 * result + (fundamentalButton != null ? fundamentalButton.hashCode() : 0);
        result = 31 * result + (withinButtonAction != null ? withinButtonAction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "PhysicalBindingInterpretation{" +
                "rawValue='" + rawValue + '\'' +
                ", handSide=" + handSide +
                ", fundamentalButton='" + fundamentalButton + '\'' +
                ", withinButtonAction='" + withinButtonAction + '\'' +
                '}';
    }
}
