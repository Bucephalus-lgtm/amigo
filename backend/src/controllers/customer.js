const Customer = require('../models/customer');
const Seller = require('../models/seller');

exports.customerById = (req, res, next, id) => {
    Customer.findById(id).exec((err, customer) => {
        if (err || !customer) {
            return res.status(400).json({
                error: 'Customer not found'
            });
        }
        req.customer = customer;
        next();
    });
};

exports.sellers_by_pin = async (req, res) => {
    const seller = await Seller.findOne({ pin: req.params.pin });
    return res.json({ seller });
}