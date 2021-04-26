const mongoose = require("mongoose");

const productSchema = new mongoose.Schema({
    name: {
        type: String
    },
    price: {
        type: Number,
    }, 
    category: {
        type: String, 
        enum: ['fruit', 'vegetable', 'non-veg', 'packet-food']
    },
    image: {
        type: String
    },
    seller: {
        type: mongoose.Types.ObjectId,
        ref: 'seller'
    }
}, { timestamps: true });

module.exports = mongoose.model('product', productSchema);