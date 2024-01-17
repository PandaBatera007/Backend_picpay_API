# Backend_picpay_API
API Criada com Spring Boot(v3.1.3)<br>
Gerenciador de Dependências MAVEN<br>
Utilizando Biblioteca LOMBOK<br>
Banco de Dados H2<br>
.<br>
.<br>
.<br>
.<br>
Os links de Autorização não estão mais funcionando. <br>
Para resolver eventual bug com essas partes do código, comente( // ) nas linhas de validação dentro dos métodos:<br><br>
• createTransaction(TransactionDTO transaction) da classe TransactionService<br><br>
comente as seguintes chamadas de métodos:<br>
-//this.notificationService.sendNotification(sender, "Transação realizada com sucesso");<br>
^^<br>
-//this.notificationService.sendNotification(receiver, "Transação recebida com sucesso");<br>
^^<br><br>

• authorizeTransaction(User sender, BigDecimal value) da mesma classe.<br>
comente todas as linhas desse método, e adicione um "return true;"<br><br>

isso deve fazer funcionar ;-)
