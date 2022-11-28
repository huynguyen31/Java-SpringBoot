import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Add from './View/Add';
import Home from './View/Home';
import ProductDetail from './View/ProductDetail';
function App() {


  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Home></Home>}></Route>
        </Routes>

        <Routes>
          <Route path="/product/:id" element={<ProductDetail/>}></Route>
        </Routes>

        <Routes>
          <Route path="/save" element={<Add/>}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
