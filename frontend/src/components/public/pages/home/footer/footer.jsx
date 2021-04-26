import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Container from '@material-ui/core/Container';

import Image1 from './1.PNG'
import Image2 from './2.PNG'
export default function Footer() {
  const classes = useStyles();
  return (
    <div className={classes.root} id="contact-us">
      <Container maxWidth='lg'>
        <Grid container direction='row' alignItems='center'>
          <Grid item md={10} xs={12}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <Grid container justify='flex-start'>
                  {/* <Grid item>
                    <img
                      src={logo}
                      alt="logo"
                      style={{ width: 'auto', height: '50px' }}
                    />
                  </Grid> */}
                </Grid>
              </Grid>
              <Grid item xs={12}>
                <Grid container justify='flex-start' spacing={3}>
                  <Grid item>
                    <p className={classes.text}>Download Now</p>
                  </Grid>
                  <Grid item>
                    <p className={classes.text}>License</p>
                  </Grid>
                </Grid>
              </Grid>
              <Grid item xs={12}>
                <Grid container>
                  <Grid item>
                    <p className={classes.text}>About</p>
                  </Grid>
                  <Grid item>
                    <p className={classes.text}>Features</p>
                  </Grid>
                  <Grid item>
                    <p className={classes.text}>Pricing</p>
                  </Grid>
                  <Grid item>
                    <p className={classes.text}>Careers</p>
                  </Grid>
                  <Grid item>
                    <p className={classes.text}>Help</p>
                  </Grid>
                  <Grid item>
                    <p className={classes.text}>Privacy Policy</p>
                  </Grid>
                </Grid>
              </Grid>

            </Grid>
          </Grid>
          <Grid item md={2} xs={12}>
            <Grid container justify="center"
              alignItems="center" spacing={2}>
              <Grid item xs={12}>
                <Grid container justify='flex-start'>
                  <Grid item>
                    <p className={classes.AppInfo}>Get the App</p>
                  </Grid>
                </Grid>
              </Grid>
              <Grid item xs={12}>
                <Grid container justify='flex-start'>
                  <img className={classes.image}
                    src={Image1}
                    alt="logo"
                  />
                </Grid>
              </Grid>
              <Grid item xs={12}>
                <Grid container justify='flex-start'>
                  <img className={classes.image}
                    src={Image2}
                    alt="logo"
                  />
                </Grid>
              </Grid>

            </Grid>
          </Grid>
          <Grid container>
            <Grid item xs={12}>
              <p className={classes.copyRight}>&copy;
                  <script>document.write(new Date().getFullYear());</script> Landify UI Kit. All right reserved
                </p>
            </Grid>
          </Grid>

        </Grid>
      </Container>
    </div>
  );
}

const useStyles = makeStyles({
  root: {
    backgroundColor: 'black',
    color: 'black',
    padding: '40px 20px',
  },
  text: {
    fontFamily: 'Segoe UI',
    margin: '3px 5px',
    fontSize: '17px',
    color: 'white',
    fontWeight: '500'
  },
  copyRight: {
    color: '#707070',
    fontFamily: 'Segoe UI',
    margin: '3px 0px',
    fontSize: '17px',
    fontWeight: '500'
  },
  AppInfo: {
    color: '#707070',
    fontFamily: 'Segoe UI',
    margin: '3px 0px',
    fontSize: '17px',
    fontWeight: '500'
  },
  image: {
    height: '80%',
    width: 'auto'
  }
});