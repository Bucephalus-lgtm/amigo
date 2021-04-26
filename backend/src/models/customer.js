const mongoose = require('mongoose');

const customerSchema = new mongoose.Schema(
    {
        name: {
            type: String
        },
        email: {
            type: String
        },
        password: {
            type: String
        },
        type: {
            type: String
        }
    },
    { timestamps: true }
);

module.exports = mongoose.model('customer', customerSchema);