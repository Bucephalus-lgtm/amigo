const express = require("express");
const { sellers_by_pin } = require("../../controllers/customer");
const router = express.Router();

router.get("/sellers/:pin", sellers_by_pin);

module.exports = router;