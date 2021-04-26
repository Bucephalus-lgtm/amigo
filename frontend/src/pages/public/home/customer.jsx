import React from 'react';
import HomeNavbar from '../../../components/public/pages/home/navbar/navbar';
import { makeStyles } from '@material-ui/core/styles';
import CutomerProduct from '../../../components/public/pages/home/customer/products/cutomerProd';
import Footer from '../../../components/public/pages/home/footer/footer';
const useStyles = makeStyles({
    root: {
        background: 'linear-gradient(61.5deg, #172238 1.39%, #2F4D6F 98.43%)',
        backgroundColor: '#172238',
    },
})

export default function CustomerPage(){

    const classes = useStyles();
    return (
        <>
        <div >
            <HomeNavbar/>
            <CutomerProduct/>
            <Footer/>
        </div>
        </>
    )

}
