[index.html](api/index.html)
[Website Demo Videol](api/index.html)

# BakeryShop

A web-based application for a bakery storefront, built with a Spring Boot MVC architecture. It allows users to browse a menu, add items to a cart, and place orders for delivery. The project leverages Java, JavaScript, and HTML, using EJS for dynamic page generation. With server-side logic, session management for carts, and persistent data storage in MySQL, BakeryShop showcases a complete Model-View-Controller (MVC) structure, offering a seamless digital shopping experience.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Database Structure](#database-structure)
- [Getting Started](#getting-started)
- [Documentation](#documentation)

## Features
- **Menu Viewing**: Users can browse food categories, items, and prices.
- **Cart Functionality**: Users can add items to a cart, adjust quantities, and view the cart.
- **Order Processing**: Customers enter their delivery details at checkout and confirm their orders.
- **Order Confirmation**: A confirmation page displays the order ID and a thank-you message.
- **Error Handling**: An error page handles navigation or processing errors.
- **Session Management**: Carts are stored in sessions, preserving data across pages.
- **Persistent Storage**: User and order data are stored in a MySQL database using JPA with Spring Data.

## Technologies Used
- **Languages**: Java, JavaScript, HTML
- **Frameworks**: Spring Boot, EJS (Embedded JavaScript templates)
- **Database**: MySQL (managed with XAMPP)
- **Server**: Apache (launched via XAMPP)
- **Dependency Injection**: Managed with Spring beans

## Project Structure
The application is structured following the Spring Boot MVC design pattern:
- **Controllers**: Handle HTTP requests and direct views.
- **Views**: EJS templates render HTML pages dynamically on the server side.
- **Beans**: Manage application logic and session data, with dependencies injected via Spring.
- **Database**: Data is stored persistently in a MySQL database, managed with JPA and repository beans.

## Database Structure
The database schema for the BakeryShop project is organized as follows:

- **User**: Represents users of the application and contains the primary user details. This table has a relationship with:
  - **OnlineDelivery**: Represents individual online orders associated with a User. Each OnlineDelivery contains:
    - **FoodOrder**: Represents each item in the order, allowing for multiple food items to be associated with one delivery. Each FoodOrder contains:
      - **Food**: Represents the specific food item ordered (e.g., pastries, cakes, drinks).
    - **Address**: Stores delivery address details (e.g., street, city, zip code) for each order.

This structure uses JPA to manage the relationships between entities, with the following relationships:
- `User` to `OnlineDelivery`: One-to-One
- `OnlineDelivery` to `FoodOrder`: One-to-Many
- `OnlineDelivery` to `Address`: One-to-One
- `FoodOrder` to `Food`: Many-to-One

## Getting Started
To run the application locally:

1. **Start XAMPP**:
   - Open XAMPP and start both Apache and MySQL services.

2. **Set Up the Database**:
   - Open [phpMyAdmin](http://localhost/phpmyadmin) in your browser.
   - Create a new database called `user_data` with the collation set to `utf8_general_ci`.

3. **Run the Application**:
   - In IntelliJ, run the project to start the Spring Boot server.
   - Open a web browser and navigate to [http://localhost:8080](http://localhost:8080) to access the website.

## Documentation
The project includes an [index.html](api/index.html) file documenting the application's structure and usage.
