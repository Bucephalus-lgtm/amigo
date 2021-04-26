import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import HomePage from '../pages/public/home/home';

const PublicRoutes = () => {
    return (
        <BrowserRouter>
            <Route exact path='/'>
                <HomePage/>
            </Route>
        </BrowserRouter>
    )
}

export default PublicRoutes;