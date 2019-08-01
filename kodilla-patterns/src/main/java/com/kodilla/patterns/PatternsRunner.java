package com.kodilla.patterns;

import com.kodilla.patterns.singleton.SettingsFileEngine;

public class PatternsRunner {
    public static void main(String[] args){
        System.out.println("patterns");
        SettingsFileEngine.getInstance().loadSettings();
    }
}
