package com.kodilla.stream.beautifiler;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class FunctionalDecorator {
    public static String decorateTextAtBeginningAndEnd(String textToDecorate){
        return "ABC " + textToDecorate + " ABC";
    }
    public static String decorateTextToUpperCase(String textToDecorate){
        textToDecorate = textToDecorate.toUpperCase();
        return textToDecorate;
    }
    public static String trimDecoratedText(String textToDecorate){
        textToDecorate = textToDecorate.trim();
        return textToDecorate;
    }
    public static String replaceCharSequenceInDecoretedText(String textToDecorate){
        textToDecorate = textToDecorate.replace(" ", "X");
        return textToDecorate;
    }


}
