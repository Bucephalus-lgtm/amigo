const mongoose = require('mongoose');
const bcrypt = require('bcrypt');

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
        coordinates: {
            type: String
        },
        type: String,
    },
    { timestamps: true }
);

sellerSchema.pre('save', async function (next) {
    const salt = await bcrypt.genSalt();
    this.password = await bcrypt.hash(this.password, salt);
    next();
});

sellerSchema.statics.signin = async function (type, email, password) {
    const seller = await this.findOne({ email });
    if (seller) {
        const passwordCheck = await bcrypt.compare(password, seller.password);
        console.log(password, seller.password);
        if (passwordCheck) {
            return seller;
        } else {
            console.log('Passwords did not match!');
        }
    } else {
        console.log('This email is yet to sign up!');
    }
}

module.exports = mongoose.model('seller', sellerSchema);