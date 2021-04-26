import React, {useState, useEffect} from 'react';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import {Container} from '@material-ui/core';
import { useHistory } from "react-router-dom";

export default function ShopSignUp() {
  const history = useHistory();
  const classes = useStyles();
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [pin, setPin] = useState('');
  const [time, setTime] = useState('');
  const [password, setPassword] = useState('');
  const [coordinate, setCoordinate] = useState('');

  

  const save = (e) => {
    history.push('/seller');
    e.preventDefault();

    // if (userName !== '' && email !== '' && password!== '') {
        // const formData = new FormData();
        // formData.append('type',"seller");
        // formData.append('enter',"signup");
        // formData.append('name', name);
        // formData.append('email', email);
        // formData.append('phone', phone);
        // formData.append('password', password);

        // console.log(formData)
        
    // }

    console.log(name);
    console.log(email);
    console.log(phone);
    console.log(pin);
    console.log(time);
    console.log(coordinate);
    console.log(password);
  };
  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <h1>Sarthi</h1>
        <Typography component="h1" variant="h5">
          SignUp
        </Typography>
        <form className={classes.form} onSubmit={save}>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="Seller Name"
            label="Seller Name "
            name="Seller Name"
            onInput={(e) => setName(e.target.value)}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="Email"
            label="Email"
            name="Email"
            onInput={(e) => setEmail(e.target.value)}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="Phone"
            label="Phone"
            type="password"
            id="password"
            onInput={(e) => setPhone(e.target.value)}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="PIN COde"
            label="PIN Code"
            type="password"
            id="password"
            onInput={(e) => setPin(e.target.value)}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="Time"
            label="Time"
            type="password"
            id="password"
            onInput={(e) => setTime(e.target.value)}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="Coordinate"
            label="Coordinate"
            type="password"
            id="password"
            onInput={(e) => setCoordinate(e.target.value)}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="Password"
            label="Password"
            type="password"
            id="password"
            onInput={(e) => setPassword(e.target.value)}
          />
         
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="Primary"
            className={classes.submit}
          >
            Submit
          </Button>
          
          <Grid container>
            <Grid item xs>
              <Link href="#" variant="body2">
                Forgot password?
              </Link>
            </Grid>
          </Grid>
        </form>
      </div>
      <Box mt={8}>
        
      </Box>
    </Container>
  );
}


const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '100%',
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));