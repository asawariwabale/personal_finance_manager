# Personal_finance_manager

Personal Finance Manager is a full-stack web application that helps users efficiently track and manage their income, expenses, and financial activities.
The system provides a secure backend using **Spring Boot** and **MySQL**, along with a responsive and modern frontend built using **React**, **JavaScript**, and **Bootstrap**.
This project demonstrates full-stack development skills including REST API creation, database integration, state management, and responsive UI design.

---
## Table of Contents
1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Project Structure](#project-structure)
4. [Installation](#installation)
5. [Usage](#usage)
6. [Docker Deployment](#docker-deployment-optional)

   ## Features
   
  - **User Authentication**
  Register and log in with JWT-based authentication, providing secure access to personal     
     finance data.

 - **Transaction Management**
  Add income or expense transactions.
  Specify amount, category, date, and description.
  View all transactions.
  Delete or update transactions.

 - **Category Management**

     Users can:
  Create custom categories (e.g., Rent, Groceries, Salary, Utilities) Delete categories Assign     categories to transactions


  - **User Profile**
    
    View account details Manage personal information  Secure user-specific data access

  - **Dashboard Statistics**
     - Total Income
     - Total Expenses
     - Current Balance
     - Summary cards for quick overview

   - **Transaction Filters**
     - Filter by income or expense
     - Filter by category
     - Better tracking and financial insights

   - **Protected Endpoints**
     All backend APIs are secured using JWT authentication. Each user can only access their own       financial data.

     - **Responsive UI**
      - Built with React.js + Bootstrap
      - Fully responsive for desktop and mobile devices
      - Clean and user-friendly interface

## Tech Stack
  
🔹 **Backend**
   - [Java](https://www.oracle.com/java/)
   - [SpringBoot](https://spring.io/projects/spring-boot)
   - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
   - [Spring Security](https://spring.io/projects/spring-security)
   - [Hibernate](https://hibernate.org/)
   - [Maven](https://maven.apache.org/)

🔹 **Frontend**
    - [React.js](https://reactjs.org/)
    - [React Rounter](https://reactrouter.com/)
    - [Boostrap](https://getbootstrap.com/)
    - [Axios](https://axios-http.com/)

🔹 **Database**
    - [MySQL](https://www.mysql.com/)
    

## Project Structure

```plaintext
Personal-Finance-Manager
│
├── backend (Spring Boot)
│   ├── controller
│   ├── service
│   ├── dao
│   ├── model
│   └── config
│
├── frontend (React)
│   ├── components
│   ├── pages
│   ├── context
│   └── services
│
└── README.md

```
## Installation

  ## 1.Clone the Repository
```bash
  git clone https://github.com/your-username/Personal-Finance-Manager.git
cd Personal-Finance-Manager
```
🔹 **Backend Setup (Spring Boot)**
     
  ## 2. **Open in Eclipse**
    - Open **Eclipse IDE**
    - Click **File → Import → Existing Maven Project**
    - Select the backend folder
    - Click **Finish**












   
