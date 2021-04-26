const mongoose = require('mongoose');

const db = () => {
    mongoose.connect('mongodb+srv://nest:nest@cluster0.i8sxu.mongodb.net/sarthi?retryWrites=true&w=majority',
        { useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true })
        .then(() => console.log('MongoDB connected...'))
        .catch(err => console.log(err));
}

module.exports = db;