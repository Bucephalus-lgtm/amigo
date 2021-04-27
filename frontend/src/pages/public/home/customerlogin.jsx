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
import axios from "axios";

import { authenticate } from '../../../authentication/authAPI';

export default function UserLogIn() {
  const history = useHistory();
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const classes = useStyles();

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  }
  const { email, password } = formData;
  const save = (e) => {
    e.preventDefault();

    console.log(email);
    console.log(password);
    const customer = 'customer';

    axios.post('http://localhost:5000/api/signin', { type: customer, email:email, password:password})
      .then(res => {
        console.log(res);
        if (res.status === 200) {
          authenticate(res.data, () => {
            console.log(res.data);
            history.push('/Sarthi');
          });
        }else {
          history.push('/customerlogin');
        }
      }).catch(err => {
        console.log(err);
        history.push('/customerlogin');
      });

  };

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <h1>Sarthi</h1>
        <Typography component="h1" variant="h5">
          LogIn
        </Typography>
        <form className={classes.form} onSubmit={save}>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="Name"
            label="Email "
            name="email"
            value={formData.email}
            onChange={handleChange}
          // onInput={(e) => setName(e.target.value)}
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
            value={formData.password}
            onChange={handleChange}
          // onInput={(e) => setPassword(e.target.value)}
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