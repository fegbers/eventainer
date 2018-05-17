package de.fegbers.eventainer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.seratch.jslack.Slack;

@Configuration
public class HttpSlackConfig
{
    @Bean
    public Slack slackClient()
    {
        return Slack.getInstance();
    }
}
