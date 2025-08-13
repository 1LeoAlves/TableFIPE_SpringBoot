package br.com.TabelaFipeSpringBoot.Principal;

import br.com.TabelaFipeSpringBoot.Models.ModelData;
import br.com.TabelaFipeSpringBoot.Models.VehicleData;
import br.com.TabelaFipeSpringBoot.Models.VehicleModels;
import br.com.TabelaFipeSpringBoot.Services.APIDataConverter;
import br.com.TabelaFipeSpringBoot.Services.ConsumoAPI;

import java.util.*;

public class Principal {
    private final String PATH = "https://parallelum.com.br/fipe/api/v1/";

    private final ConsumoAPI CONSUME_API = new ConsumoAPI();
    private final APIDataConverter DATA_CONVERTER = new APIDataConverter();


    public void showMenu(){
        Scanner leitura = new Scanner(System.in);
        String endpoint = PATH;


        System.out.println("----------------------------------");
        System.out.println("Bem vindo ao sistema FIPE! ");
        System.out.println("Digite qua veículo deseja ver [carro, caminhoes, motos]: ");

        endpoint += leitura.nextLine().trim().toLowerCase() + "/marcas";
        String json = CONSUME_API.obterDados(endpoint);
        VehicleData[] array = DATA_CONVERTER.obterDados(json, VehicleData[].class);
        List<VehicleData> vehicleData = List.of(array);
        vehicleData.stream()
                .sorted(Comparator.comparing(VehicleData::code))
                .forEach(d -> {
                    System.out.println("Cód: " + d.code() + " " +
                            "Marca: " + d.name());
                });

        System.out.println("Escolha uma Marca pelo Cód [ex: 1, 2, 3...]:  ");
        endpoint += "/" + leitura.nextInt() + "/modelos";
        leitura.nextLine();

        json = CONSUME_API.obterDados(endpoint);
        VehicleModels modelsData = DATA_CONVERTER.obterDados(json, VehicleModels.class);

        modelsData.models().forEach(model -> {
            modelsData.years().forEach(year -> {
                System.out.println("Cód. Modelo: " + model.code() + " Cód. Ano:" + year.code() + " Nome: " + model.name() + " " +  year.name());
            });
        });

        System.out.println("Digite o Cód Modelo desejado [ex: 590]:  ");
        String modelCode = leitura.nextLine().trim().toLowerCase();

        String endpointAnos = endpoint + "/" + modelCode + "/anos";
        String jsonAnos = CONSUME_API.obterDados(endpointAnos);
        VehicleData[] anosArray = DATA_CONVERTER.obterDados(jsonAnos, VehicleData[].class);
        List<VehicleData> anos = Arrays.asList(anosArray);

        anos.forEach(a -> System.out.println("Cód Ano: " + a.code() + " - " + a.name()));

        System.out.print("Digite o Cód do ano/combustível [ex: 2003-1]: ");
        String yearCode = leitura.nextLine().trim();

        String endpointValor = endpointAnos + "/" + yearCode;
        String jsonValor = CONSUME_API.obterDados(endpointValor);
        ModelData modelData = DATA_CONVERTER.obterDados(jsonValor, ModelData.class);
        System.out.printf(
                """
                ===== Detalhes do Veículo =====
                Marca:           %s
                Modelo:          %s
                Ano Modelo:      %d
                Combustível:     %s
                Valor:           %s
                Código FIPE:     %s
                Tipo Veículo:    %d
                Sigla Comb.:     %s
                Mês Referência:  %s
                ===============================
                """,
                modelData.marca(),
                modelData.modelo(),
                modelData.anoModelo(),
                modelData.combustivel(),
                modelData.valor(),
                modelData.codigoFipe(),
                modelData.tipoVeiculo(),
                modelData.siglaCombustivel(),
                modelData.mesReferencia()
        );


        System.out.printf("----------------------------------");
    }
}
