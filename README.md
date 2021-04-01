# CRUD-spring-boockstory

## configuração com Mysql 
* caso de erro de  fuso horario face os passos abaixo 
* - abra o console do Mysql.
* - digite SET @@global.time_zone = '+3:00';
* - pronto ira funcionar o erro de fuso horario no spring
* - caso for da um clone mude o aplication.properties de PROD para DEV 
# requisições 

$ GET =  https://api-bookstory.herokuapp.com/categorias isto listará todas as categorias
$ GET =  https://api-bookstory.herokuapp.com/livros/ apos o / selecione um id que le listara os livros
