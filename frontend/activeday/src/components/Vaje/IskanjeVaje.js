
import { Button, TextField } from "@mui/material";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";
import VajeTabela from "./VajeTabela";

const IsciVajo = () => {
    const [naziv, setNaziv] = useState("");
    const [maxStPonovitev, setStPonovitev] = useState(1);
    const [maxCasTrajanja, setCasTrajanja] = useState(0);
    let navigate = useNavigate();

    const [iskaneVaje, setIskaneVaje] = useState([]);
    
    const isciVajo = () => {
        api.get(`/vaja/naziv/${naziv}/ponovitve/${maxStPonovitev}/maxTrajanje/${maxCasTrajanja}`).then((result) => {
            setIskaneVaje(result.data);
            console.log(result);
        })
    }

    return (
        <div>
            <Button variant="contained" onClick={() => navigate("/vaje")}>Nazaj na vse vaje</Button>
            <p>Iskanje vaj</p>
            <TextField label={"Približen naziv"} variant="outlined" value={naziv} onChange={(event) => setNaziv(event.target.value)}/><br />
            <TextField label={"Maksimalno število ponovitev"} variant="outlined" value={maxStPonovitev} onChange={(event) => setStPonovitev(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <TextField label={"Maksimalen čas trajanja (sec)"} variant="outlined" value={maxCasTrajanja} onChange={(event) => setCasTrajanja(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <Button variant="contained" onClick={isciVajo}>Poišči</Button>

            <VajeTabela vaje={iskaneVaje} />
        </div>
    );
}
export default IsciVajo;
