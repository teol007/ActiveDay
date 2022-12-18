import { Button } from "@mui/material";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../services/api";
import VajeTabela from "./VajeTabela";

const VajeVadbe = function ({vadbaId}) {
    const [vaje, setVaje] = useState([]);
    useEffect(() => {
        const pridobiVaje = (vadbaId) => {
            api.get("/vadba/"+vadbaId).then((result) => {
                setVaje(result.data.vaje);
                console.log(result);
            });
        }
        pridobiVaje(vadbaId);
    }, [vadbaId]);

    const link = "/vadbe/"+vadbaId+"/dodajVajoVadbi";
    return (
        <>
            <Link to={link}><Button variant="contained">Dodaj vajo</Button></Link>
            <VajeTabela vaje={vaje} />
        </>
    );
}
export default VajeVadbe;
