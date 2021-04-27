const Query = require('../models/query');

exports.send_queries = async (req, res) => {
    try {
        const { email, name, type, message } = req.body;
        const query = new Query({ email, name, type, message });
        await query.save();
        return res.json({ query });
    } catch (err) {
        console.error(err.message);
        return res.json({ err: err.message });
    }
}

exports.receive_queries = async (req, res) => {
    const queries = await Query.find();;
    return res.json({ queries });
}