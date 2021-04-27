const express = require("express");
const { get_all_sellers, seller_by_id, receive_orders } = require("../../controllers/seller");
const router = express.Router();

router.get("/get/all/sellers", get_all_sellers);

router.get("/seller/:id", seller_by_id);

router.get('/receive/orders/:id', receive_orders);

module.exports = router;