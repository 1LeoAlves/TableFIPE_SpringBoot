package br.com.TabelaFipeSpringBoot.Interfaces;

public interface IConvertData {
    <T> T obterDados(String json, Class<T> classType);
}