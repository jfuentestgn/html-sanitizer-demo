package net.jfuentestgn.htmlsanitizerdemo;

import lombok.extern.slf4j.Slf4j;
import net.jfuentestgn.htmlsanitizer.PoliciesRegistry;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class HtmlSanitizerDemoConfiguration {

    @Autowired
    public void configureSanitizers(PoliciesRegistry policiesRegistry) {
        log.info("Configuring custom sanitizers");
        PolicyFactory policy = new HtmlPolicyBuilder()
                .allowElements("a")
                .allowUrlProtocols("https")
                .allowAttributes("href").onElements("a")
                .requireRelNofollowOnLinks()
                .toFactory();
        policiesRegistry.registerPolicy("CUSTOM", policy);
    }

}
