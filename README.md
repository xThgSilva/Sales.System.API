# Documentação da API - Sistema de Vendas

## Descrição
Esta API foi desenvolvida com Spring Boot e oferece funcionalidades para gerenciar e executar funcionalidades de um sistema de vendas, que permite realizar operações CRUD. A API permite criar, ler, atualizar e deletar **produtos**, **clientes** e **vendas**.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Endpoints

### Customers (Clientes)

### 1. POST `/costumer/register`
Cria um novo cliente.

**Requisição**
- **URL:** `/costumer/register`
- **Método:** POST
- **Cabeçalho:**
  - Content-Type: application/json
- **Corpo:**
```json
{
    "name": "nome",
    "email": "email@email.com",
    "telephone": 1234567890
}
```

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "name": "nome",
    "email": "email@email.com",
    "telephone": 1234567890
}
```

---

### 2. GET `/costumer/all`
Lista todos os clientes cadastrados.

**Requisição**
- **URL:** `/costumer/all`
- **Método:** GET

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
[
    {
    "id": 1,
    "name": "nome",
    "email": "email@email.com",
    "telephone": 1234567890
    },
    {
        "id": 2,
        "name": "outro nome",
        "email": "email@email.com",
        "telephone": 1234567890
    }
]
```

---

### 3. GET `/costumer/{id}`
Busca um cliente específico por ID.

**Requisição**
- **URL:** `/costumer/{id}`
- **Método:** GET
- **Parâmetro de URL:**
  - `id` - ID do cliente

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "name": "nome",
    "email": "email@email.com",
    "telephone": 1234567890
}
```

**Erro**
- **Código de Status:** 404 Not Found
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Customer with Id: 1 not found."
}
```

---

### 4. PUT `/costumer/update/{id}`
Atualiza os dados de um cliente existente.

**Requisição**
- **URL:** `/costumer/update/{id}`
- **Método:** PUT
- **Parâmetro de URL:**
  - `id` - ID do cliente
- **Cabeçalho:**
  - Content-Type: application/json
- **Corpo:**
```json
{
    "name": "novo nome",
    "email": "email.novo@email.com",
    "telephone": 11999999999
}
```

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "name": "nome nome",
    "email": "email.novo@email.com",
    "telephone": 11999999999
}
```

---

### 5. DELETE `/costumer/delete/{id}`
Deleta um cliente.

**Requisição**
- **URL:** `/costumer/delete/{id}`
- **Método:** DELETE
- **Parâmetro de URL:**
  - `id` - ID do cliente

**Resposta**
- **Código de Status:** 204 No Content

**Erro**
- **Código de Status:** 404 Not Found
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Customer with Id: 1 not found."
}
```

---

### Products (Produtos)

### 1. POST `/product/register`
Cria um novo produto.

**Requisição**
- **URL:** `/product/register`
- **Método:** POST
- **Cabeçalho:**
  - Content-Type: application/json
- **Corpo:**
```json
{
    "name": "Notebook Dell",
    "price": 3500.00,
    "stockQuantity": 15
}
```

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "name": "Notebook Dell",
    "price": 3500.00,
    "stockQuantity": 15
}
```

---

### 2. GET `/product/all`
Lista todos os produtos cadastrados.

**Requisição**
- **URL:** `/product/all`
- **Método:** GET

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
[
    {
        "id": 1,
        "name": "Notebook Dell",
        "price": 3500.00,
        "stockQuantity": 15
    },
    {
        "id": 2,
        "name": "Mouse Logitech",
        "price": 150.00,
        "stockQuantity": 50
    }
]
```

---

### 3. GET `/product/{id}`
Busca um produto específico por ID.

**Requisição**
- **URL:** `/product/{id}`
- **Método:** GET
- **Parâmetro de URL:**
  - `id` - ID do produto

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "name": "Notebook Dell",
    "price": 3500.00,
    "stockQuantity": 15
}
```

**Erro**
- **Código de Status:** 404 Not Found
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Product with Id: 1 not found."
}
```

---

### 4. PUT `/product/update/{id}`
Atualiza os dados de um produto existente.

**Requisição**
- **URL:** `/product/update/{id}`
- **Método:** PUT
- **Parâmetro de URL:**
  - `id` - ID do produto
- **Cabeçalho:**
  - Content-Type: application/json
