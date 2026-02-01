# 📦 Estoque-Front

## 📌 Descrição
Estoque-Front é uma aplicação desktop front-end desenvolvida em **Java** com **JavaFX**, utilizando **FXML** e **SceneBuilder** para a construção das interfaces.

O projeto tem como foco inicial permitir a busca de produtos através de uma **API backend**, possibilitando localizar um produto por **ID, nome ou código**.  
Esta é a primeira etapa do sistema de gestão de estoque, projetada para evoluir com novas funcionalidades.

---

## 🎯 Funcionalidade Atual
- ✔️ Buscar produto por **ID**  
- ✔️ Buscar produto por **nome**  
- ✔️ Buscar produto por **código do produto**  
- ✔️ Consumo de **API REST** para obtenção dos dados  
- ✔️ Exibição dos dados do produto na interface **JavaFX**

---

## 🔗 Dependência do Backend
⚠️ A aplicação front-end depende de um **backend em execução** para funcionar corretamente.

O backend é responsável por:
- Disponibilizar a **API REST**  
- Processar as requisições de busca  
- Retornar os dados dos produtos  

➡️ Sem o backend ativo, a funcionalidade de busca não retornará resultados.

# Link do Backend
https://github.com/Felipe-Osorio-Dev/Estoque-BackEnd

**Importante:** Certifique-se de que o backend esteja rodando antes de iniciar o front-end.  
*(Se quiser, depois podemos linkar diretamente o repositório do backend aqui.)*

---

## 🚀 Funcionalidades Planejadas
- 🔜 Listagem de produtos  
- 🔜 Cadastro de produtos  
- 🔜 Edição de produtos  
- 🔜 Exclusão de produtos  
- 🔜 Integração completa front + backend  
- 🔜 Persistência em banco de dados  

---

## 🛠️ Tecnologias Utilizadas
- Java 11+  
- JavaFX  
- FXML + SceneBuilder  
- Maven  
- Consumo de API REST (**HTTP Client**)  

---

## 🖼️ Imagens do Sistema

<img width="300" height="280" alt="homeScreen" src="https://github.com/user-attachments/assets/2272a557-dfbe-432c-87ff-244e4efcc477" />
<img width="300" height="280" alt="registerScreen" src="https://github.com/user-attachments/assets/04dae461-f88e-4acd-8008-7e1c1dec3855" />
<img width="300" height="280" alt="productScreen" src="https://github.com/user-attachments/assets/6d4ad49a-394a-447b-a518-22a01e63ad3d" />

---

## ▶️ Como Executar o Projeto

### 🧾 Pré-requisitos
- JDK 11+  
- Maven  
- Backend da aplicação em execução  

### 🏃‍♂️ Passos para execução
```bash
# Clone o repositório do front-end
git clone https://github.com/Felipe-Osorio-Dev/Estoque-Front.git
cd Estoque-Front

# Inicie o backend da aplicação (API REST)

# Execute o front-end
mvn clean javafx:run
```

---

## 🧠 Conceitos e Boas Práticas
- Separação de responsabilidades (UI ↔ Controller ↔ Model)

- Consumo de API REST

- Código preparado para expansão

- Uso de FXML para desacoplamento da interface

---

## 📈 Status do Projeto
🚧 Em desenvolvimento

✔️ Funcionalidade implementada: Busca de produto via API

## 👤 Autor
- Felipe Osório  
- GitHub: [Felipe-Osorio-Dev](https://github.com/Felipe-Osorio-Dev)
