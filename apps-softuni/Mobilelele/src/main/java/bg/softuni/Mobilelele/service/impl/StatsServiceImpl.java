package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.views.StatsView;
import bg.softuni.Mobilelele.service.StatsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    private int anonymousRequest;
    private int authRequest;

    @Override
    public void onRequest() {

        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            authRequest++;
        } else {
            anonymousRequest++;
        }
    }

    @Override
    public StatsView getStats() {
        return new StatsView(authRequest, anonymousRequest);
    }
}
