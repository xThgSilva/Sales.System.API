# API Documentation - Sales System

## Description

This API was developed with Spring Boot and provides features to manage and execute functionalities of a sales system, allowing CRUD operations. The API allows you to create, read, update, and delete **products**, **customers**, and **sales**.

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

## Endpoints

### Customers

### 1. POST `/costumer/register`

Creates a new customer.

**Request**

* **URL:** `/costumer/register`
* **Method:** POST
* **Header:**

  * Content-Type: application/json
* **Body:**

```json
{
    "name": "name",
    "email": "email@email.com",
    "telephone": 1234567890
}
```

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
{
    "id": 1,
    "name": "name",
    "email": "email@email.com",
    "telephone": 1234567890
}
```

---

### 2. GET `/costumer/all`

Lists all registered customers.

**Request**

* **URL:** `/costumer/all`
* **Method:** GET

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
[
    {
        "id": 1,
        "name": "name",
        "email": "email@email.com",
        "telephone": 1234567890
    },
    {
        "id": 2,
        "name": "another name",
        "email": "email@email.com",
        "telephone": 1234567890
    }
]
```

---

### 3. GET `/costumer/{id}`

Fetches a specific customer by ID.

**Request**

* **URL:** `/costumer/{id}`
* **Method:** GET
* **URL Parameter:**

  * `id` - Customer ID

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
{
    "id": 1,
    "name": "name",
    "email": "email@email.com",
    "telephone": 1234567890
}
```

**Error**

* **Status Code:** 404 Not Found
* **Body:**

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

Updates an existing customer's data.

**Request**

* **URL:** `/costumer/update/{id}`
* **Method:** PUT
* **URL Parameter:**

  * `id` - Customer ID
* **Header:**

  * Content-Type: application/json
* **Body:**

```json
{
    "name": "new name",
    "email": "new.email@email.com",
    "telephone": 11999999999
}
```

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
{
    "id": 1,
    "name": "name name",
    "email": "new.email@email.com",
    "telephone": 11999999999
}
```

---

### 5. DELETE `/costumer/delete/{id}`

Deletes a customer.

**Request**

* **URL:** `/costumer/delete/{id}`
* **Method:** DELETE
* **URL Parameter:**

  * `id` - Customer ID

**Response**

* **Status Code:** 204 No Content

**Error**

* **Status Code:** 404 Not Found
* **Body:**

```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Customer with Id: 1 not found."
}
```

---

### Products

### 1. POST `/product/register`

Creates a new product.

**Request**

* **URL:** `/product/register`
* **Method:** POST
* **Header:**

  * Content-Type: application/json
* **Body:**

```json
{
    "name": "Dell Notebook",
    "price": 3500.00,
    "stockQuantity": 15
}
```

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
{
    "id": 1,
    "name": "Dell Notebook",
    "price": 3500.00,
    "stockQuantity": 15
}
```

---

### 2. GET `/product/all`

Lists all registered products.

**Request**

* **URL:** `/product/all`
* **Method:** GET

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
[
    {
        "id": 1,
        "name": "Dell Notebook",
        "price": 3500.00,
        "stockQuantity": 15
    },
    {
        "id": 2,
        "name": "Logitech Mouse",
        "price": 150.00,
        "stockQuantity": 50
    }
]
```

---

### 3. GET `/product/{id}`

Fetches a specific product by ID.

**Request**

* **URL:** `/product/{id}`
* **Method:** GET
* **URL Parameter:**

  * `id` - Product ID

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
{
    "id": 1,
    "name": "Dell Notebook",
    "price": 3500.00,
    "stockQuantity": 15
}
```

**Error**

* **Status Code:** 404 Not Found
* **Body:**

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

Updates an existing product's data.

**Request**

* **URL:** `/product/update/{id}`
* **Method:** PUT
* **URL Parameter:**

  * `id` - Product ID
* **Header:**

  * Content-Type: application/json
* **Body:**

```json
{
    "name": "Dell Inspiron Notebook",
    "price": 3800.00,
    "stockQuantity": 20
}
```

**Response**

* **Status Code:** 200 OK
* **Body:**

```json
{
    "id": 1,
    "name": "Dell Inspiron Notebook",
    "price": 3800.00,
    "stockQuantity": 20
}
```

---

### 5. DELETE `/product/delete/{id}`

Deletes a product.

**Request**

* **URL:** `/product/delete/{id}`
* **Method:** DELETE
* **URL Parameter:**

  * `id` - Product ID

**Response**

* **Status Code:** 204 No Content

**Error**

* **Status Code:** 404 Not Found
* **Body:**

```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Product with Id: 1 not found."
}
```

---

### Sales

### 1. POST `/sale/register`

Registers a new sale. The system automatically calculates the total value and updates the product stock.

**Request**

* **URL:** `/sale/register`
* **Method:** POST
* **Header:**

  * Content-Type: application/json
* **Body:**

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

**Response**

* **Status Code:** 200 OK
* **Body:**

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

**Error - Customer Not Found**

* **Status Code:** 404 Not Found
* **Body:**

```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Customer with Id: 1 not found."
}
```

**Error - Product Not Found**

* **Status Code:** 404 Not Found
* **Body:**

```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Product with id: 1 not found."
}
```

**Error - Insufficient Stock**

* **Status Code:** 409 Conflict
* **Body:**

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

Lists all completed sales.

**Request**

* **URL:** `/sale/all`
* **Method:** GET

**Response**

* **Status Code:** 200 OK
* **Body:**

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

Fetches a specific sale by ID.

**Request**

* **URL:** `/sale/{id}`
* **Method:** GET
* **URL Parameter:**

  * `id` - Sale ID

**Response**

* **Status Code:** 200 OK
* **Body:**

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

**Error**

* **Status Code:** 404 Not Found
* **Body:**

```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Sale with Id: 1 not found."
}
```

---

## Error Handling

The API uses a global exception handling system that returns standardized responses:

### Error Structure

```json
{
    "timestamp": "2025-01-04T10:30:00",
    "status": 404,
    "error": "Not Found.",
    "message": "Descriptive error message"
}
```

## Important Notes

1. **Stock Control:** When registering a sale, the product stock is automatically decremented.
2. **Sale Date:** The date is automatically generated by the system at the time of registration.
3. **Automatic Calculation:** The total sale value is automatically calculated based on prices and quantities.
4. **Validations:** The system validates the existence of customers and products before processing sales.

## Author

* [@Thiago](https://www.github.com/xThgSilva)
