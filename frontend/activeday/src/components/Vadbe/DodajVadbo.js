
import { Button, Checkbox, TextField } from "@mui/material";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";

const DodajVadbo = () => {
    const [naziv, setNaziv] = useState("");
    const [stIntervalov, setStIntervalov] = useState(1);
    const [stanje, setStanje] = useState(false);
    const [javno, setJavno] = useState(false);
    let navigate = useNavigate();

    const dodajVadbo = () => {
        api.post("/vadba", {
            naziv: naziv,
            stIntervalov: stIntervalov,
            stanje: stanje,
            javno: javno
        }).then((result) => console.log(result.data));
    }

    return (
        <div>
            <Button variant="contained" onClick={() => navigate("/vadbe")}>Nazaj na vadbe</Button>
            <p>Dodajanje vadbe</p>
            <TextField label={"Naziv"} variant="outlined" value={naziv} onChange={(event) => setNaziv(event.target.value)}/><br />
            <TextField label={"Število intervalov"} variant="outlined" value={stIntervalov} onChange={(event) => setStIntervalov(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <Checkbox label={"Stanje"} checked={stanje} onChange={(event) => setStanje(event.target.checked)}/> Opravljeno <br />
            <Checkbox label={"Javno"} checked={javno} onChange={(event) => setJavno(event.target.checked)}/> Objavi javno <br />
            <Button variant="contained" onClick={dodajVadbo}>Dodaj</Button>
        </div>
    );
}
export default DodajVadbo;
