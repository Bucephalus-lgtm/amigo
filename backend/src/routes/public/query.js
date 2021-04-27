const express = require("express");
const { send_queries } = require("../../controllers/query");
const router = express.Router();

router.post("/send-queries", send_queries);

module.exports = router;