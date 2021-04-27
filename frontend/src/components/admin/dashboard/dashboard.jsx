import React from 'react';
import { Link } from 'react-router-dom';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import Divider from '@material-ui/core/Divider';
import Button from '@material-ui/core/Button';
import AppBar from '@material-ui/core/AppBar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { useHistory } from "react-router-dom";

export default function AdminDashboard() {
  const history = useHistory();

  const onHandleLogout = (e) => {
    e.preventDefault();
    // AuthenticationService.logout().then(() => {
      history.push('/customerlogin');
      window.location.reload();
    // })
  }

  const classes = useStyles();

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <Typography
            // variant="h6"
            // noWrap
            // component={Link}
            to="/admin/dashboard"
            style={{color:"white",fontSize:'30px',fontWeight:"400"}}
          >
            Admin Page Sarthi
          </Typography>
          <div className={classes.logout}>
            <Button variant="contained" color="secondary" onClick={onHandleLogout}>Log out</Button>
          </div>
        </Toolbar>
      </AppBar>
      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
      >
        <Toolbar />
        <div className={classes.drawerContainer}>
          <List>
            <ListItem button component={Link} to='/queryView'>
              <ListItemText primary='Queries'></ListItemText>
            </ListItem>
            <Divider />
            <ListItem button component={Link} to='/queryView'>
              <ListItemText primary='Answered'></ListItemText>
            </ListItem>
            <Divider />
          </List>
        </div>
      </Drawer>
    </div>
  );
}

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    color: '#ffff',
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  drawerContainer: {
    overflow: 'auto',
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
  logout: {
    display: 'flex',
    marginLeft: 'auto',
  }
}));
