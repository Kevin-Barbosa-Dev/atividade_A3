🧠 Funcionalidades

- 📄 **Leitura de Dados**  
  Leitura dos dados do grafo representado em um arquivo `.txt`.

- 🔗 **Conexões por Creche**  
  Exibe o número de conexões possíveis a partir de cada creche.

- 📋 **Listagem de Conexões Ordenadas**  
  Para uma creche específica, lista as creches conectadas em ordem crescente de distância.

- 📏 **Distância entre Creches**  
  Informa a distância entre duas creches informadas, se houver conexão.

- ➕ **Inserção de Novas Conexões**  
  Permite adicionar novas conexões entre creches.

## ⚙️ Requisitos Técnicos

- As conexões entre creches são armazenadas em uma **matriz de adjacência estática**, utilizando `0` e `1` para indicar a presença de ligação.
- As creches e as distâncias são armazenadas em uma **lista simplesmente encadeada**, implementada manualmente, **sem uso de estruturas nativas da linguagem**, como `ArrayList` ou `LinkedList`.
