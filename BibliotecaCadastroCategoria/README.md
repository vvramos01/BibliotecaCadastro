# Cadastro de Categorias

Rotas:
- `GET /categorias/novo` formulário
- `POST /categorias` salva a categoria
- `GET /categorias` lista as categorias
- `GET /categorias/excluir/{id}` exclui pelo id

Rodar: `./mvnw spring-boot:run` e abrir http://localhost:8080/categorias

O banco H2 fica em arquivo (`data/`), então as categorias continuam depois de reiniciar.
