package com.pokerfans.view;

import java.util.ArrayList;
import java.util.List;

@lombok.Getter
public class InspiniaTheme {

    private final List<String> cssFiles = new ArrayList<>();
    private final List<String> jsFiles = new ArrayList<>();

    public void addPlugins(ThemePlugin... plugins) {
        for (ThemePlugin plugin : plugins) {
            cssFiles.addAll(plugin.getCssFiles());
            jsFiles.addAll(plugin.getJsFiles());
        }
    }
}
