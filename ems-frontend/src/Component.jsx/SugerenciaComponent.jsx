import React, { useEffect, useState } from 'react'
import { createSugerencia, getSugerencia, updateSugerencia } from '../services/SugerenciaService'
import { useNavigate, useParams } from 'react-router-dom';

function SugerenciaComponent() {

    const [descripcion, setDescirpcion] = useState('')
    const [tipoSugerencia, setTipoSugerencia] = useState('')

    const {idSugerencia} = useParams();
    const [errors, setErrors] = useState({
        descripcion : '',
        tipoSugerencia : ''
    })

    const navigator = useNavigate();

    useEffect(() => {
        if(idSugerencia){
            getSugerencia(idSugerencia).then((Response) => {
                setDescirpcion(Response.data.descripcion)
                setTipoSugerencia(Response.data.tipoSugerencia)
            }).catch(error => {
                console.error(error);
            })
        }
    }, [idSugerencia])


    function saveOrUpdateSugerencia(e) {
        e.preventDefault();
        if(validateFrom()){
            const sugerencia = {descripcion, tipoSugerencia}
            console.log(sugerencia)
            if(idSugerencia){
                updateSugerencia(idSugerencia, sugerencia).then((Response) => {
                    console.log(Response.data);
                    navigator('/Sugerencia');
                }).catch(error => {
                    console.error(error);
                })
            } else {
                createSugerencia(sugerencia).then((Response) => {
                    console.log(Response.data);
                    navigator('/Sugerencia')
                }).catch(error => {
                    console.error(error);
                })
            }
        }
    }

    function validateFrom() {
        let valid = true;
        const errorsCopy = {... errors}

        if (descripcion.trim()){
            errorsCopy.descripcion = '';
        } else {
            errorsCopy.descripcion = 'Descripcion es requerida';
            valid = false;
        }

        if(tipoSugerencia.trim()){
            const errorsCopy = {... errors}
        } else {
            errorsCopy.tipoSugerencia = 'Tipo de sugerencia es requerida';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }

    function pageTitle() {
        if(idSugerencia){
            return <h2 className='text-center'>Update sugerencia</h2>
        }else {
            return <h2 className='text-center'>Add sugerencia</h2>
        }
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {
                        pageTitle()
                    }
                    <div className='card-body'>
                        <form>
                            <div className='mb-3'>
                                <label className='form-label'>Descripcion</label>
                                <textarea 
                                    type="text"
                                    placeholder='Enter Descripcion de la sugerencia'
                                    name='descripcion'
                                    value={descripcion}
                                    className={`form-control ${errors.descripcion ? 'is-invalid': ''}`}
                                    onChange={(e) => setDescirpcion(e.target.value)}
                                    rows="3"
                                />
                                {errors.descripcion && <div className='invalid-feedback'>{errors.descripcion}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <select className={`form-select-lg  ${errors.tipoSugerencia ? 'is-invalid': ''}`}
                                value={tipoSugerencia}
                                onChange={(e) => setTipoSugerencia(e.target.value)}
                                >
                                    <option value= "">Seleccionar</option>
                                    <option value="Alimentacion">Alimentación</option>
                                    <option value="Entrenamiento">Entrenamiento</option>
                                    <option value="Descanso">Descanso</option>
                                </select>
                                {errors.tipoSugerencia && <div className='invalid-feedback'>{errors.tipoSugerencia}</div>}
                            </div>
                            <button className='btn btn-success' onClick={saveOrUpdateSugerencia}>Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default SugerenciaComponent