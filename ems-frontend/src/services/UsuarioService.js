import axios from 'axios';

// Aquí debes colocar la URL de tu backend que maneja la creación de usuarios
const API_URL = 'http://localhost:8080/api/usuarios'; // Reemplázalo por la URL de tu backend

export const createUsuario = async (usuario) => {
    try {
        const response = await axios.post(API_URL, usuario);
        return response; // Retorna la respuesta del backend
    } catch (error) {
        console.error('Error al crear el usuario:', error);
        throw error; // Lanza el error para ser manejado en el componente
    }
};