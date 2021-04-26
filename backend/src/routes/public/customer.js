const express = require("express");
const Seller = require("../../models/seller");
const router = express.Router();

router.post("/signup", async (req, res) => {
    const sellers = await Seller.find();
    return res.json({ sellers });
});

module.exports = router;