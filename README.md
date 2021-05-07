## Atividade Sistemas Distribuido

Projeto realizado como atividade complementar da Disciplina de Sistemas Distribuido, consiste na comunicação entre dois microsserviços.

### Como executar

* Primeiro executar o serviço *credit-card* e cadastrar um cartão.  
* Logo após executar o serviço *carro* e cadastrar um carro.  
* Em seguida enviar uma requisição do tipo **GET** para o endpoint */carro/{id}*, onde o id será a indicação do carro desejado.

#### Atenção

Dependendo do banco de dados utilizado, talvez seja necessario mudar as configurações no *aplication.properties*.
