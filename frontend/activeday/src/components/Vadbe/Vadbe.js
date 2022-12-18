import { Button } from "@mui/material";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../services/api";
import VadbeTable from "./VadbeTabela";

const Vadbe = () => {
    const [vadbe, setVadbe] = useState([]);
    useEffect(() => {
        const pridobiVadbe = () => {
            api.get("/vadba").then((result) => {
                setVadbe(result.data);
                console.log(result);
            });
        }
        pridobiVadbe();
    }, []);
    return (
        <>
            <h1>Vadbe</h1>
            <Link to="/vadbe/dodaj"><Button variant="contained">Dodaj vadbo</Button></Link>
            <VadbeTable vadbe={vadbe} />
        </>
    );
}
export default Vadbe;