import React, {useEffect, useState} from 'react'
import { deleteSugerencia, listSugerencia } from '../services/SugerenciaService'
import { useNavigate } from 'react-router-dom'

export const ListSugerencia = () => {

    const [Sugerencias, setSugerencias] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        getAllSugerencias(";")
    }, [])

    function getAllSugerencias() {
        listSugerencia().then(Response => {
            setSugerencias(Response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewSugerencia() {
        navigator('/add-sugerencia')
    }

    function updateSugerencia(idSugerencia) {
        navigator(`/edit-sugerencia/${idSugerencia}`)
    }

    function removeSugerencia(idSugerencia){
        console.log(idSugerencia);

        deleteSugerencia(idSugerencia).then((Response) => {
            getAllSugerencias();
        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center'>List of Sugerencias</h2>
            <button className='btn btn-primary mb-2' onClick={addNewSugerencia}>Add Sugerencia</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Sugerencia Id</th>
                        <th>Descripcion Sugerencia</th>
                        <th>TipoDesugerencia</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        Sugerencias.map(sugerencia =>
                            <tr key={sugerencia.idSugerencia}>
                                <td>{sugerencia.idSugerencia}</td>
                                <td>{sugerencia.descripcion}</td>
                                <td>{sugerencia.tipoSugerencia}</td>
                                <td>
                                    <button className='btn btn-info' onClick={() => updateSugerencia(sugerencia.idSugerencia)}>Update</button>
                                    <button className='btn btn-danger' onClick={() => removeSugerencia(sugerencia.idSugerencia)}
                                        style={{marginLeft: '10px'}}
                                    >Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
