package bg.softuni.aop.sla;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "slos-config")
public class SlosConfig {

    private List<SloConfig> slos = new ArrayList<>();


    public List<SloConfig> getSlos() {
        return slos;
    }

    public SlosConfig setSlos(List<SloConfig> slos) {
        this.slos = slos;
        return this;
    }

    public static class SloConfig {
        private String id;
        private Integer threshold;

        public String getId() {
            return id;
        }

        public SloConfig setId(String id) {
            this.id = id;
            return this;
        }

        public Integer getThreshold() {
            return threshold;
        }

        public SloConfig setThreshold(Integer threshold) {
            this.threshold = threshold;
            return this;
        }
    }
}
