const mongoose = require("mongoose");
const { ObjectId } = mongoose.Schema;

const CartItemSchema = new mongoose.Schema(
  {
    product: { type: ObjectId, ref: "product" },
    name: String,
    price: Number,
    count: Number,
    seller: { type: ObjectId, ref: 'seller' },
    image: String
  }
);

const CartItem = mongoose.model("cartItem", CartItemSchema);

const OrderSchema = new mongoose.Schema(
  {
    products: [CartItemSchema],
    user: { type: ObjectId, ref: 'customer' }
  }
);

const Order = mongoose.model("order", OrderSchema);

module.exports = { Order, CartItem };