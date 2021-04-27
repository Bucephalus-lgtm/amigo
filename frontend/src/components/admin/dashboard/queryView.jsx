import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import Button from "@material-ui/core/Button";
import EditRoundedIcon from "@material-ui/icons/EditRounded";
import AdminDashboard from "./dashboard";

import AddIcon from "@material-ui/icons/Add";
import Fab from "@material-ui/core/Fab";

const useStyles = makeStyles((theme) => ({
  container: {
    marginLeft: "260px",
    marginTop: "80px",
  },
  card: {
    width: "250px",
  },
  image: {
    width: "70%",
  },
}));

const QueryView = () => {
  const classes = useStyles();

  const controller = new AbortController();

  const [data, setData] = useState([]);

  useEffect(() => {
    fetch("https://sarthiapi.herokuapp.com/api/receive-queries")
      .then((response) => response.json())
      .then((data) => setData(data.queries))
      .catch((err) => window.alert("API Error", err))
  }, []);

  console.log(data);


  return (
    <>
      <AdminDashboard />
      <div className={classes.container}>
        <Container maxWidth="lg">
          <Grid container justify="space-between" alignItems="center">
            <Grid item>
              <h1>Queries</h1>
            </Grid>
          </Grid>

          <Grid container spacing={3} justify="space-evenly">
            {data.map(data => (
                <Grid item className={classes.card}>
              <Paper style={{ padding: "10px" }}>
                <Grid container direction="column" justify="center" spacing={1}>
                  <Grid item xs={12}>
                    <Grid container justify="center">
                      <b>{data.name}</b>
                      <b>{data.email}</b>
                      
                      <b>{data.type}</b>
                    </Grid>
                    <hr></hr>
                  </Grid>
                  <Grid item xs={12}>
                    <Grid container justify="center">
                    <b>{data.message}</b>
                    </Grid>
                  </Grid>
                  <Grid item xs={12}>
                    <Grid container justify="space-evenly">
                      <Grid item xs={6}>
                        <Button
                          variant="contained"
                          color="primary"
                          size="small"
                          endIcon={<EditRoundedIcon />}
                        >
                          Resolve
                        </Button>
                      </Grid>
                    </Grid>
                  </Grid>
                </Grid>
              </Paper>
            </Grid>
              ))}
            
            
          </Grid>
        </Container>
      </div>
    </>
  );
};

export default QueryView;
