# Tabela FIPE - Consulta via API

Este projeto é um aplicativo **Java Spring Boot** para consulta de preços de veículos usando a **API FIPE** (https://parallelum.com.br/fipe/api/v1).  
Ele permite ao usuário buscar informações de **carros**, **motos** ou **caminhões**, selecionar **marca**, **modelo**, **ano** e visualizar o valor atual na tabela FIPE.

## 📌 Funcionalidades

- Seleção de tipo de veículo (`carros`, `motos`, `caminhoes`)
- Listagem de marcas disponíveis
- Listagem de modelos e anos de fabricação
- Consulta de preço e dados detalhados de um veículo
- Exibição organizada no terminal

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Jackson** (para conversão de JSON)
- **API FIPE pública** (Parallelum)

## 📂 Estrutura do Projeto

br.com.TabelaFipeSpringBoot
│
├── Models
│ ├── VehicleData.java # Record para marca (código e nome)
│ ├── VehicleModels.java # Record para modelos e anos
│ ├── ModelData.java # Record para dados detalhados do veículo
│
├── Services
│ ├── ConsumoAPI.java # Classe para consumir a API HTTP
│ ├── APIDataConverter.java # Classe para converter JSON em objetos

## ⚙️ Como Executar

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/seuusuario/seurepositorio.git
cd seurepositorio
```

### 2️⃣ Compilar e rodar
mvn spring-boot:run
│
├── Principal
│ └── Principal.java # Menu principal da aplicação

🧪 Como Testar

Escolher tipo de veículo
Digite carros, motos ou caminhoes.

Escolher marca
O programa listará todas as marcas disponíveis com código.
Digite o código da marca desejada.

Escolher modelo e ano
Serão exibidos os modelos e anos disponíveis.
Escolha um modelo e depois um ano.

Resultado final
O sistema exibirá todos os dados FIPE organizados, por exemplo:
```bash
===== Detalhes do Veículo =====
Marca:           SUZUKI
Modelo:          VX 800cc
Ano Modelo:      1994
Combustível:     Gasolina
Valor:           R$ 14.488,00
Código FIPE:     825028-6
Tipo Veículo:    2
Sigla Comb.:     G
Mês Referência:  agosto de 2025
===============================
```

📜 Observações

A API pública permite até 500 requisições/dia sem autenticação.

Para maior limite, cadastre um token gratuito no FIPE Online.

O projeto não utiliza banco de dados; os dados vêm diretamente da API.

📧 Contato
Desenvolvido por Leonardo Alves Moreno
