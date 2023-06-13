### Principais pontos de reprovação no desafio técnico:

* Não foi implementado nenhum teste unitário.
* Tratamento de erros centralizado na controller.
* Não seguiu padrão REST na definição da API.
* A cada notificação é feita uma verificação para saber se o usuário fez opt-out, a solução teria problemas de escala.
* Havia métodos extensos no código que poderiam ser quebrados para melhorar a legibilidade.
* Se executássemos mais de uma instância da app, teríamos problemas de concorrência.

### Dicas de estudo:
* Modelos de arquitetura de sistemas com alta resiliência e alta escala. Existe um canal no youtube muito legal sobre este assunto: https://www.youtube.com/channel/UCRPMAqdtSgd0Ipeef7iFsKw
* Arquiteturas de Microservices. Estes livros valem muito a pena: Building Microservices: Designing Fine-Grained Systems (https://www.amazon.com/Building-Microservices-Designing-Fine-Grained-Systems/dp/1491950358?messenger=email) e Microservices Patterns: With examples in Java (https://www.amazon.com/Microservices-Patterns-examples-Chris-Richardson/dp/1617294543/ref=sr_1_1?crid=QZ8NDXVBO778&keywords=microservices+patterns&qid=1581024568&s=books&sprefix=microserv%2Cstripbooks-intl-ship%2C265&sr=1-1&messenger=email)
* Estes livros sobre boas práticas de codificação e arquitetura também valem muito a pena https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882/ref=sr_1_1?keywords=clean+code&qid=1581599570&sr=8-1&messenger=email e https://www.amazon.com/Clean-Architecture-Craftsmans-Software-Structure/dp/0134494164/ref=sr_1_1?crid=130R1OMLCHDDJ&keywords=clean+architecture&qid=1581599529&sprefix=clean+ar%2Caps%2C274&sr=8-1&messenger=email.
* Bancos SQL vs NoSQL (vantagens, desvantagens, etc). Existe um livro muito bom sobre este assunto: NoSQL Distilled (https://martinfowler.com/books/nosql.html?messenger=email)
* REST API modeling: How to design a REST API (https://blog.octo.com/design-a-rest-api/?messenger=email) e The REST API Design Handbook (https://www.amazon.com/REST-API-Design-Handbook-ebook/dp/B00890OBFI/ref=sr_1_1?dchild=1&keywords=the+rest+api+design+handbook&qid=1589558409&sr=8-1&messenger=email) 