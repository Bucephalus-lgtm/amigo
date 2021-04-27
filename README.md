# Amigo

## Introduction

A project to enhance the bridge between common people and sellers by maintaining covid 19 protocols

## Technology

The application is built with:

- Node.js
- MongoDB
- Express.js
- React.js
- Material UI

## Features

An application portal where users can browse through the products available nearby, buy them and even upload his own products for selling purpose.

User can create an account, login or logout as either customer or seller.

Customer can do the following:

- Browse available products added by the admin
- Add products to the shopping cart
- Display the shopping cart

Admins can do the following:

- Upload his own products with name, price, image etc.
- The profile contains all the orders he has received.

## Database

All the models can be found in the models directory created using mongoose.

## Run

To run this application, you have to set your own environmental variables. For security reasons, some variables have been hidden from view and used as environmental variables with the help of dotenv package. Below are the variables that you need to set in order to run the application:

- MONGODB_URL: this is the connection string of your MongoDB Atlas database.
- JWT_SECRET_KEY: Jsonweb token for signing a token from authentication purpose.

Now you can run, for backend,

```bash
cd frontend
npm i
npm start
```

For frontend,

```bash
cd backend
npm i
npm start
```

in the terminal and the application should work.

## Contributors

@[Bhargab Nath](https://github.com/Bucephalus-lgtm)

@[Pratik Gupta](https://github.com/inomag)

@[Tasneem Koushar](https://github.com/tasneemkoushar)

## License

[![License](https://img.shields.io/:License-MIT-blue.svg?style=flat-square)](http://badges.mit-license.org)

- MIT License
- Copyright 2020 © Team Amigo
