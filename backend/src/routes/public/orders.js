const express = require("express");
const router = express.Router();

const { customerById } = require("../../controllers/customer");
const { create } = require("../../controllers/order");

router.post("/order/create/:customerId", create);

router.param("customerId", customerById);

module.exports = router;