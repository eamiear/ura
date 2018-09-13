import org.springframework.beans.factory.annotation.Value;

/**
 * @author eamiear
 * @date 2018/9/13 15:30
 */

public class ArtService {
    @Value("ura.art-third-url.jiqie.url")
    private static String JI_QIE_URL;

    @Value("ura.art-third-url.jiqie.domain")
    private static String JI_QIE_DOMAIN;

    @Value("ura.art-third-url.jiqie.idi")
    private static String JI_QIE_HOST;

    @Value("ura.art-third-url.jiqie.id1")
    private static String JI_QIE_FONT_FAMILY;

    @Value("ura.art-third-url.jiqie.id2")
    private static String JI_QIE_SIGNAURE_BG;

    @Value("ura.art-third-url.jiqie.id2")
    private static String JI_QIE_SIGNAURE_BGg;
}
