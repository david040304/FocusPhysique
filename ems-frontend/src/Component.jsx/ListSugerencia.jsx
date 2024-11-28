import React, {useEffect, useState} from 'react'
import { listSugerencia } from '../services/SugerenciaService'

export const ListSugerencia = () => {

    const [Sugerencias, setSugerencias] = useState([])

    useEffect(() => {
        listSugerencia().then(Response => {
            setSugerencias(Response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    return (
        <div className='container'>
            <h2 className='text-center'>List of Sugerencias</h2>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Sugerencia Id</th>
                        <th>Descripcion Sugerencia</th>
                        <th>TipoDesugerencia </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        Sugerencias.map(sugerencia =>
                            <tr key={sugerencia.idSugerencia}>
                                <td>{sugerencia.idSugerencia}</td>
                                <td>{sugerencia.Descripcion}</td>
                                <td>{sugerencia.TipoDesugerencia}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
