# Conversor de Moedas

Este aplicativo de Conversor de Moedas baseado em Java permite que os usuários convertam valores de uma moeda para outra usando taxas de câmbio em tempo real. Ele interage com uma API externa para buscar as últimas taxas de câmbio e realiza a conversão com base na entrada do usuário.

## Funcionalidades

- *Seleção de Moedas:* Usuários podem selecionar a moeda de origem e a moeda de destino.
- *Taxas de Câmbio em Tempo Real:* Busca as taxas de câmbio mais recentes de uma API externa.
- *Entrada do Usuário:* Solicita ao usuário que insira o valor a ser convertido.
- *Saída Formatada:* Exibe o valor convertido em um formato de fácil leitura.

## Pré-requisitos

- *Java Development Kit (JDK) 11* ou superior
- *IntelliJ IDEA* ou qualquer outro IDE Java
- *Conexão com a Internet* (para buscar taxas de câmbio em tempo real)
- *Biblioteca JSON* (incluída no projeto)

## Começando

### Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/conversor-de-moedas.git
cd conversor-de-moedas


   ### Configuração e Execução

   1. **Abrir o Projeto:**
      - Abra o IntelliJ IDEA ou seu IDE Java preferido.
      - Importe o projeto clonado.

   2. **Adicionar Biblioteca JSON:**
      - Certifique-se de que o `json-20240303.jar` esteja adicionado às dependências do seu projeto.
      - No IntelliJ IDEA, vá para `File > Project Structure > Libraries` e adicione o arquivo JAR.

   3. **Executar o Aplicativo:**
      - Execute a classe `CurrencyConverter`.
      - Siga as instruções na tela para selecionar as moedas e inserir o valor a ser convertido.

   ## Uso

   1. **Iniciar o Aplicativo:**
      - Execute a classe `CurrencyConverter` no seu IDE.

   2. **Seguir as Instruções:**
      - Selecione a moeda de origem.
      - Selecione a moeda de destino.
      - Insira o valor que deseja converter.

   3. **Ver Resultados:**
      - O aplicativo exibirá o valor convertido com base nas taxas de câmbio mais recentes.

   ## API Utilizada

   Este aplicativo usa a [ExchangeRate-API](https://www.exchangerate-api.com/) para buscar taxas de câmbio em tempo real.

   ## Exemplo

   text
   Bem-vindo ao Conversor de Moedas!
   Convertendo moeda DE?
   1:USD (Dólar Americano)   2:BRL (Real Brasileiro)   3:EUR (Euro)   4:HKD (Dólar de Hong Kong)   5:INR (Rúpia Indiana)
   2
   Convertendo moeda PARA?
   1:USD (Dólar Americano)   2:BRL (Real Brasileiro)   3:EUR (Euro)   4:HKD (Dólar de Hong Kong)   5:INR (Rúpia Indiana)
   1
   Quantia que deseja converter?
   100
   Resposta da API: {"base":"BRL","rates":{"USD":0.1925}}
   0.1925
   100.00 BRL = 19.25 USD
   Obrigado por usar o conversor de moedas!
   

   ## Licença

   Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

   ## Contribuições

   Contribuições são bem-vindas! Por favor, sinta-se à vontade para enviar um Pull Request.

   ## Contato

   Para qualquer dúvida ou problema, por favor entre em contato pelo e-mail [contatotalitabielecky@gmail.com].
   
