const { Order } = require('../models/order');
const Seller = require('../models/seller');

exports.get_all_sellers = async (req, res) => {
    const sellers = await Seller.find();
    return res.json({ sellers });
}

exports.seller_by_id = async (req, res) => {
    const seller = await Seller.findById(req.params.id);
    return res.json({ seller });
}

exports.receive_orders = async (req, res) => {
    const sellerId = req.params.id;
    console.log(sellerId);
    const ordersReceived = await Order.find({ 'products': { $elemMatch: { seller: sellerId } } });
    return res.json({ ordersReceived });
}