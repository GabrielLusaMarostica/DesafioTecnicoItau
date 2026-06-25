package dev.java10x.itauJava10x.Estatisticas;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(Integer segundos) {
}
