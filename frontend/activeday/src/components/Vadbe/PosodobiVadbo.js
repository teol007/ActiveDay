import { Button, Checkbox, TextField } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import api from "../../services/api";

const PosodobiVadbo = () => {

    const vadbaId = useParams().id;

    const [vadba, setVadba] = useState({}); 
    useEffect(() => {
        const pridobiVadbo = (vajaId) => {
            api.get("/vadba/"+vajaId).then((result) => {
                setVadba(result.data);
                console.log(result);

                setNaziv(result.data.naziv);
                setStIntervalov(result.data.stIntervalov);
                setStanje(result.data.stanje);
                setJavno(result.data.javno);
            });
        }
        pridobiVadbo(vadbaId);
    }, [vadbaId]);

    const [naziv, setNaziv] = useState("");
    const [stIntervalov, setStIntervalov] = useState(1);
    const [stanje, setStanje] = useState(false);
    const [javno, setJavno] = useState(false);
    let navigate = useNavigate();

    const posodobiVadbo = () => {
        api.post("/vadba", {
            id: vadbaId,
            casObjave: vadba.casObjave,
            vaje: vadba.vaje,
            ocene: vadba.ocene,
            komentarji: vadba.komentarji,
            naziv: naziv,
            stIntervalov: stIntervalov,
            javno: stanje,
            stanje: stanje
        }).then((result) => console.log(result.data));
    }

    return (
        <div>
            <Button variant="contained" onClick={() => navigate("/vadbe")}>Nazaj na vadbe</Button>
            <p>Posodabljanje vadbe</p>
            <TextField label={"Naziv"} variant="outlined" value={naziv} onChange={(event) => setNaziv(event.target.value)}/><br />
            <TextField label={"Število intervalov"} variant="outlined" value={stIntervalov} onChange={(event) => setStIntervalov(event.target.value)} inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }}/><br />
            <Checkbox label={"Stanje"} checked={stanje} onChange={(event) => setStanje(event.target.checked)}/> Opravljeno <br />
            <Checkbox label={"Javno"} checked={javno} onChange={(event) => setJavno(event.target.checked)}/> Javno objavljeno <br />
            <Button variant="contained" onClick={posodobiVadbo}>Posodobi</Button>
        </div>
    );
}
export default PosodobiVadbo;
