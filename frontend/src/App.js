import { BrowserRouter, Switch, Route } from 'react-router-dom';
import PublicRoutes from './routes/public';

function App() {
  return (
    <BrowserRouter>
    <Switch>
      {/* Public Routes */}
      <Route path='/'>
        <PublicRoutes />
      </Route>

    </Switch>
  </BrowserRouter>
  );
}

export default App;