package net.jfuentestgn.htmlsanitizerdemo;

import lombok.Data;
import net.jfuentestgn.htmlsanitizer.Sanitize;

/**
 * Form fields with HTML content to be sanitized
 */
@Data
public class TestForm {

    // @Sanitize -> This is the original HTML content as entered by the user. CAUTION!!! It is not sanitized
    private String htmlContent;

    @Sanitize
    private String htmlDefault;

    @Sanitize("BLOCKS")
    private String htmlBlocks;

    @Sanitize("FORMATTING")
    private String htmlFormatting;

    @Sanitize("IMAGES")
    private String htmlImages;

    @Sanitize("LINKS")
    private String htmlLinks;

    @Sanitize("STYLES")
    private String htmlStyles;

    @Sanitize("TABLES")
    private String htmlTables;

    @Sanitize("CUSTOM")
    private String htmlCustom;
}
