
import { Button, Checkbox, TextField } from "@mui/material";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import api from "../../services/api";

const DodajVajo = () => {
    const [naziv, setNaziv] = useState("");
    const [opis, setOpis] = useState("");
    const [stPonovitev, setStPonovitev] = useState(1);
    const [casTrajanja, setCasTrajanja] = useState(0);
    const [stanje, setStanje] = useState(false);
    let navigate = useNavigate();
    
    const dodajVajo = (vadbaId) => {
        api.post("/vadba/"+vadbaId+"/vaja", {
            naziv: naziv,
            opis: opis,
            stPonovitev: stPonovitev,
            casTrajanja: casTrajanja,
            stanje: stanje
        }).then((result) => console.log(result.data));
    }
    
    const vadbaId = useParams().id;
    return (
        <div>
            <Button variant="contained" onClick={() => navigate("/vadbe")}>Nazaj na vadbe</Button>
            <p>Dodajanje vaje</p>
            <TextField label={"Naziv"} variant="outlined" value={naziv} onChange={(event) => setNaziv(event.target.value)}/><br />
            <TextField label={"Opis"} variant="outlined" value={opis} onChange={(event) => setOpis(event.target.value)}/><br />
            <TextField label={"Število ponovitev"} variant="outlined" value={stPonovitev} onChange={(event) => setStPonovitev(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <TextField label={"Čas trajanja (sec)"} variant="outlined" value={casTrajanja} onChange={(event) => setCasTrajanja(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <Checkbox label={"Stanje"} checked={stanje} onChange={(event) => setStanje(event.target.checked)}/> Opravljeno <br />
            <Button variant="contained" onClick={() =>{dodajVajo(vadbaId)}}>Dodaj</Button>
        </div>
    );
}
export default DodajVajo;
