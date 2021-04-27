const dotenv = require('dotenv');
dotenv.config();

const express = require('express');
const cookieParser = require('cookie-parser');
const cors = require('cors');
const db = require('./src/database');

const app = express();

app.use(express.json());
app.use(cookieParser());
app.use(cors());
db();

const auth = require('./src/routes/public/auth');
const product = require('./src/routes/public/products');
const order = require('./src/routes/public/orders');
const seller = require('./src/routes/public/seller');
const customer = require('./src/routes/public/customer');
const query = require('./src/routes/public/query');

app.get('/api', (req, res) => res.send('API working fine!'));

app.use('/api', auth);
app.use('/api', product);
app.use('/api', order);
app.use('/api', seller);
app.use('/api', customer);
app.use('/api', query);

const PORT = process.env.PORT || 5000;

app.listen(PORT, console.log(`Server started on port ${PORT}...`));