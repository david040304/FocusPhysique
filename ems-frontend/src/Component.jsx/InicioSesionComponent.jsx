import React, { useState } from 'react';
import './InicioSesion.css'
import { Button, Form, Container, Row, Col } from 'react-bootstrap';

const InicioSesionComponent = () => {
    const [formData, setFormData] = useState({
        P_Nombre: '',
        S_Nombre: '',
        P_Apellido: '',
        S_Apellido: '',
        Telefono: '',
        Genero: '',
        Altura_Inicio: '',
        Peso_Inicio: '',
        username: '',
        password: '',
    });

    const [errors, setErrors] = useState({
        P_Nombre: '',
        P_Apellido: '',
        Telefono: '',
        Genero: '',
        Altura_Inicio: '',
        Peso_Inicio: '',
        username: '',
        password: ''
    });

    const validateField = (name, value) => {
        switch (name) {
            case 'P_Nombre':
                return value.trim() === '' 
                    ? 'El primer nombre es obligatorio' 
                    : '';
            case 'P_Apellido':
                return value.trim() === '' 
                    ? 'El primer apellido es obligatorio' 
                    : '';
            case 'Telefono':
                // Validación para que solo permita números y tenga 10 dígitos
                const phoneRegex = /^\d{10}$/;
                return value.trim() === ''
                    ? 'El teléfono es obligatorio'
                    : !phoneRegex.test(value)
                    ? 'El teléfono debe tener 10 dígitos numéricos'
                    : '';
            case 'Genero':
                return value === '' 
                    ? 'Debe seleccionar un género' 
                    : '';
            case 'Altura_Inicio':
                return value === '' 
                    ? 'La altura es obligatoria' 
                    : isNaN(value) || value <= 0
                    ? 'Altura debe ser un número positivo'
                    : '';
            case 'Peso_Inicio':
                return value === '' 
                    ? 'El peso es obligatorio' 
                    : isNaN(value) || value <= 0
                    ? 'Peso debe ser un número positivo'
                    : '';
            case 'username':
                return value.trim() === '' 
                    ? 'El nombre de usuario es obligatorio' 
                    : value.length < 4
                    ? 'El nombre de usuario debe tener al menos 4 caracteres'
                    : '';
            case 'password':
                return value.trim() === '' 
                    ? 'La contraseña es obligatoria' 
                    : value.length < 6
                    ? 'La contraseña debe tener al menos 6 caracteres'
                    : '';
            default:
                return '';
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        
        // Validación específica para teléfono (solo números)
        if (name === 'Telefono') {
            const numericValue = value.replace(/\D/g, '');
            setFormData(prevState => ({
                ...prevState,
                [name]: numericValue
            }));
        } else {
            setFormData(prevState => ({
                ...prevState,
                [name]: value
            }));
        }

        // Validación de campos
        const errorMessage = validateField(name, value);
        setErrors(prevErrors => ({
            ...prevErrors,
            [name]: errorMessage
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        
        // Validar todos los campos obligatorios
        const newErrors = {};
        const requiredFields = [
            'P_Nombre', 'P_Apellido', 'Telefono', 'Genero', 
            'Altura_Inicio', 'Peso_Inicio', 'username', 'password'
        ];

        requiredFields.forEach(field => {
            const errorMessage = validateField(field, formData[field]);
            if (errorMessage) {
                newErrors[field] = errorMessage;
            }
        });

        // Si hay errores, no continuar
        if (Object.keys(newErrors).length > 0) {
            setErrors(prevErrors => ({
                ...prevErrors,
                ...newErrors
            }));
            return;
        }

        // Si todo está válido, crear objeto de usuario
        const usuario = {
            P_Nombre: formData.P_Nombre,
            S_Nombre: formData.S_Nombre,
            P_Apellido: formData.P_Apellido,
            S_Apellido: formData.S_Apellido,
            Telefono: formData.Telefono,
            Genero: formData.Genero,
            Altura_Inicio: formData.Altura_Inicio,
            Peso_Inicio: formData.Peso_Inicio,
            cuenta: {
                usuario: formData.username,
                contraseña: formData.password,
            }
        };
        console.log('Formulario enviado', usuario);
    };

    

    return (
        <Container fluid className="vh-100 d-flex justify-content-center align-items-center" id='Inicio'>
            <Row className="w-100">
                {/* Formulario de inicio de sesión */}
                <Col sm={12} md={6} className="p-4">
                    <div className="border p-4 rounded" id="login-form">
                        <h3>Inicie sesión en nuestro sitio</h3>
                        <p>Introduzca nombre de usuario y contraseña para iniciar sesión:</p>
                        <Form onSubmit={handleSubmit} id="login-form-submit">
                            <Form.Group controlId="formUsername">
                                <Form.Control
                                    className={`custom-margin ${errors.username ? 'is-invalid' : ''}`}
                                    type="text"
                                    placeholder="Nombre de usuario..."
                                    name="username"
                                    value={formData.username}
                                    onChange={handleChange}
                                />
                                {errors.username && <div className="invalid-feedback">{errors.username}</div>}
                            </Form.Group>
                            <Form.Group controlId="formPassword">
                                <Form.Control
                                    className={`custom-margin ${errors.password ? 'is-invalid' : ''}`}
                                    type="password"
                                    placeholder="Contraseña..."
                                    name="password"
                                    value={formData.password}
                                    onChange={handleChange}
                                    
                                />
                                {errors.password && <div className="invalid-feedback">{errors.password}</div>}
                            </Form.Group>
                            <button type="submit" className="w-100" id="login-submit-button">
                                ¡Iniciar sesión!
                            </button>
                        </Form>
                    </div>
                </Col>

                {/* Formulario de registro */}
                <Col sm={12} md={6} className="p-4" >
                    <div className="border p-4 rounded" id="register-form">
                        <h3>Regístrate ahora</h3>
                        <p>Complete el formulario a continuación para obtener acceso instantáneo:</p>
                        <Form onSubmit={handleSubmit} id="register-form-submit">
                            <Form.Group controlId="formPNombre">
                                <Form.Control
                                    className={`custom-margin ${errors.P_Nombre ? 'is-invalid' : ''}`}
                                    type="text"
                                    placeholder="Primer nombre..."
                                    name="P_Nombre"
                                    value={formData.P_Nombre}
                                    onChange={handleChange}
                                />
                                {errors.P_Nombre && <div className="invalid-feedback">{errors.P_Nombre}</div>}
                            </Form.Group>
                            <Form.Group controlId="formSNombre">
                                <Form.Control
                                    className="custom-margin"
                                    type="text"
                                    placeholder="Segundo nombre (opcional)..."
                                    name="S_Nombre"
                                    value={formData.S_Nombre}
                                    onChange={handleChange}
                                />
                            </Form.Group>
                            <Form.Group controlId="formPApellido">
                                <Form.Control
                                    className={`custom-margin ${errors.P_Apellido ? 'is-invalid' : ''}`}
                                    type="text"
                                    placeholder="Primer apellido..."
                                    name="P_Apellido"
                                    value={formData.P_Apellido}
                                    onChange={handleChange}
                                />
                                {errors.P_Apellido && <div className="invalid-feedback">{errors.P_Apellido}</div>}
                            </Form.Group>
                            <Form.Group controlId="formSApellido">
                                <Form.Control
                                    className="custom-margin"
                                    type="text"
                                    placeholder="Segundo apellido (opcional)..."
                                    name="S_Apellido"
                                    value={formData.S_Apellido}
                                    onChange={handleChange}
                                />
                            </Form.Group>
                            <Form.Group controlId="formTelefono">
                                <Form.Control
                                    className={`custom-margin ${errors.Telefono ? 'is-invalid' : ''}`}
                                    type="tel"
                                    placeholder="Teléfono (10 dígitos)..."
                                    name="Telefono"
                                    value={formData.Telefono}
                                    onChange={handleChange}
                                />
                                {errors.Telefono && <div className="invalid-feedback">{errors.Telefono}</div>}
                            </Form.Group>
                            <Form.Group controlId="formGenero">
                                <Form.Control
                                    className={`custom-margin ${errors.Genero ? 'is-invalid' : ''}`}
                                    as="select"
                                    name="Genero"
                                    value={formData.Genero}
                                    onChange={handleChange}
                                >
                                    <option value="">Seleccionar género</option>
                                    <option value="M">Masculino</option>
                                    <option value="F">Femenino</option>
                                </Form.Control>
                                {errors.Genero && <div className="invalid-feedback">{errors.Genero}</div>}
                            </Form.Group>
                            <Form.Group controlId="formAltura">
                                <Form.Control
                                    className={`custom-margin ${errors.Altura_Inicio ? 'is-invalid' : ''}`}
                                    type="number"
                                    placeholder="Altura en cm"
                                    name="Altura_Inicio"
                                    value={formData.Altura_Inicio}
                                    onChange={handleChange}
                                    min="0"
                                />
                                {errors.Altura_Inicio && <div className="invalid-feedback">{errors.Altura_Inicio}</div>}
                            </Form.Group>
                            <Form.Group controlId="formPeso">
                                <Form.Control
                                    className={`custom-margin ${errors.Peso_Inicio ? 'is-invalid' : ''}`}
                                    type="number"
                                    placeholder="Peso en kg"
                                    name="Peso_Inicio"
                                    value={formData.Peso_Inicio}
                                    onChange={handleChange}
                                    min="0"
                                />
                                {errors.Peso_Inicio && <div className="invalid-feedback">{errors.Peso_Inicio}</div>}
                            </Form.Group>
                        </Form>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};

export default InicioSesionComponent;