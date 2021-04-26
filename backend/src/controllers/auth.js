const Customer = require('../models/customer');
const Seller = require('../models/seller');
const jwt = require('jsonwebtoken');

exports.signup = async (req, res) => {
    try {
        const { name, email, password, phone, pin, coordinates, type } = req.body;
        if (type === 'customer') {
            const newCustomer = new Customer({ name, email, password, phone, pin, coordinates, type });
            await newCustomer.save();
            return res.json({ customer: newCustomer });
        } else {
            const newSeller = new Seller({ name, email, password, phone, pin, coordinates, type });
            await newSeller.save();
            return res.json({ seller: newSeller });
        }
    } catch (err) {
        console.error(err.message);
        return res.json({ err: err.message });
    }
};

exports.signin = (req, res) => {
    const { email, password, type } = req.body;
    if (type === 'customer') {
        Customer.findOne({ email }, (err, customer) => {
            if (err || !customer) {
                return res.status(400).json({
                    error: 'Customer with that email does not exist. Please signup!'
                });
            }

            const token = jwt.sign({ _id: customer._id }, process.env.JWT_SECRET);
            console.log(token);

            res.cookie('sarthi', token, { expire: new Date() + 9999 });

            const { _id, name, email, type } = customer;
            return res.json({ token, customer: { _id, email, name, type } });
        });
    } else {
        Seller.findOne({ email }, (err, seller) => {
            if (err || !seller) {
                return res.status(400).json({
                    error: 'Seller with that email does not exist. Please signup!'
                });
            }

            const token = jwt.sign({ _id: seller._id }, process.env.JWT_SECRET);
            console.log(token);

            res.cookie('sarthi', token, { expire: new Date() + 9999 });

            const { _id, name, email, type } = seller;
            return res.json({ token, seller: { _id, email, name, type } });
        });
    }
}

exports.signout = function (req, res) {
    res.clearCookie('sarthi');
    return res.json({ msg: 'You have been signed out successfuly!' });
}