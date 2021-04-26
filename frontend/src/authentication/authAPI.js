export const authenticate = (data, next) => {
    if (typeof window !== 'undefined') {
        console.log(data);
        localStorage.setItem('SARTHI', JSON.stringify(data));
        next();
    }
};

export const isAuthenticated = () => {
    if (typeof window == 'undefined') {
        return false;
    }
    if (localStorage.getItem('SARTHI')) {
        return JSON.parse(localStorage.getItem('SARTHI'));
    } else {
        return false;
    }
};

export const signout = next => {
    if (typeof window !== 'undefined') {
        localStorage.removeItem('SARTHI');
        next();
        return fetch(`http://localhost:5000/api/signout`, {
            method: 'GET'
        })
            .then(response => {
                console.log('signout', response);
            })
            .catch(err => console.log(err));
    }
};