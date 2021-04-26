import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';
import { Container } from '@material-ui/core';
// import logo from './logo.png'
const useStyles = makeStyles({
  root: {
    maxWidth: 345,
  },
  media: {
    height: 140,
  },
});

export default function CustomerProduct() {
  const classes = useStyles();

  return (
    <>
      <Container style={{marginTop:'20px'}}>
        <Grid item lg={12} style={{ display: 'flex',justifyContent:'center' }}>
          <Grid item lg={6}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  // image= {require ("./logo.png")}
                  image="https://ichef.bbci.co.uk/news/976/cpsprodpb/8A13/production/_116574353_gettyimages-1229868118.jpg"
                  title="Shop Name"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    Shop Name
                </Typography>
                  <Typography variant="body2" color="textSecondary" component="p">
                    Address
                </Typography>
                </CardContent>
              </CardActionArea>
            </Card>
          </Grid>
        </Grid>
      </Container>

      <Container style={{marginTop:'20px'}}>
        <Grid item lg={12} style={{ display: 'flex' }}>
          <Grid item lg={6}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  // image= {require ("./logo.png")}
                  image="https://res.cloudinary.com/grohealth/image/upload/$wpsize_!_cld_full!,w_2100,h_1427,c_scale/v1588088840/iStock-467652436.jpg"
                  title="Contemplative Reptile"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    Product Name
                </Typography>
                </CardContent>
              </CardActionArea>
              <CardActions>
                <Button size="small" color="primary">
                  Add to Cart
              </Button>
              </CardActions>
            </Card>
          </Grid>
          <Grid item lg={6}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  // image= {require ("./logo.png")}
                  image="https://res.cloudinary.com/grohealth/image/upload/$wpsize_!_cld_full!,w_2100,h_1427,c_scale/v1588088840/iStock-467652436.jpg"
                  title="Contemplative Reptile"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    Product Name
                </Typography>
                </CardContent>
              </CardActionArea>
              <CardActions>
                <Button size="small" color="primary">
                  Add to Cart
              </Button>
              </CardActions>
            </Card>
          </Grid>
        </Grid>

        <Grid item lg={12} style={{ display: 'flex' }}>
          <Grid item lg={6}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  // image= {require ("./logo.png")}
                  image="https://res.cloudinary.com/grohealth/image/upload/$wpsize_!_cld_full!,w_2100,h_1427,c_scale/v1588088840/iStock-467652436.jpg"
                  title="Contemplative Reptile"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    Product Name
          </Typography>
                  <Typography variant="body2" color="textSecondary" component="p">
                    Product Names are a widespread group of squamate reptiles, with over 6,000 species, ranging
                    across all continents except Antarctica
          </Typography>
                </CardContent>
              </CardActionArea>
              <CardActions>
                <Button size="small" color="primary">
                  Add to Cart
        </Button>
              </CardActions>
            </Card>
          </Grid>
          <Grid item lg={6}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  // image= {require ("./logo.png")}
                  image="https://res.cloudinary.com/grohealth/image/upload/$wpsize_!_cld_full!,w_2100,h_1427,c_scale/v1588088840/iStock-467652436.jpg"
                  title="Contemplative Reptile"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    Product Name
          </Typography>
                  <Typography variant="body2" color="textSecondary" component="p">
                    Product Names are a widespread group of squamate reptiles, with over 6,000 species, ranging
                    across all continents except Antarctica
          </Typography>
                </CardContent>
              </CardActionArea>
              <CardActions>
                <Button size="small" color="primary">
                  Add to Cart
        </Button>
              </CardActions>
            </Card>
          </Grid>
        </Grid>
        <Grid item lg={12} style={{ display: 'flex' }}>
          <Grid item lg={6}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  // image= {require ("./logo.png")}
                  image="https://res.cloudinary.com/grohealth/image/upload/$wpsize_!_cld_full!,w_2100,h_1427,c_scale/v1588088840/iStock-467652436.jpg"
                  title="Contemplative Reptile"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    Product Name
          </Typography>
                </CardContent>
              </CardActionArea>
              <CardActions>
                <Button size="small" color="primary">
                  Add to Cart
        </Button>
              </CardActions>
            </Card>
          </Grid>
          <Grid item lg={6}>
            <Card className={classes.root}>
              <CardActionArea>
                <CardMedia
                  className={classes.media}
                  // image= {require ("./logo.png")}
                  image="https://res.cloudinary.com/grohealth/image/upload/$wpsize_!_cld_full!,w_2100,h_1427,c_scale/v1588088840/iStock-467652436.jpg"
                  title="Contemplative Reptile"
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    Product Name
          </Typography>
                </CardContent>
              </CardActionArea>
              <CardActions>
                <Button size="small" color="primary">
                  Add to Cart
        </Button>
              </CardActions>
            </Card>
          </Grid>
        </Grid>
      </Container>
    </>
  );
}
