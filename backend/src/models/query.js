const mongoose = require('mongoose');

const querySchema = new mongoose.Schema(
    {
        email: {
            type: String
        },
        name: {
            type: String
        },
        type: {
            type: String
        },
        message: {
            type: String
        }
    }
);

module.exports = mongoose.model('query', querySchema);