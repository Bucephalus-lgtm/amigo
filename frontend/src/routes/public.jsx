import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import SellerPage from '../pages/public/home/home';
import CustomerPage from '../pages/public/home/customer';
import UserSignUp from '../pages/public/home/customersignup';
import ShopSignUp from '../pages/public/home/shopsignup';
import HomePage from '../pages/public/HomePage/homepage';
import UserLogIn from '../pages/public/home/customerlogin';
import ShopLogIn from '../pages/public/home/shoplogin';
const PublicRoutes = () => {
    return (
        <BrowserRouter>
            <Route exact path='/'>
                <HomePage />
            </Route>
            <Route exact path='/customer'>
                <CustomerPage />
            </Route>
            <Route exact path='/seller'>
                <SellerPage />
            </Route>
            <Route exact path='/customersignUp'>
                <UserSignUp/>
            </Route>
            <Route exact path='/sellersignup'>
                <ShopSignUp/>
            </Route>
            <Route exact path='/sellerlogin'>
                <ShopLogIn/>
            </Route>
            <Route exact path='/customerlogin'>
                <UserLogIn/>
            </Route>
        </BrowserRouter>
    )
}

export default PublicRoutes
