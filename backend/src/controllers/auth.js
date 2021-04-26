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

exports.login = async (req, res) => {
    try {
        const { email, password, type } = req.body;
        console.log(req.body);
        if (type === 'customer') {
            const customer = await Customer.signin(type, email, password);
            if (customer) {
                const token = jwt.sign({ _id: customer._id }, process.env.JWT_SECRET);
                res.cookie('sarthi', token, { expire: new Date() + 9999 });
                return res.json({ token, customer });
            } else {
                return res.status(400).json({ error: 'Something went wrong!' });
            }
        } else {
            const seller = await Seller.signin(type, email, password);
            if (seller) {
                const token = jwt.sign({ _id: seller._id }, process.env.JWT_SECRET);
                res.cookie('sarthi', token, { expire: new Date() + 9999 });
                return res.json({ token, seller });
            } else {
                return res.status(400).json({ error: 'Something went wrong!' });
            }
        }
    } catch (err) {
        console.log(err);
        return res.json({ err });
    }
}

exports.logout = function (req, res) {
    res.clearCookie('sarthi');
    return res.json({ msg: 'You have been signed out successfuly!' });
}