- **Corpo:**
```json
{
    "name": "Notebook Dell Inspiron",
    "price": 3800.00,
    "stockQuantity": 20
}
```

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "name": "Notebook Dell Inspiron",
    "price": 3800.00,
    "stockQuantity": 20
}
```

---

### 5. DELETE `/product/delete/{id}`
Deleta um produto.

**Requisição**
- **URL:** `/product/delete/{id}`
- **Método:** DELETE
- **Parâmetro de URL:**
  - `id` - ID do produto

**Resposta**
- **Código de Status:** 204 No Content

**Erro**
- **Código de Status:** 404 Not Found
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Product with Id: 1 not found."
}
```

---

### Sales (Vendas)

### 1. POST `/sale/register`
Registra uma nova venda. O sistema calcula automaticamente o valor total e atualiza o estoque dos produtos.

**Requisição**
- **URL:** `/sale/register`
- **Método:** POST
- **Cabeçalho:**
  - Content-Type: application/json
- **Corpo:**
```json
{
    "custumerId": 1,
    "items": [
        {
            "productId": 1,
            "amount": 2
        },
        {
            "productId": 2,
            "amount": 5
        }
    ]
}
```

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "saleDate": "2025-01-04",
    "totalValue": 7750.00,
    "customer": {
        "id": 1,
        "name": "Thiago",
        "email": "camposthiago2021@gmail.com",
        "telephone": 11978337448
    },
    "items": [
        {
            "id": 1,
            "amount": 2,
            "unitPrice": 3500.00,
            "productId": 1,
            "sale": null
        },
        {
            "id": 2,
            "amount": 5,
            "unitPrice": 150.00,
            "productId": 2,
            "sale": null
        }
    ]
}
```

**Erro - Cliente não encontrado**
- **Código de Status:** 404 Not Found
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Customer with Id: 1 not found."
}
```

**Erro - Produto não encontrado**
- **Código de Status:** 404 Not Found
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Product with id: 1 not found."
}
```

**Erro - Estoque insuficiente**
- **Código de Status:** 409 Conflict
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 409,
    "error": "Conflict.",
    "message": "Insufficient quantity in stock"
}
```

---

### 2. GET `/sale/all`
Lista todas as vendas realizadas.

**Requisição**
- **URL:** `/sale/all`
- **Método:** GET

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
[
    {
        "id": 1,
        "saleDate": "2025-01-04",
        "totalValue": 7750.00,
        "customer": {
            "id": 1,
            "name": "Thiago",
            "email": "camposthiago2021@gmail.com",
            "telephone": 11978337448
        },
        "items": [
            {
                "id": 1,
                "amount": 2,
                "unitPrice": 3500.00,
                "productId": 1,
                "sale": null
            }
        ]
    }
]
```

---

### 3. GET `/sale/{id}`
Busca uma venda específica por ID.

**Requisição**
- **URL:** `/sale/{id}`
- **Método:** GET
- **Parâmetro de URL:**
  - `id` - ID da venda

**Resposta**
- **Código de Status:** 200 OK
- **Corpo:**
```json
{
    "id": 1,
    "saleDate": "2025-01-04",
    "totalValue": 7750.00,
    "customer": {
        "id": 1,
        "name": "Thiago",
        "email": "camposthiago2021@gmail.com",
        "telephone": 11978337448
    },
    "items": [
        {
            "id": 1,
            "amount": 2,
            "unitPrice": 3500.00,
            "productId": 1,
            "sale": null
        }
    ]
}
```

**Erro**
- **Código de Status:** 404 Not Found
- **Corpo:**
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Sale with Id: 1 not found."
}
```

---

## Tratamento de Erros

A API utiliza um sistema de tratamento global de exceções que retorna respostas padronizadas:

### Estrutura de Erro
```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Mensagem descritiva do erro"
}
```
## Observações Importantes

1. **Controle de Estoque:** Ao registrar uma venda, o estoque dos produtos é automaticamente decrementado.
2. **Data da Venda:** A data é gerada automaticamente pelo sistema no momento do registro.
3. **Cálculo Automático:** O valor total da venda é calculado automaticamente com base nos preços e quantidades.
4. **Validações:** O sistema valida a existência de clientes e produtos antes de processar vendas.

## Autor
- [@Thiago](https://www.github.com/xThgSilva)
