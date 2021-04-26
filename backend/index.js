const dotenv = require('dotenv');
dotenv.config();
const express = require('express');
const mongoose = require('mongoose');
const cookieParser = require('cookie-parser');
const cors = require('cors');
const app = express();

app.use(express.json());
app.use(cookieParser());
app.use(cors());

mongoose.connect('mongodb+srv://nest:nest@cluster0.i8sxu.mongodb.net/sarthi?retryWrites=true&w=majority', { useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true })
    .then(() => console.log('MongoDB connected...'))
    .catch(err => console.log(err));

// const auth = require('./routes/auth');

app.get('/api', (req, res) => res.send('API working fine!'));

// app.use('/api', auth);

const PORT = process.env.PORT || 5000;

app.listen(PORT, console.log(`Server started on port ${PORT}...`));