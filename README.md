# CRUD-spring-boockstory

## configuração com Mysql 
. caso de erro de  fuso horario face os passos abaixo 

1 - abra o console do Mysql.
2 - digite SELECT NOW();

+---------------------+
| NOW()               |
+---------------------+
| 2015-07-02 22:38:29 |
+---------------------+
1 row in set (0.00 sec)

3 - digite SET @@global.time_zone = '+3:00';

.pronto ira funcionar o erro de fuso horario no spring
