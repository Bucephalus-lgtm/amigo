const { Order } = require('../models/order');

exports.create = (req, res) => {
    req.body.order.customer = req.customer;
    const order = new Order(req.body.order);
    console.log(order);
    order.save((error, data) => {
        console.log({ data: data.products });
        if (error) {
            return res.status(400).json({
                error
            });
        }
        res.json({ orders: data });
    });
};