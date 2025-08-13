package br.com.TabelaFipeSpringBoot.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleModels(
        @JsonAlias("modelos") List<VehicleData> models,
        @JsonAlias("anos") List<VehicleData> years ) {
}
