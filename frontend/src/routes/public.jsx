import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import HomePage from '../pages/public/HomePage/homepage';
import UserLogIn from '../pages/public/home/customerlogin';
import AdminDashboard from '../components/admin/dashboard/dashboard';
import QueryView from '../components/admin/dashboard/queryView';
const PublicRoutes = () => {
    return (
        <BrowserRouter>
            <Route exact path='/'>
                <HomePage />
            </Route>
            <Route exact path='/customerlogin'>
                <UserLogIn/>
            </Route>
            <Route exact path='/Sarthi'>
                <AdminDashboard/>
            </Route>
            <Route exact path='/queryView'>
                <QueryView/>
            </Route>
        </BrowserRouter>
    )
}

export default PublicRoutes
