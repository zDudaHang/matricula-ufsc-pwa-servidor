# Subindo o servidor

Para subir o servidor, é necessário possuir algumas informações:

- Um arquivo de configuração do firebase no formato JSON que deve ser guardado nos `resources` (nome da property: `app.firebase-configuration-file` )
- Um secret para a geração dos JWTs (nome da property: `jwt.secret`)

Depois de ter essas informações, execute os seguintes comandos:

```
# Subindo o banco de dados:
docker-compose up -d database

# Subindo o servidor:
mvn spring-boot:run
```

TODO @zDudaHang:
- Explicar a arq. (O qué um Command / Query / Input / Validator / etc)
- Explicitar as variáveis de ambiente que precisam ser definidas
