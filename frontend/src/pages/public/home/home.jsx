import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
const useStyles = makeStyles({
    root: {
        background: 'linear-gradient(61.5deg, #172238 1.39%, #2F4D6F 98.43%)',
        backgroundColor: '#172238',
    },
})

export default function HomePage(){

    const classes = useStyles();
    return (
        <>
        <div >
            This is Home page
        </div>
        </>
    )

}