
// src/components/InicioSesionComponent.jsx
import React, { useState } from 'react';
import { Button, Form, Container, Row, Col } from 'react-bootstrap';


const InicioSesionComponent = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        firstName: '',
        lastName: '',
        email: '',
        about: '',
    });

    const handleChange = (e) => {
        setFormData({
        ...formData,
        [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Lógica de envío del formulario
        console.log('Formulario enviado');
    };

    return (
        <Container fluid className="vh-100 d-flex justify-content-center align-items-center">
        <Row className="w-100">
            {/* Formulario de inicio de sesión */}
            <Col sm={12} md={6} className="p-4">
            <div className="border p-4 rounded">
                <h3>Inicie sesión en nuestro sitio</h3>
                <p>Introduzca nombre de usuario y contraseña para iniciar sesión:</p>
                <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formUsername">
                    <Form.Control
                    type="text"
                    placeholder="Nombre de usuario..."
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group controlId="formPassword">
                    <Form.Control
                    type="password"
                    placeholder="Contraseña..."
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="w-100">
                    ¡Iniciar sesión!
                </Button>
                </Form>
                <p className="text-center mt-3">...o inicie sesión con:</p>
                <div className="d-flex justify-content-center">
                <Button variant="outline-primary" className="me-2">
                    Facebook
                </Button>
                <Button variant="outline-info" className="me-2">
                    Twitter
                </Button>
                <Button variant="outline-danger">Google Plus</Button>
                </div>
            </div>
            </Col>

            {/* Formulario de registro */}
            <Col sm={12} md={6} className="p-4">
            <div className="border p-4 rounded">
                <h3>Regístrate ahora</h3>
                <p>Complete el formulario a continuación para obtener acceso instantáneo:</p>
                <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formFirstName">
                    <Form.Control
                    type="text"
                    placeholder="Nombre de pila..."
                    name="firstName"
                    value={formData.firstName}
                    onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group controlId="formLastName">
                    <Form.Control
                    type="text"
                    placeholder="Apellido..."
                    name="lastName"
                    value={formData.lastName}
                    onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group controlId="formEmail">
                    <Form.Control
                    type="email"
                    placeholder="Correo electrónico..."
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    />
                </Form.Group>
                <Form.Group controlId="formAbout">
                    <Form.Control
                    as="textarea"
                    rows={3}
                    placeholder="Acerca de ti..."
                    name="about"
                    value={formData.about}
                    onChange={handleChange}
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="w-100">
                    ¡Inscríbeme!
                </Button>
                </Form>
            </div>
            </Col>
        </Row>
        </Container>
    );
};

export default InicioSesionComponent;