# API emailapp
Esta é a API para o aplicativo EasyInbox, um serviço de gerenciamento de e-mails que permite que os usuários façam login, enviem, recebam, classifiquem e personalizem suas preferências de visualização de e-mails, além de contar com um sistema de controle de spam.

## Objetivo
A EasyInbox API foi desenvolvida para gerenciar preferências de usuário (temas, cores, categorias) e fornecer um mock de serviços de e-mail. A aplicação foi projetada para ser consumida tanto por aplicativos web quanto por aplicativos móveis (Android).

## Funcionalidades Principais
**Gerenciamento de Preferências de Usuário:**

- Os usuários podem ajustar suas preferências como temas, cores, categorias e rótulos.
- As preferências são armazenadas em um banco de dados MongoDB e podem ser migradas para outros dispositivos.

**Mock de Serviços de E-mail:**
- Listagem de e-mails recebidos.
- Detalhamento de um e-mail específico.
- Envio de novos e-mails.
- Filtragem de e-mails por categoria.

  **Controle de Spam:**
 - Sistema de limitação de envio para prevenir abuso.
 - Identificação de padrões de envio que possam ser considerados spam.

## Tecnologias Utilizadas
- Backend: Java com Spring Boot.
- Banco de Dados: MongoDB.
- Autenticação: JWT (JSON Web Tokens).
- Consumo de API no Front-End Mobile: Retrofit + Gson no Android.

  ##Requisitos
  - JDK 11 ou superior.
  - Maven 3.6+.
  - MongoDB rodando localmente ou em um servidor remoto.
 
  ## REPO DO FRONT
  ````
  https://github.com/LucianeC/EasyInbox
  ````
  
  Este projeto foi desenvolvido como parte do curso na **FIAP** com a iniciativa da **Locaweb** 
