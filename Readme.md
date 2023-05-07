# Spring Project Ecommerce API

This is a Spring Boot project for an e-commerce API that allows users to manage orders, products, addresses, and users. The project uses MySQL for storing data, Hibernate for object-relational mapping, and Maven for building the project.
 It includes the following components:

- Controller: handles incoming requests and sends the response back to the user.
- Service: contains business logic and communicates with the database.
- Repository: handles database interactions.
- Database Design: [describe the database design used in the project].
- Data Structures: [describe any data structures used in the project].
# Prerequisites


Java 11 or higher
Maven
MySQL Server
Postman (optional)

## Frameworks/Languages Used

- JAVA
- Spring

## Data Flow

The application follows the following data flow:

Client makes a request to the REST API endpoint
Request is received by the Controller
Controller validates and passes the request to the Service
Service interacts with the Repository to perform database operations
Repository interacts with the database to perform CRUD operations
Data is returned to the Service
Service processes the data and returns it to the Controller
Controller returns a response to the client
## Controller

The Controller layer is responsible for receiving incoming requests and handling the request/response cycle. The following Controllers are available:

UserController: Handles requests related to user management
AddressController: Handles requests related to address management
ProductController: Handles requests related to product management
OrderController: Handles requests related to order management

## Service

The Service layer is responsible for processing business logic and handling interactions between the Controller and Repository layers. The following Services are available:

UserService: Provides functionality related to user management
AddressService: Provides functionality related to address management
ProductService: Provides functionality related to product management
OrderService: Provides functionality related to order management

## Repository

The Repository layer is responsible for interacting with the database and performing CRUD operations. The following Repositories are available:

UserRepository: Handles database interactions related to users
AddressRepository: Handles database interactions related to addresses
ProductRepository: Handles database interactions related to products
OrderRepository: Handles database interactions related to orders
## Database Design

The application uses PostgreSQL as its database. The following tables are available:

users: Stores user information
addresses: Stores address information
products: Stores product information
orders: Stores order information

## Data Structures

The application uses the following data structures:

ArrayList: Used to store lists of objects
HashMap: Used to store key-value pairs

## Summary

The Ecommerce application is a REST API that provides functionality for user management, address management, product management, and order management. Users can create an account, add addresses, browse products, add products to cart, and place orders. The application uses Spring Boot and PostgreSQL to provide a scalable and reliable solution.
