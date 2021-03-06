package softuni.angular.configs;
import org.springframework.util.AntPathMatcher;

import java.util.Map;

/**
 * Project: backend
 * Created by: GKirilov
 * On: 10/14/2021
 */
class CaseInsensitivePathMatcher extends AntPathMatcher{
    @Override
    protected boolean doMatch(String pattern, String path, boolean fullMatch, Map<String, String> uriTemplateVariables) {
        return super.doMatch(pattern.toLowerCase(), path.toLowerCase(), fullMatch, uriTemplateVariables);
    }
}