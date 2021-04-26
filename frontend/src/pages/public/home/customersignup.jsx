import React, { useState, useEffect } from 'react';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import { Container } from '@material-ui/core';
import { useHistory } from "react-router-dom";

export default function UserSignUp() {
  const history = useHistory();
  const [userName, setName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [password, setPassword] = useState('')

  const classes = useStyles();

  const save = (e) => {
    history.push('/customer');
    e.preventDefault();

    
    console.log(userName);
    console.log(email);
    console.log(phone);
    console.log(password);
    // if (userName !== '' && email !== '' && password!== '') {
        // const formData = new FormData();
        // formData.append('type',"customer");
        // formData.append('enter',"signup");
        // formData.append('name', name);
        // formData.append('email', email);
        // formData.append('phone', phone);
        // formData.append('password', password);

        // console.log(formData)
        
    // }

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
            id="User Name"
            label="User Name "
            name="User Name"
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
            name="password"
            label="Password"
            type="password"
            id="password"
            onInput={(e) => setPassword(e.target.value)}
          />
          
          <Button
            type="Submit"
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