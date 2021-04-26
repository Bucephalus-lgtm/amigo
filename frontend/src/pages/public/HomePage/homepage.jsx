import React, { useState, useEffect } from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import { Container } from '@material-ui/core';
import logo from './logo.png';
import CssBaseline from '@material-ui/core/CssBaseline';

const useStyles = makeStyles((theme) => ({
    heading: {
        fontFamily: 'Poppins',
        fontSize: '32px',
        fontWeight: '500',
        color: 'white'

    },
    text: {
        fontFamily: 'Poppins',
        fontSize: '22px',
        fontWeight: '300',
        paddingBottom: '40px',
        color: 'white'

    },
    subHeading: {
        fontFamily: 'Poppins',
        fontSize: '17px',
        fontWeight: '900',
        margin: '5px 0',
        color: '#4F4F4F'
    },
    subText: {
        fontFamily: 'Poppins',
        fontSize: '14px',
        fontWeight: '300',
        color: '#949494'
    },
    submit: {
        margin: theme.spacing(3, 0, 0),
        width: '250px',
        display: 'block'
    },

}));

export default function HomePage() {
    const classes = useStyles();
    return (
        <>
        <CssBaseline/>
            <Grid container style={{marginRight: '10px', backgroundColor:'#343b3f'}} justify='center' alignItems='center'>
                <Grid container style={{justifyContent:'center',marginTop:'40px'}} xs={12}>
                    
                    <Grid item>
                    <img src={logo}
                        style={{ width: '150px', height: 'auto' }}>

                    </img>
                    </Grid>
                    <br></br>
                    <Grid item><h1 style={{color:'white'}}>Sarthi</h1></Grid>
                </Grid>
                    <Container style={{display:'flex',marginTop:'50px',justifyContent:'center'}}>
                    <Grid item xs={6} md={6} >
                        <div className={classes.paper}>
                            <Typography component="h1" variant="h5" style={{color:'white'}}>
                                Already Registered?
                            </Typography>
                            <Link href="/customerlogin">
                                <Button
                                    variant="contained"
                                    color="Primary"
                                    className={classes.submit}
                                >
                                    LogIn As Customer
                            </Button>
                            </Link>
                            <Link href="/sellerlogin">
                                <Button
                                    variant="contained"
                                    color="Primary"
                                    className={classes.submit}
                                >
                                    LogIn As Seller
                            </Button>
                            </Link>
                            <Typography component="h1" variant="h5" style={{color:'white',marginTop:'20px'}}>
                                SignUp
                            </Typography>
                            <Link href="/customersignup">
                                <Button
                                    variant="contained"
                                    color="Primary"
                                    className={classes.submit}
                                >
                                    Customer
                            </Button>
                            </Link>
                            <Link href="/sellersignup">
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="contained"
                                    color="Primary"
                                    className={classes.submit}
                                >
                                    Seller
                            </Button>
                            </Link>
                        </div>
                    </Grid>
                    <Grid item xs={6} md={6}>
                        <Grid container justify='center' alignItems='center'>
                            <Grid item xs={8}>
                                <Grid container>
                                    <Grid item xs={12}>
                                        <h3 className={classes.heading}>About Sarthi!</h3>
                                    </Grid>
                                    <Grid item xs={12}>
                                        <p className={classes.text}>Sarthi, a helping hand making a safe gathering free trade between sellers and its customers.
                                        Being a customer, you search shops nearby, select items in your cart and place orders.
                                        Being a seller, you prepare the order beforehand and ping the speacific customer.
                                        Customer will come, take order and pay without spending time in line. in this way Sarthi slashes
                                        gathering at shops.</p>
                                    </Grid>
                                </Grid>
                            </Grid>

                        </Grid>
                    </Grid>
                    </Container>
            </Grid>
        </>
    );
};