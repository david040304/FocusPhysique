import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function MainPage() {
    const [isOpen, setIsOpen] = useState(false);

    const toggleMenu = () => setIsOpen(!isOpen);

    return (
        <div className="main-page">
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <a className="navbar-brand" href="#">Sistema de Entrenamientos</a>
        </nav>

        <div className="sidebar">
            <button onClick={toggleMenu} className="btn btn-primary">
            Menú
            </button>
            {isOpen && (
            <div className="dropdown-menu">
                <h5>Sugerencias</h5>
                <Link to="/sugerencias" className="dropdown-item">Ver sugerencias</Link>
                <Link to="/add-sugerencia" className="dropdown-item">Agregar sugerencia</Link>
                
                <h5>Entrenamientos</h5>
                <Link to="/entrenamientos" className="dropdown-item">Ver entrenamientos</Link>
                <Link to="/add-entrenamiento" className="dropdown-item">Agregar entrenamiento</Link>
            </div>
            )}
        </div>

        <div className="content">
            <h3>Bienvenido al Sistema de Entrenamientos</h3>
            <p>Elige una opción del menú para empezar.</p>
        </div>
        </div>
    );
}

export default MainPage;
