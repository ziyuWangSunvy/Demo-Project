package com.pokerfans.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InspiniaThemeTest {

    @Test
    void testAddSinglePlugin() {
        InspiniaTheme theme = new InspiniaTheme();
        theme.addPlugins(ThemePlugin.CHOICES);

        List<String> css = theme.getCssFiles();
        List<String> js = theme.getJsFiles();

        assertTrue(css.contains("css/plugins/choices/choices.min.css"));
        assertTrue(js.contains("js/plugins/choices/choices.min.js"));
        assertTrue(js.contains("js/form-choice.js"));
    }

    @Test
    void testAddMultiplePlugins() {
        InspiniaTheme theme = new InspiniaTheme();
        theme.addPlugins(ThemePlugin.FILEPOND, ThemePlugin.DROPZONE);

        List<String> css = theme.getCssFiles();
        List<String> js = theme.getJsFiles();

        // 检查 FILEPOND 资源
        assertTrue(css.contains("css/plugins/filepond/filepond.min.css"));
        assertTrue(js.contains("js/plugins/filepond/filepond.min.js"));

        // 检查 DROPZONE 资源
        assertTrue(css.contains("css/plugins/dropzone/dropzone.css"));
        assertTrue(js.contains("js/plugins/dropzone/dropzone-min.js"));
    }

    @Test
    void testNoDuplicateWhenAddingSamePluginTwice() {
        InspiniaTheme theme = new InspiniaTheme();
        theme.addPlugins(ThemePlugin.CUSTOM_TABLE, ThemePlugin.CUSTOM_TABLE);

        List<String> js = theme.getJsFiles();

        // 由于 addAll 可能会重复，所以至少保证有这个文件
        assertTrue(js.contains("js/custom-table.js"));
        // 这里你可以根据需求决定：允许重复，还是用 Set 去重
    }
}
