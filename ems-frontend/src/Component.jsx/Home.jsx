
import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";

export default function DashboardLayout() {
    const [isOpen, setIsOpen] = useState(true); // Estado para controlar si el panel está abierto
    const [activeSection, setActiveSection] = useState(""); // Para controlar qué sección está activa

    // Datos de ejemplo para los entrenamientos
    const [entrenamientos, setEntrenamientos] = useState([
        { id: 1, nombre: "Entrenamiento 1", descripcion: "Cardio y fuerza" },
        { id: 2, nombre: "Entrenamiento 2", descripcion: "Rutina de pesas" },
        { id: 3, nombre: "Entrenamiento 3", descripcion: "Resistencia y balance" },
    ]);

    const toggleSidebar = () => {
        setIsOpen(!isOpen); // Cambia el estado de la barra lateral
    };

    const handleSectionClick = (section) => {
        setActiveSection(section); // Cambiar la sección activa
    };

    const handleButtonClick = (action) => {
        console.log(`Acción seleccionada: ${action}`);
        // Aquí puedes agregar la lógica de lo que debe hacer cada acción
        if (action === "generarEntrenamiento") {
            const nuevoEntrenamiento = {
                id: entrenamientos.length + 1,
                nombre: `Entrenamiento ${entrenamientos.length + 1}`,
                descripcion: "Nuevo entrenamiento generado",
            };
            setEntrenamientos([...entrenamientos, nuevoEntrenamiento]);
        }
    };

    return (
        <div className="d-flex">
            {/* Sidebar */}
            <div
                className={`bg-dark text-white p-3 ${isOpen ? "d-block" : "d-none"}`}
                style={{ width: "250px", minHeight: "100vh" }}
            >
                <h4>Panel de Navegación</h4>
                <ul className="list-unstyled">
                    {/* Entrenamientos */}
                    <li className="mb-3">
                        <button
                            className="text-white btn btn-link w-100 text-start"
                            onClick={() => handleSectionClick("entrenamientos")}
                        >
                            <i className="bi bi-person-bounding-box me-2"></i> Entrenamientos
                        </button>
                    </li>

                    {/* Rutinas */}
                    <li className="mb-3">
                        <button
                            className="text-white btn btn-link w-100 text-start"
                            onClick={() => handleSectionClick("rutinas")}
                        >
                            <i className="bi bi-house-door me-2"></i> Rutinas
                        </button>
                    </li>

                    {/* Informes */}
                    <li className="mb-3">
                        <button
                            className="text-white btn btn-link w-100 text-start"
                            onClick={() => handleSectionClick("informes")}
                        >
                            <i className="bi bi-bar-chart me-2"></i> Informes
                        </button>
                    </li>
                </ul>
            </div>

            {/* Main Content */}
            <div className="flex-grow-1">
                <nav className="navbar navbar-dark bg-dark">
                    <div className="container-fluid">
                        <button
                            className="btn btn-outline-light"
                            onClick={toggleSidebar}
                        >
                            <i className={`bi ${isOpen ? "bi-x-lg" : "bi-list"}`}></i>
                        </button>
                        <span className="navbar-brand mb-0 h1">Panel de Herramientas</span>
                    </div>
                </nav>

                <div className="container mt-4">
                    <h1>Contenido Principal</h1>
                    {activeSection === "entrenamientos" && (
                        <div className="position-relative">
                            <h2>Entrenamientos</h2>
                            <div className="row">
                                {entrenamientos.map((entrenamiento) => (
                                    <div className="col-md-4 mb-4" key={entrenamiento.id}>
                                        <div className="card">
                                            <div className="card-body">
                                                <h5 className="card-title">{entrenamiento.nombre}</h5>
                                                <p className="card-text">{entrenamiento.descripcion}</p>
                                                {/* Botón para eliminar entrenamiento */}
                                                <button
                                                    className="btn btn-danger btn-sm"
                                                    onClick={() =>
                                                        setEntrenamientos(
                                                            entrenamientos.filter(
                                                                (e) => e.id !== entrenamiento.id
                                                            )
                                                        )
                                                    }
                                                >
                                                    Eliminar
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                ))}
                            </div>

                            {/* Botón fijo para generar nuevo entrenamiento */}
                            <button
                                className="btn btn-primary position-fixed"
                                style={{
                                    bottom: "20px",
                                    left: "20px", // Mover hacia la izquierda
                                    width: "200px", // Reducir ancho
                                    zIndex: 1000,
                                }}
                                onClick={() => handleButtonClick("generarEntrenamiento")}
                            >
                                Generar Entrenamiento
                            </button>
                        </div>
                    )}
                    {activeSection === "" && <p>Selecciona una opción del menú para comenzar.</p>}


                    {activeSection === "rutinas" && (
                        <>
                            <h2>Rutinas</h2>
                            <p>Aquí se mostrarán las rutinas.</p>
                        </>
                    )}

                    {activeSection === "informes" && (
                        <>
                            <h2>Informes</h2>
                            <p>Aquí puedes generar y visualizar los informes.</p>
                        </>
                    )}

                    {activeSection === "" && (
                        <p>Selecciona una opción del menú para comenzar.</p>
                    )}
                </div>
            </div>
        </div>
    );
}

