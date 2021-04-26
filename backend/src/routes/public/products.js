const express = require("express");
const router = express.Router();
const upload = require('../../utility/multer');
const { create_product, get_all_products, get_product_by_id } = require("../../controllers/products");

router.post('/upload', upload.single('image'), create_product);

router.get('/get/all/products', get_all_products);
router.post('/product', get_product_by_id);

module.exports = router;