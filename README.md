# infnetpos-daniel
EJB/MDB/JMS e SPRINGBOOT

REST API Com Swagger Rodando na Porta 8181/tcp
Desabilitei o modulo de segurança para agilizar os testes, mas a configuração está la e pode ser habilitada

Servidor EJB Ecommerce na 8080/tcp
Integração do JMS/MDB funcionando 100% podendo ser acompanhada pelo console.
Encontrei um bug que não consegui resolver ainda, o API responde aos comandos, salvando, deletando e listando os usuários, mas quando tento obter e instanciar um cliente sem lista recebo uma falha de Deserialização. Pelo que pesquisei o JBOSS pode ser um dos responsáveis por isso. Para agilizar não Mockei os dados de usuários, mas tirei a obrigatoriedade de associar o usuário nas consultas temporariamente.
