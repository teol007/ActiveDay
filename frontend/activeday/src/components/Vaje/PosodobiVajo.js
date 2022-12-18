import { Button, Checkbox, TextField } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import api from "../../services/api";

const PosodobiVajo = () => {

    const vajaId = useParams().id;

    useEffect(() => {
        const pridobiVajo = (vajaId) => {
            api.get("/vaja/"+vajaId).then((result) => {
                console.log(result);

                setNaziv(result.data.naziv);
                setOpis(result.data.opis);
                setStPonovitev(result.data.stPonovitev);
                setCasTrajanja(result.data.casTrajanja);
                setStanje(result.data.stanje);
            });
        }
        pridobiVajo(vajaId);
    }, [vajaId]);

    const [naziv, setNaziv] = useState("");
    const [opis, setOpis] = useState("");
    const [stPonovitev, setStPonovitev] = useState(1);
    const [casTrajanja, setCasTrajanja] = useState(0);
    const [stanje, setStanje] = useState(false);
    let navigate = useNavigate();

    const posodobiVajo = () => {
        api.post("/vaja", {
            id: vajaId,
            naziv: naziv,
            opis: opis,
            stPonovitev: stPonovitev,
            casTrajanja: casTrajanja,
            stanje: stanje
        }).then((result) => console.log(result.data));
    }

    return (
        <div>
            <Button variant="contained" onClick={() => navigate("/vadbe")}>Nazaj na vadbe</Button>
            <p>Posodabljanje vaje</p>
            <TextField label={"Naziv"} variant="outlined" value={naziv} onChange={(event) => setNaziv(event.target.value)}/><br />
            <TextField label={"Opis"} variant="outlined" value={opis} onChange={(event) => setOpis(event.target.value)}/><br />
            <TextField label={"Število ponovitev"} variant="outlined" value={stPonovitev} onChange={(event) => setStPonovitev(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <TextField label={"Čas trajanja (sec)"} variant="outlined" value={casTrajanja} onChange={(event) => setCasTrajanja(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <Checkbox label={"Stanje"} checked={stanje} onChange={(event) => setStanje(event.target.checked)}/> Opravljeno <br />
            <Button variant="contained" onClick={posodobiVajo}>Posodobi</Button>
        </div>
    );
}
export default PosodobiVajo;
