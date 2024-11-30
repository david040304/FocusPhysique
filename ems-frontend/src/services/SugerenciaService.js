import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/Sugerencia';

export const listSugerencia = () => axios.get(REST_API_BASE_URL);

export const createSugerencia = (sugerencia) => axios.post(REST_API_BASE_URL, sugerencia);

export const getSugerencia = (idSugerencia) => axios.get(REST_API_BASE_URL + '/' + idSugerencia);

export const updateSugerencia = (idSugerencia, sugerencia) => axios.put(REST_API_BASE_URL + '/' + idSugerencia, sugerencia);

export const deleteSugerencia = (idSugerencia) => axios.delete(REST_API_BASE_URL + '/' + idSugerencia)