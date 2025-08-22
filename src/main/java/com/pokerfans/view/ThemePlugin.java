package com.pokerfans.view;

import java.util.List;

/**
 * <h3>概述</h3>
 * 枚举类 ThemePlugin 定义了页面中使用的各类主题插件所需引入的 CSS 和 JS 文件路径。
 * 每个枚举值代表一个插件，包含该插件依赖的样式文件和脚本文件。
 * 可用于页面动态引入插件资源，提升模块化和可维护性。
 * 从而在页面渲染时自动加载相应的资源文件。
 *
 * @author Ziyu Wang
 * @since 2025/8/7 10:00
 */
@lombok.Getter
public enum ThemePlugin {
    CHOICES(
            List.of("css/plugins/choices/choices.min.css"),
            List.of("js/plugins/choices/choices.min.js", "js/form-choice.js")
    ),

    FILEPOND(
            List.of(
                    "css/plugins/filepond/filepond.min.css",
                    "css/plugins/filepond/filepond-plugin-image-preview.min.css"
            ),
            List.of(
                    "js/plugins/filepond/filepond.min.js",
                    "js/plugins/filepond/filepond-plugin-image-preview.min.js",
                    "js/plugins/filepond/filepond-plugin-image-exif-orientation.min.js"
            )
    ),

    DROPZONE(
            List.of("css/plugins/dropzone/dropzone.css"),
            List.of("js/plugins/dropzone/dropzone-min.js")
    ),

    CUSTOM_TABLE(
            List.of(),
            List.of("js/custom-table.js")
    ),

    FORM_FILE_UPLOAD(
            List.of(),
            List.of("js/form-fileupload.js")
    );

    private final List<String> cssFiles;
    private final List<String> jsFiles;

    ThemePlugin(List<String> cssFiles, List<String> jsFiles) {
        this.cssFiles = cssFiles;
        this.jsFiles = jsFiles;
    }
}
