
import './App.css'
import FooterComponent from './Component.jsx/FooterComponent'
import HeaderComponent from './Component.jsx/HeaderComponent'
import { ListSugerencia } from './Component.jsx/ListSugerencia'
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import SugerenciaComponent from './Component.jsx/SugerenciaComponent'
import InicioSesionComponent from './Component.jsx/InicioSesionComponent'
import Home from './Component.jsx/Home'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            {/* // http://localhost:3030 */}
            <Route path='/' element = {<ListSugerencia/>}></Route>
            {/* // http://localhost:3030/Sugerencias */}
            <Route path='/Sugerencia' element = {<ListSugerencia/>}></Route>
            {/* // http://localhost:3030/add-sugerencia */}
            <Route path='/add-sugerencia' element = {<SugerenciaComponent/>}></Route>
            {/* // http://localhost:3030/InicioSesion */}
            <Route path='/InicioSesion' element = {<InicioSesionComponent/>}></Route>
            {/* // http://localhost:3030/Home */}
            <Route path='/Home' element = {<Home/>}></Route>
          </Routes>
        {/* <FooterComponent/> */}
      </BrowserRouter>
    </>
  )
}

export default App
