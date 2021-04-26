import React, {useEffect, useState} from 'react';
import HomeNavbar from '../../../components/public/pages/home/navbar/navbar';
import { makeStyles } from '@material-ui/core/styles';
import Image from '../../../components/public/pages/home/image/image'
import Product from '../../../components/public/pages/home/product/product'
import Footer from '../../../components/public/pages/home/footer/footer';
import axios from 'axios';

const useStyles = makeStyles({
    root: {
        background: 'linear-gradient(61.5deg, #172238 1.39%, #2F4D6F 98.43%)',
        backgroundColor: '#172238',
    },
})

export default function SellerPage(){
    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get('https://sarthiapi.herokuapp.com/api/get/all/products')
        .then(res => {
            console.log(res.data);
            setProducts(res.data.product);
        })
    }, []);

    const classes = useStyles();
    return (
        <>
        <div >
            <HomeNavbar/>
            <Image/>
            <Product products={products} />
            <Footer/>
        </div>
        </>
    )

}
