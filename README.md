# CRUD-spring-boockstory

## configuração com Mysql 
. caso de erro de  fuso horario face os passos abaixo 

1 - abra o console do Mysql.
2 - digite SELECT NOW();
3 - digite SET @@global.time_zone = '+3:00';

.pronto ira funcionar o erro de fuso horario no spring
