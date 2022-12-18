import React, { useEffect, useState } from "react";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useParams } from "react-router-dom";
import api from "../../services/api";

const PraviceUporabnika = function () {
    const uporabnikId = useParams().id;

    const [rolesUporabnika, setRolesUporabnika] = useState([]);
    useEffect(() => {
        const pridobiUporabnika = (uporabnikId) => {
            api.get("/uporabnik/"+uporabnikId).then((result) => {
                setRolesUporabnika(result.data.roles);
                console.log(result);
            });
        }
        pridobiUporabnika(uporabnikId);
    }, [uporabnikId]);

    return (
        <>  
            <h1>Pravice uporabnika</h1>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                    <TableRow>
                        <TableCell>Id</TableCell>
                        <TableCell align="right">Vloga</TableCell>
                        <TableCell align="right">Privilegiji</TableCell>
                    </TableRow>
                    </TableHead>
                    <TableBody>
                    {rolesUporabnika.map((roles) => (
                        <TableRow
                        key={roles.id}
                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                        >
                            <TableCell component="th" scope="row">
                                {roles.id}
                            </TableCell>
                            <TableCell align="right">{roles.naziv}</TableCell>
                            <TableCell align="right">
                                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                                    <TableBody>
                                        {roles.privileges.map((uporabnik1) => (
                                            <TableRow
                                            key={uporabnik1.id}
                                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                            >
                                                <TableCell align="right">{uporabnik1.naziv}</TableCell>
                                            </TableRow>
                                        ))}
                                    </TableBody>
                                </Table>
                            </TableCell>
                        </TableRow>
                    ))}
                    </TableBody>
                </Table>
                </TableContainer>
        </>
    );
}
export default PraviceUporabnika;
