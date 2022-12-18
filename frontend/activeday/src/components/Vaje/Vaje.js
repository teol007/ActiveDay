import { Button } from "@mui/material";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../services/api";
import VajeTabela from "./VajeTabela";

const Vaje = () => {
    const [vaje, setVaje] = useState([]);
    useEffect(() => {
        const pridobiVaje = () => {
            api.get("/vaja").then((result) => {
                setVaje(result.data);
                console.log(result);
            });
        }
        pridobiVaje();
    }, []);
    return (
        <>
            <h1>Vaje</h1>
            <Link to="/vaje/dodaj"><Button variant="contained">Dodaj vajo</Button></Link>
            <VajeTabela vaje={vaje} />
        </>
    );
}
export default Vaje;
