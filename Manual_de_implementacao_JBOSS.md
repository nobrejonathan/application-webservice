Luciano dos Passos Almeida Manual de Implantação Application WebService?

Implantando projeto no Jboss-as-7.1.1.Final

Primeiro passo

Configurar o driver do MySql?

Na pasta do Jboss entre em modules/com e crie uma pasta chamada mysql e dentro desse diretório crie uma pasta chamada main. Copie o driver do mysql para dentro dessa pasta main. Crie um arquivo com o nome module.xml com o seguinte conteudo: <?xml version="1.0" encoding="UTF-8"?>



&lt;module xmlns="urn:jboss:module:1.1" name="com.mysql"&gt;




&lt;resources&gt;




&lt;resource-root path="mysql-connector-java-5.1.7-bin.jar"&gt;




&lt;/resource-root&gt;




&lt;/resources&gt;




&lt;dependencies&gt;




&lt;module name="javax.api"&gt;




&lt;/module&gt;




&lt;module name="javax.transaction.api"&gt;




&lt;/module&gt;




&lt;module name="javax.servlet.api" optional="true"&gt;




&lt;/module&gt;




&lt;/dependencies&gt;




&lt;/module&gt;


Pronto o driver do mysql está configurado.

Agora é necessário criar um datasource e declarar o driver no arquivo de configurações do Jboss o standalone.xml Partindo da pasta do Jboss entre em standalone\configuration e abra o arquivo chamado standalone.xml. Nesse arquivo dentro da tag



&lt;drivers&gt;


declare o seguinte driver:


&lt;driver name="mysql" module="com.mysql"&gt;




&lt;xa-datasource-class&gt;


com.mysql.jdbc.JdbcDataSource?


&lt;/xa-datasource-class&gt;




&lt;/driver&gt;


Após feito isso nesse arquivo dentro da tag



&lt;datasources&gt;


declare o seguinte datasource:


&lt;datasource jndi-name="java:jboss/datasources/alunosDS" pool-name="alunosDS" enabled="true" use-java-context="true"&gt;




&lt;connection-url&gt;


jdbc:mysql://localhost:3306/BD\_ALUNOS


&lt;/connection-url&gt;




&lt;driver&gt;


mysql


&lt;/driver&gt;




&lt;security&gt;




&lt;user-name&gt;


root


&lt;/user-name&gt;




&lt;password&gt;


root


&lt;/password&gt;




&lt;/security&gt;




&lt;/datasource&gt;


Nesse data source configure o user name e o password de acordo com o do mysql que estiver usando.

Após feito essa configuração já é possível rodar a aplicação. Lembrando que é necessario no mysql criar um banco de dados chamado BD\_ALUNOS ou mudar o nome do banco de dados na tag



&lt;connection-url&gt;


do datasource declarado anteriormente.