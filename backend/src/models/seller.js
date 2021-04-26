const mongoose = require('mongoose');

const orderSchema = new mongoose.Schema({
    customer: {
        type: mongoose.Types.ObjectId,
        ref: 'customer'
    },
    products: {
        type: mongoose.Types.ObjectId,
        ref: 'product'
    }
});

const sellerSchema = new mongoose.Schema(
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
        phone: {
            type: Number
        },
        pin: {
            type: Number
        },
        coordintes: {
            type: String
        },
        orders: [
            orderSchema
        ],
        type: String,
    },
    { timestamps: true }
);

const seller = mongoose.model('seller', sellerSchema);
const order = mongoose.model('order', orderSchema);
module.exports = { seller, order };