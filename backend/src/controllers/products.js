const fs = require('fs');

const cloudinary = require('../utility/cloudinary');
const Product = require('../models/product');

exports.create_product = async (req, res) => {
    const { name, category, price, seller } = req.body;

    const uploader = async (path) => await cloudinary.uploads(path, 'bhargab_files');

    const file = req.file;
    const { path } = file;
    const newPath = await uploader(path);
    console.log(newPath);
    fs.unlinkSync(path);
    const product = new Product({
        name,
        category,
        price,
        image: newPath.url,
        seller
    });

    console.log(product);

    await product.save();

    return res.status(200).json({
        message: 'Images uploaded successfully',
        data: newPath,
        product
    });
}

exports.get_all_products = async (req, res) => {
    const product = await Product.find();
    return res.json({ product });
}

exports.get_product_by_id = async (req, res) => {
    const product = await Product.findById(req.body.id);
    return res.json({ product });
}