const mongoose = require('mongoose');
const bcrypt = require('bcrypt');

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

customerSchema.pre('save', async function (next) {
    const salt = await bcrypt.genSalt();
    this.password = await bcrypt.hash(this.password, salt);
    next();
});

customerSchema.statics.signin = async function (type, email, password) {
    const customer = await this.findOne({ email });
    if (customer) {
        const passwordCheck = await bcrypt.compare(password, customer.password);
        console.log(password, customer.password);
        if (passwordCheck) {
            return customer;
        } else {
            console.log('Passwords did not match!');
        }
    } else {
        console.log('This email is yet to sign up!');
    }
}

module.exports = mongoose.model('customer', customerSchema);